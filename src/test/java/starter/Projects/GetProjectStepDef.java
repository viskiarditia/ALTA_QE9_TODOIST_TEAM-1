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

public class GetProjectStepDef {
    @Steps
    ProjectsAPI projectsAPI;
    //Get a project with valid id positive case
    @Given("Get a project with valid id {long}")
    public void getAProjectWithValidId(long id) {
        projectsAPI.getValidProject(id);
    }
    @When("Send a get project request")
    public void sendAGetProjectRequest() {
        SerenityRest.when().get(TodoistURL.GET_PROJECT);
    }

    @And("Validate get a project with json schema validator")
    public void validateGetAProjectWithJsonSchemaValidator() {
        File json = new File(Helper.JSON_SCHEMA+"/GetProjectJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Get a project with invalid id negative case
    @Given("Get a project with invalid id {string}")
    public void getAProjectWithInvalidIdId(String id) {
        projectsAPI.getInvalidProject(id);
    }



}
