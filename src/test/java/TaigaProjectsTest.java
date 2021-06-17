import api.ApiClient;
import api.ApiHelper;
import base.PageBase;
import base.TestBase;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;

import static org.testng.Assert.assertEquals;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public class TaigaProjectsTest  extends TestBase {
    private JsonObject project;
    private JsonObject issue;
    private JsonArray allProjects;

    @BeforeMethod
    public void setUpMethod() {
        ApiClient.login("training@gmail.com", "Tumo123!");
        allProjects = ApiHelper.getAllProjects();
        project = ApiHelper.createProject();

    }

    @AfterMethod
    public void tearDownMethod() {
        if (issue != null) {
            ApiHelper.deleteIssue(issue);
        }
        if (project != null) {
            ApiHelper.deleteProject(project);
        }

        if (allProjects.size() > 1) {
            for (int i = 0; i < allProjects.size(); i++) {
                ApiHelper.deleteProject((JsonObject) allProjects.get(i));
            }
        }
    }

    @Test
    public void projectPage() {
        issue = ApiHelper.createIssue(project.get("id").getAsInt());
        login("training@gmail.com", "Tumo123!");
        ProjectPage projectPage = (ProjectPage) new ProjectPage(project).get();
        assertEquals(projectPage.getProjectName(), project.get("name").getAsString(), "Opened Project Page is incorrect!");

    }


}
