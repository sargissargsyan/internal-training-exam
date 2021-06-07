package base;

import api.ApiClient;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import pages.LoginPage;
import setup.DriverHelper;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public class TestBase {
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
}