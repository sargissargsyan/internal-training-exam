import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public class LoginTest extends TestBase {
    @Test
    public void loginViaApi() {
        LoginPage taigaLoginPage = new LoginPage();
        login("training@gmail.com", "Tumo123!");
        HomePage homePage = new HomePage();
        homePage.clickProjectsIcon();

        assertTrue(homePage.getCurrentUrl().contains("projects"),
                "URL is not correct");
    }
}
