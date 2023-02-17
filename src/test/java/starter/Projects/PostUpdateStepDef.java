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

public class PostUpdateStepDef {
    @Steps
    ProjectsAPI projectsAPI;
    //Update Project
    @Given("Post update project with valid json body and valid id {long}")
    public void postUpdateProjectWithValidIdId(long id) {
        File json = new File(Helper.JSON_REQ_BODY+"/PostUpdateS1.json");
        projectsAPI.updateProject(id, json);
    }
    @When("Send post update project request")
    public void sendPostUpdateProjectRequest() {
        SerenityRest.when().post(TodoistURL.UPDATE_PROJECT);
    }

    @And("Validate update project json schema validator with valid name and listed color")
    public void validateUpdateProjectJsonSchemaValidatorWithValidNameAndListedColor() {
        File json = new File(Helper.JSON_SCHEMA+"/PostUpdateJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //update with invalid id
    @Given("Post update project with invalid id {string}")
    public void postUpdateProjectWithInvalidIdId(String id) {
        File json = new File(Helper.JSON_REQ_BODY+"/PostUpdateS1.json");
        projectsAPI.updateInvalidProject(id, json);
    }


}
