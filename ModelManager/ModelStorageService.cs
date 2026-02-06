using ModelManager.Models;
using System;
using System.Collections.Generic;
using System.Text;
using System.Text.Json;

namespace ModelManager
{
    using System.Text.RegularExpressions;

    public class ModelStorageService
    {
        private readonly string _basePath;

        public ModelStorageService(IWebHostEnvironment env)
        {
            _basePath = Path.Combine(env.WebRootPath, "models");
            if (!Directory.Exists(_basePath)) Directory.CreateDirectory(_basePath);
        }


        public List<ImageResourceInfo> GetModelRequiredImages(string modelName)
        {
            var folderPath = Path.Combine(_basePath, modelName);
            var quizPath = Path.Combine(folderPath, $"{modelName}.quiz");
            var resources = new List<ImageResourceInfo>();

            if (!File.Exists(quizPath)) return resources;

            var content = File.ReadAllText(quizPath);
            var matches = Regex.Matches(content, @"\""([^\""]+\.(png|jpg|jpeg|gif))\""");

            var uniqueNames = matches.Cast<Match>()
                .Select(m => m.Groups[1].Value)
                .Distinct();

            foreach (var imgName in uniqueNames)
            {
                resources.Add(new ImageResourceInfo
                {
                    Name = imgName,
                    // مسیر برای فرانت: /models/ModelName/image.png
                    Path = $"/models/{modelName}/{imgName}",
                    Exists = File.Exists(Path.Combine(folderPath, imgName))
                });
            }

            return resources;
        }

        public async Task SaveImageAsync(string modelName, string fileName, IFormFile file)
        {
            var folderPath = Path.Combine(_basePath, modelName);
            if (!Directory.Exists(folderPath)) Directory.CreateDirectory(folderPath);

            var safeFileName = Path.GetFileName(fileName);
            var fullPath = Path.Combine(folderPath, safeFileName);

            using (var stream = new FileStream(fullPath, FileMode.Create))
            {
                await file.CopyToAsync(stream);
            }
        }


        public List<QuizModelInfo> GetAllModels()
        {
            var models = new List<QuizModelInfo>();
            if (!Directory.Exists(_basePath)) return models;

            foreach (var dir in Directory.GetDirectories(_basePath))
            {
                var folderName = Path.GetFileName(dir);
                var jsonPath = Path.Combine(dir, "model.json");

                if (File.Exists(jsonPath))
                {
                    var jsonContent = File.ReadAllText(jsonPath);
                    var info = JsonSerializer.Deserialize<QuizModelInfo>(jsonContent) ?? new QuizModelInfo();

                    var mainImgPath = Path.Combine(dir, $"{folderName}.jpg");
                    info.ImagePath = File.Exists(mainImgPath) ? $"/models/{folderName}/{folderName}.jpg" : null;

                    models.Add(info);
                }
            }
            return models;
        }

        public async Task SaveModelAsync(QuizModelInfo info, string quizContent)
        {
            var folderPath = Path.Combine(_basePath, info.Name);
            if (!Directory.Exists(folderPath)) Directory.CreateDirectory(folderPath);

            var jsonPath = Path.Combine(folderPath, "model.json");
            var jsonString = JsonSerializer.Serialize(info, new JsonSerializerOptions { WriteIndented = true });
            await File.WriteAllTextAsync(jsonPath, jsonString);

            var quizPath = Path.Combine(folderPath, $"{info.Name}.quiz");
            await File.WriteAllTextAsync(quizPath, quizContent);
        }

        public void DeleteModel(string modelName)
        {
            var folderPath = Path.Combine(_basePath, modelName);
            if (Directory.Exists(folderPath))
                Directory.Delete(folderPath, true);
        }

        public QuizModelInfo GetModel(string name)
        {
            var folderPath = Path.Combine(_basePath, name);
            var jsonPath = Path.Combine(folderPath, "model.json");
            var quizPath = Path.Combine(folderPath, $"{name}.quiz");

            if (!File.Exists(jsonPath)) return null;

            var jsonContent = File.ReadAllText(jsonPath);
            var info = JsonSerializer.Deserialize<QuizModelInfo>(jsonContent);

            if (File.Exists(quizPath))
                info.QuizContent = File.ReadAllText(quizPath);

            return info;
        }

        public async Task SaveModelJsonOnlyAsync(QuizModelInfo info)

        {

            var folderPath = Path.Combine(_basePath, info.Name);

            var jsonPath = Path.Combine(folderPath, "model.json");

            var jsonString = JsonSerializer.Serialize(info, new JsonSerializerOptions { WriteIndented = true });

            await File.WriteAllTextAsync(jsonPath, jsonString);

        }
    }

    public class ImageResourceInfo
    {
        public string Name { get; set; }
        public string Path { get; set; }
        public bool Exists { get; set; }
    }
}
