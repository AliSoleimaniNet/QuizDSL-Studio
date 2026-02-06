using System.Collections.Concurrent;
using System.Diagnostics;
using System.Text;
using ModelManager.Models;
using PuppeteerSharp;

namespace ModelManager
{
    public class QuizBackgroundService
    {
        private readonly ModelStorageService _storage;
        private readonly IWebHostEnvironment _env;

        public static ConcurrentDictionary<string, StringBuilder> LiveLogs = new()
        {
            ["AI"] = new StringBuilder(),
            ["Build"] = new StringBuilder(),
            ["Run"] = new StringBuilder()
        };

        public static ConcurrentDictionary<string, CancellationTokenSource> Tokens = new();
        private static Process _buildProcess;
        private static Process _runProcess;

        public QuizBackgroundService(ModelStorageService storage, IWebHostEnvironment env)
        {
            _storage = storage;
            _env = env;
        }

        public static void StopAllProcesses()
        {
            foreach (var key in Tokens.Keys) CancelJob(key);
            KillProcess(ref _buildProcess);
            KillProcess(ref _runProcess);
        }

        public static void CancelJob(string type)
        {
            if (Tokens.TryRemove(type, out var cts))
            {
                cts.Cancel();
                if (type == "Build") KillProcess(ref _buildProcess);
                if (type == "Run") KillProcess(ref _runProcess);
                LiveLogs[type].AppendLine("\n[SYSTEM]: Process terminated by user.");
            }
        }

        private static void KillProcess(ref Process p)
        {
            try { if (p != null && !p.HasExited) p.Kill(true); p = null; } catch { }
        }

        public async Task GenerateWithAiJob(string modelName, string prompt)
        {
            CancelJob("AI");
            var cts = new CancellationTokenSource();
            Tokens["AI"] = cts;
            var sb = LiveLogs["AI"].Clear().AppendLine($"[AI] Request for {modelName} started...");

            try
            {
                using var client = new HttpClient { Timeout = TimeSpan.FromMinutes(10) };
                var requestBody = new { model = "quiz-master:latest", prompt = prompt, stream = false };
                var response = await client.PostAsJsonAsync("http://localhost:11434/api/generate", requestBody, cts.Token);

                if (response.IsSuccessStatusCode)
                {
                    var result = await response.Content.ReadFromJsonAsync<System.Text.Json.JsonElement>(cancellationToken: cts.Token);
                    string aiResponse = result.GetProperty("response").GetString();
                    var info = _storage.GetModel(modelName);
                    await _storage.SaveModelAsync(info, aiResponse);
                    sb.AppendLine("[AI] Successfully generated and saved content.");
                }
                else { sb.AppendLine($"[ERROR] Ollama returned: {response.StatusCode}"); }
            }
            catch (Exception ex) { sb.AppendLine($"[CANCELLED/ERROR] {ex.Message}"); }
            finally { Tokens.TryRemove("AI", out _); }
        }

        public async Task BuildModelJob(string modelName)
        {
            CancelJob("Build");
            var cts = new CancellationTokenSource();
            Tokens["Build"] = cts;
            var sb = LiveLogs["Build"].Clear().AppendLine($"[BUILD] Compiling {modelName}...");

            var folderPath = Path.Combine(_env.WebRootPath, "models", modelName);
            var info = _storage.GetModel(modelName);

            _buildProcess = new Process
            {
                StartInfo = new ProcessStartInfo
                {
                    FileName = "java",
                    Arguments = $"-jar QuizCompiler.jar \"{Path.Combine(folderPath, modelName + ".quiz")}\" \"{Path.Combine(folderPath, "code")}\"",
                    RedirectStandardOutput = true,
                    RedirectStandardError = true,
                    UseShellExecute = false,
                    CreateNoWindow = true
                }
            };

            _buildProcess.OutputDataReceived += (s, e) => { if (e.Data != null) sb.AppendLine(e.Data); };
            _buildProcess.ErrorDataReceived += (s, e) => { if (e.Data != null) sb.AppendLine("ERR: " + e.Data); };

            _buildProcess.Start();
            _buildProcess.BeginOutputReadLine();
            _buildProcess.BeginErrorReadLine();

            try
            {
                await _buildProcess.WaitForExitAsync(cts.Token);
                info.LastCompilerOutput = sb.ToString();
                info.Status = sb.ToString().Contains("SUCCESS") ? "Success" : "Failed";
                await _storage.SaveModelJsonOnlyAsync(info);
            }
            catch { sb.AppendLine("[BUILD] Forcefully stopped."); }
            finally { Tokens.TryRemove("Build", out _); }
        }

        public async Task RunAndScreenshotJob(string modelName)
        {
            CancelJob("Run");
            KillProcessOnPort(5000);
            var cts = new CancellationTokenSource();
            Tokens["Run"] = cts;
            var sb = LiveLogs["Run"].Clear().AppendLine($"[RUN] Launching {modelName}...");

            var codePath = Path.Combine(_env.WebRootPath, "models", modelName, "code");

            _runProcess = new Process
            {
                StartInfo = new ProcessStartInfo
                {
                    FileName = "python",
                    Arguments = "app.py",
                    WorkingDirectory = codePath,
                    RedirectStandardOutput = true,
                    RedirectStandardError = true,
                    UseShellExecute = false,
                    CreateNoWindow = true
                }
            };

            _runProcess.OutputDataReceived += (s, e) => { if (e.Data != null) sb.AppendLine(e.Data); };
            _runProcess.ErrorDataReceived += (s, e) => { if (e.Data != null) sb.AppendLine(e.Data); };

            _runProcess.Start();
            _runProcess.BeginOutputReadLine();
            _runProcess.BeginErrorReadLine();

            try
            {
                await Task.Delay(5000, cts.Token);
                var browserFetcher = new BrowserFetcher();
                await browserFetcher.DownloadAsync();
                await using var browser = await Puppeteer.LaunchAsync(new LaunchOptions { Headless = true });
                await using var page = await browser.NewPageAsync();
                await page.SetViewportAsync(new ViewPortOptions { Width = 1280, Height = 720 });
                await page.GoToAsync("http://127.0.0.1:5000", WaitUntilNavigation.Networkidle0);
                await page.ScreenshotAsync(Path.Combine(_env.WebRootPath, "models", modelName, $"{modelName}.jpg"));
                sb.AppendLine("[RUN] App is alive and screenshot taken.");
            }
            catch { sb.AppendLine("[RUN] Process stopped."); }
        }

        private void KillProcessOnPort(int port)
        {
            try
            {
                var p = new Process
                {
                    StartInfo = new ProcessStartInfo
                    {
                        FileName = "cmd.exe",
                        Arguments = $"/c netstat -ano | findstr :{port}",
                        RedirectStandardOutput = true,
                        UseShellExecute = false,
                        CreateNoWindow = true
                    }
                };
                p.Start();
                string output = p.StandardOutput.ReadToEnd();
                if (!string.IsNullOrEmpty(output))
                {
                    foreach (var line in output.Split('\n'))
                    {
                        var parts = line.Trim().Split(' ', StringSplitOptions.RemoveEmptyEntries);
                        if (parts.Length > 4) Process.GetProcessById(int.Parse(parts.Last())).Kill();
                    }
                }
            }
            catch { }
        }
    }
}