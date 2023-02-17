package starter.Projects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Projects.ProjectsAPI;
import starter.Utils.TodoistURL;

public class DeleteStepDef {
    @Steps
    ProjectsAPI projectsAPI;
    @Given("Delete a project with valid id {long}")
    public void deleteAProjectWithValidIdId(long id) {
        projectsAPI.deleteProject(id);
    }

    @When("Send request to delete a project")
    public void sendRequestToDeleteAProject() {
        SerenityRest.when().delete(TodoistURL.DELETE_PROJECT);
    }

    //delete with invalid id
    @Given("Delete project with invalid id {string}")
    public void deleteProjectWithInvalidIdId(String id) {
        projectsAPI.deleteInvalidProject(id);

    }
}

