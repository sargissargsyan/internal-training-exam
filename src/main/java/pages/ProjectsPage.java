package pages;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public class ProjectsPage extends PageBase {
    @FindBy(css = "[title='Projects']")
    private WebElement projectsIcon;


    @Override
    public String getUrl() {
        return "https://tree.taiga.io/projects";
    }

    public ProjectsPage() {
        super();
        driver.get(getUrl());
    }

    public void clickProjectsIcon() {
        WaitHelper.getWait().waitForElementToBeVisible(projectsIcon);
        click(projectsIcon);
    }

}
