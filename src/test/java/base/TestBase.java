package base;

import api.ApiClient;
import com.google.gson.JsonObject;
import io.qameta.allure.Attachment;
import listeners.SuiteListener;
import org.apache.log4j.Logger;
import org.apache.tika.io.FilenameUtils;
import org.openqa.selenium.*;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import setup.DriverHelper;

import java.io.File;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
@Listeners(SuiteListener.class)
public class TestBase implements IHookable {
    private static final Logger LOGGER = Logger.getLogger(TestBase.class);
    private WebDriver driver = DriverHelper.get().getDriver();

    @AfterMethod
    public void tearDown() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }

    public void login(String username, String password) {
        LOGGER.info("Logging in via Api with username and password: "+ username + " " + password);
        JsonObject loginJson = ApiClient.login(username, password);
        new LoginPage();
        driver.manage().addCookie(new Cookie("cookieConsent", "1"));
        ((JavascriptExecutor) driver)
                .executeScript(
                        "window.localStorage.setItem('token','" + loginJson.get("auth_token") + "');");
        ((JavascriptExecutor) driver)
                .executeScript("window.localStorage.setItem('userInfo','" + loginJson + "');");
    }


    @Attachment(value = "Failure in Method {0}", type = "image/png")
    private byte[] takeScreenshot(String methodName) {
        return  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            takeScreenshot(testResult.getMethod().getMethodName());
        }
    }
}