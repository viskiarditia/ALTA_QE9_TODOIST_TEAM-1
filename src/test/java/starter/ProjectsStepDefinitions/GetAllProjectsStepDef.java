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

public class GetAllProjectsStepDef {
    @Steps
    ProjectsAPI projectsAPI;

    //Get All Project Positive Case
    @Given("Get all projects valid parameter")
    public void getAllProjectsValidParameter() {
        projectsAPI.getAllProjects();
    }

    @When("Send all projects request")
    public void sendAllProjects() {
        SerenityRest.when().get(ProjectsAPI.GET_ALL_PROJECTS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate get all projects json schema validator")
    public void validateGetAllProjectsJsonSchemaValidator() {
        File json = new File(ProjectsAPI.JSON_SCHEMA+"/GetAllProjectsJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Invalid Token Get All Project
    @Given("Get all projects with invalid token")
    public void getAllProjectsInvalidtoken() {
        projectsAPI.getAllProjectsInvalidToken();
    }
    @When("Send invalid token to get all projects")
    public void sendInvalidTokenToAllProjects() {
        SerenityRest.when().get(ProjectsAPI.GET_ALL_PROJECTS);
    }
    @Then("Status code should be {int} Unauthorize")
    public void statusCodeShouldBeUnauthorize(int Unauthorize) {
        SerenityRest.then().statusCode(Unauthorize);
    }

    //Invalid Path URL Get All Project
    @Given("Get all projects with invalid path url")
    public void getAllProjectsInvalidIdUrl() {
        projectsAPI.invalidGetAllProjects();
    }
    @When("Send invalid path url to get all projects request")
    public void sendInvalidAllProjects() {
        SerenityRest.when().get(ProjectsAPI.INVALID_GET_ALL_PROJECTS);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

}
