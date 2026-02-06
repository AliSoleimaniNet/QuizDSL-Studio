using System;
using System.Collections.Generic;
using System.Text;

namespace ModelManager.Models
{
    public class QuizModelInfo
    {
        public string Name { get; set; } = string.Empty;
        public string UserPrompt { get; set; } = string.Empty;
        public string Status { get; set; } = "Unknown"; // Success, Failed, Unknown
        public string LastCompilerOutput { get; set; } = string.Empty;

        public string? ImagePath { get; set; }
        public string? QuizContent { get; set; }
    }
}
