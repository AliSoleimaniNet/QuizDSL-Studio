using Hangfire;
using Microsoft.AspNetCore.Mvc;
using ModelManager.Models;
using System.Text;
using System.Text.RegularExpressions;

namespace ModelManager.Controllers
{
    public class HomeController : Controller
    {
        private readonly ModelStorageService _storage;
        private readonly IBackgroundJobClient _jobClient;

        public HomeController(ModelStorageService storage, IBackgroundJobClient jobClient)
        {
            _storage = storage;
            _jobClient = jobClient;
        }

        public IActionResult Index() => View(_storage.GetAllModels());

        [HttpGet("{name}")]
        public IActionResult GetModelDetails(string name) => Json(_storage.GetModel(name));

        [HttpGet("Home/GetModelImages/{name}")]
        public IActionResult GetModelImages(string name)
        {
            var results = _storage.GetModelRequiredImages(name);
            return Ok(results);
        }

        [HttpPost("Home/UploadModelImage")]
        public async Task<IActionResult> UploadModelImage(string modelName, string fileName, IFormFile file)
        {
            if (file == null || file.Length == 0) return BadRequest("No file uploaded.");

            await _storage.SaveImageAsync(modelName, fileName, file);
            return Ok();
        }


        [HttpPost]
        public async Task<IActionResult> Save([FromBody] QuizSaveRequest request)
        {
            if (request?.Info == null) return BadRequest();
            await _storage.SaveModelAsync(request.Info, request.QuizContent);
            return Ok();
        }

        [HttpDelete]
        public IActionResult Delete(string name)
        {
            _storage.DeleteModel(name);
            return Ok();
        }


        [HttpPost]
        public IActionResult GenerateByAi(string modelName, string prompt)
        {
            _jobClient.Enqueue<QuizBackgroundService>(x => x.GenerateWithAiJob(modelName, prompt));
            return Ok();
        }

        [HttpPost]
        public IActionResult Build(string modelName)
        {
            _jobClient.Enqueue<QuizBackgroundService>(x => x.BuildModelJob(modelName));
            return Ok();
        }

        [HttpPost]
        public IActionResult Run(string modelName)
        {
            _jobClient.Enqueue<QuizBackgroundService>(x => x.RunAndScreenshotJob(modelName));
            Thread.Sleep(5000);
            return Redirect("http://127.0.0.1:5000/");
        }


        [HttpGet]
        public IActionResult GetLiveLogs() => Json(new
        {
            ai = QuizBackgroundService.LiveLogs["AI"].ToString(),
            build = QuizBackgroundService.LiveLogs["Build"].ToString(),
            run = QuizBackgroundService.LiveLogs["Run"].ToString()
        });

        [HttpPost]
        public IActionResult StopJob(string type)
        {
            if (type == "All") QuizBackgroundService.StopAllProcesses();
            else QuizBackgroundService.CancelJob(type);
            return Ok();
        }
    }
}