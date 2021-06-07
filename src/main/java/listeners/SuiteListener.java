package listeners;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public class SuiteListener implements ITestListener {
    public static final Logger LOG = Logger.getLogger(SuiteListener.class);
    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("Started -----> " + result.getMethod().getQualifiedName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("PASSED -----> " + result.getMethod().getQualifiedName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("FAILED -----> " + result.getMethod().getQualifiedName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info("SKIPPED -----> " + result.getMethod().getQualifiedName());

    }

}
