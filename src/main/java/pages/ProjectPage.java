package pages;

import base.PageBase;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public class ProjectPage extends PageBase {
    private static final Logger LOGGER = Logger.getLogger("ProjectPage");
    @FindBy(css = ".intro-title .project-name")
    private WebElement projectName;

    private JsonObject project;
    public ProjectPage(JsonObject project) {
        super();
        this.project =  project;
        driver.get(getUrl());
    }
    @Override
    public String getUrl() {
        return "https://tree.taiga.io/project/"
                + project.get("slug").getAsString();
    }

    public String getProjectName(){
        WaitHelper.getWait().waitForElementToBeVisible(projectName);
        return projectName.getText();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        WaitHelper.getWait().waitForElementToBeVisible(By.cssSelector(".intro-title .project-name"));

    }
}
