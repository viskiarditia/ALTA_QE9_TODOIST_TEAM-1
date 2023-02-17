package starter.ProjectsStepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Projects.ProjectsAPI;

public class DeleteStepDef {
    @Steps
    ProjectsAPI projectsAPI;
    @Given("Delete a project with valid id {long}")
    public void deleteAProjectWithValidIdId(long id) {
        projectsAPI.deleteProject(id);
    }

    @When("Send request to delete a project")
    public void sendRequestToDeleteAProject() {
        SerenityRest.when().delete(ProjectsAPI.DELETE_PROJECT);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
    //delete with invalid id
    @Given("Delete project with invalid id {string}")
    public void deleteProjectWithInvalidIdId(String id) {
        projectsAPI.deleteInvalidProject(id);

    }
}

