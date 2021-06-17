package pages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public class HomePage extends PageBase {
    @FindBy(css = "[title='Projects']")
    private WebElement projectsIcon;

    @Override
    public String getUrl() {
        return BASE_URL + "login";
    }

    public ProjectsPage clickProjectsIcon() {
        WaitHelper.getWait().waitForElementToBeVisible(projectsIcon);
        click(projectsIcon);
        return (ProjectsPage) new ProjectsPage();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
