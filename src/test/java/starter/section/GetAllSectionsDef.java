package starter.section;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetAllSectionsDef {
    @Steps
    featureSectionAPI featureSectionAPI;

    // Get all Section valid project id
    @Given("Get all section with valid project {long}")
    public void getAllSectionWithValidProjectId(long id) {
        featureSectionAPI.setGetAllSections(id);
    }
    @When("Send get all section request")
    public void sendGetAllSectionRequest() {
        SerenityRest.when().get(featureSectionAPI.GET_ALL_SECTION);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    @And("Validate get all section json schema")
    public void validateGetAllSectionJsonSchema() {
        File json = new File(featureSectionAPI.JSON_SCHEMA +"/GetAllSectionSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Get all Section invalid project id
    @Given("Get all section with valid project {string}")
    public void getAllSectionWithValidProject(String id) {
        featureSectionAPI.setGetAllSectionsInvalidId(id);
    }

    @When("Send get all section invalid project id request")
    public void sendGetAllSectionInvalidProjectIdRequest() {
        SerenityRest.when().get(featureSectionAPI.GET_ALL_SECTION);
    }
}
