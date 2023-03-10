package starter.Section;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Helper;
import starter.Utils.TodoistURL;

import java.io.File;

public class GetSingleSectionDef {
    @Steps
    starter.Section.featureSectionAPI featureSectionAPI;

    // Get Single Section valid id
    @Given("Get single section with valid {int}")
    public void getSingleSectionWithValidId(int id) {
        featureSectionAPI.setGetSingleSections(id);
    }
    @When("Send get single section request")
    public void sendGetSingleSectionRequest() {
        SerenityRest.when().get(TodoistURL.GET_SINGLE_SECTIONS);
    }

    @And("Response body single section page should be <page>")
    public void responseBodySingleSectionPageShouldBeId() {
    }

    @And("Validate get single section json schema")
    public void validateGetSingleSectionJsonSchema() {
        File json = new File(Helper.JSON_SCHEMA +"/GetSingleSectionSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Get Single Section invalid id
    @Given("Get single section with invalid id {string}")
    public void getSingleSectionWithInvalidId(String id) {
        featureSectionAPI.setGetSingleSectionsInvalidId(id);
    }

    @When("Send get single section invalid id request")
    public void sendGetSingleSectionInvalidIdRequest() {
        SerenityRest.when().get(TodoistURL.GET_SINGLE_SECTIONS);
    }

}
