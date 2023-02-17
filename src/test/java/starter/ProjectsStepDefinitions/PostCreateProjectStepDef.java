package starter.ProjectsStepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Projects.ProjectsAPI;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateProjectStepDef {
    @Steps
    ProjectsAPI projectsAPI;

    //Scenario1
    @Given("Post create a new project with valid name and listed color in json body")
    public void postCreateANewProjectWithValidNameAndListedColorInJsonBody() {
        File json = new File(ProjectsAPI.JSON_REQ_BODY+"/CreateNewProjectS1.json");
        projectsAPI.postCreateNewProject(json);
    }
    @When("Send post create project request")
    public void sendPostCreateProjectRequest() {

        SerenityRest.when().post(ProjectsAPI.CREATE_NEW_PROJECT);
    }

    @And("Response body should contain name {string} and color {string}")
    public void responseBodyShouldContainNameAndColor(String name, String color) {
        SerenityRest.then()
                .body("name",equalTo(name))
                .body("color",equalTo(color));
    }
    @And("Validate create project json schema validator with valid name and listed color")
    public void validateCreateProjectJsonSchemaValidatorWithValidNameAndListedColor() {
        File json = new File(ProjectsAPI.JSON_SCHEMA+"/PostCreate1JSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //scenario2
    @Given("Post create a new project with valid name and listed view_style in json body")
    public void postCreateANewProjectWithValidNameAndListedView_styleInJsonBody() {
        File json = new File(ProjectsAPI.JSON_REQ_BODY+"/CreateNewProjectS2.json");
        projectsAPI.postCreateNewProject(json);
    }

    @And("Response body should contain name {string} and view_style {string}")
    public void responseBodyShouldContainNameAndView_style(String name, String view_style) {
        SerenityRest.then()
                .body("name",equalTo(name))
                .body("view_style",equalTo(view_style));
    }
    @And("Validate create project json schema validator with valid name and listed view_style")
    public void validateCreateProjectJsonSchemaValidatorWithValidNameAndListedView_style() {
        File json = new File(ProjectsAPI.JSON_SCHEMA+"/PostCreate2JSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //scenario3
    @Given("Post create a new project without name in json body")
    public void postCreateANewProjectWithoutNameInJsonBody() {
        File json = new File(ProjectsAPI.JSON_REQ_BODY+"/CreateNewProjectS3.json");
        projectsAPI.postCreateNewProject(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

}
