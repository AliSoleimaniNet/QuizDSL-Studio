package org.example.quiz.generator;

import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.example.quiz.QuizDSLStandaloneSetup;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class QuizCompiler {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: QuizCompiler <path_to_model.quiz> <output_directory>");
            System.exit(1);
        }

        String modelPath = args[0];
        String outputPath = args[1];

        // 1. تنظیمات اولیه برای اجرای مستقل (بدون اکلیپس)
        Injector injector = new QuizDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
        QuizCompiler compiler = injector.getInstance(QuizCompiler.class);

        try {
            compiler.compile(modelPath, outputPath);
            System.out.println("SUCCESS: Generation completed.");
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            System.exit(1);
        }
    }

    @Inject
    private Provider<ResourceSet> resourceSetProvider;

    @Inject
    private IResourceValidator validator;

    @Inject
    private QuizDSLGenerator generator; // ژنراتوری که قبلاً نوشتیم

    @Inject
    private JavaIoFileSystemAccess fileAccess;

    public void compile(String modelPath, String outputPath) throws Exception {
        ResourceSet rs = resourceSetProvider.get();
        Resource resource = rs.getResource(URI.createFileURI(modelPath), true);

        // 2. اعتبارسنجی (Validation) - پیدا کردن ارورهای گرامری
        List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
        if (!issues.isEmpty()) {
            System.err.println("Validation Errors found:");
            for (Issue issue : issues) {
                System.err.println(String.format("[%s] Line %d: %s", 
                    issue.getSeverity(), issue.getLineNumber(), issue.getMessage()));
            }
            throw new Exception("Validation failed. Check error log.");
        }

        // 3.
        fileAccess.setOutputPath(outputPath);
        generator.doGenerate(resource, fileAccess, new GeneratorContext());
    }
}