package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


/**
 * @author Sargis Sargsyan on 7/1/21
 * @project internal-training-exam
 */
public class RetryTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        retryTransformer(iTestAnnotation);
    }

    private void retryTransformer(ITestAnnotation iTestAnnotation) {
            iTestAnnotation.setRetryAnalyzer(Retry.class);
    }
}
