package listeners;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Sargis Sargsyan on 7/1/21
 * @project internal-training-exam
 */
public class Retry  implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 0;
    Logger LOGGER = Logger.getLogger("Retry");
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxRetryCount) {
            retryCount++;
            LOGGER.info("Retrying Test " + iTestResult.getName() + " with status "
                    + getResultStatusName(iTestResult.getStatus()) +
                    " for the " + retryCount + "times!") ;
            return true;
        }
        return false;
    }

    public String getResultStatusName (int status) {
        String resultName =null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 1)
            resultName = "SKIP";
        return resultName;
    }
}
