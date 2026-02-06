using Hangfire;
using Hangfire.MemoryStorage;
using ModelManager;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddControllersWithViews().AddRazorRuntimeCompilation();
builder.Services.AddSingleton<ModelStorageService>();
builder.Services.AddHangfire(config => config.UseMemoryStorage());
builder.Services.AddHangfireServer(options => { options.WorkerCount = 1; });

var app = builder.Build();

app.UseStaticFiles();
app.UseRouting();
app.UseHangfireDashboard("/hangfire");

app.MapControllerRoute(name: "default", pattern: "{controller=Home}/{action=Index}/{name?}");

// بستن پروسس‌ها هنگام خروج از اپلیکیشن
app.Lifetime.ApplicationStopping.Register(() => {
    QuizBackgroundService.StopAllProcesses();
});

app.Run("http://*:5005");