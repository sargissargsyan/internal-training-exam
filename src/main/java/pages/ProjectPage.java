package pages;

import base.PageBase;
import com.google.gson.JsonObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public class ProjectPage extends PageBase {
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
}
