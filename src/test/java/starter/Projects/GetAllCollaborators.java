package starter.Projects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Projects.ProjectsAPI;
import starter.Utils.Helper;
import starter.Utils.TodoistURL;

import java.io.File;

public class GetAllCollaborators {
    @Steps
    ProjectsAPI projectsAPI;
    @Given("Get all collaborators with valid id {long}")
    public void getAllCollaboratorsWithValidIdId(long id) {
        projectsAPI.getAllCollaborator(id);
    }

    @When("Send collaborator project request")
    public void sendCollaboratorProjectRequest() {
        SerenityRest.when().get(TodoistURL.GET_ALL_COLLABORATOR);
    }


    @And("Validate collaborator all project json schema validator")
    public void validateCollaboratorAllProjectJsonSchemaValidator() {
        File json = new File(Helper.JSON_SCHEMA+"/GetCollaboratorsJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
