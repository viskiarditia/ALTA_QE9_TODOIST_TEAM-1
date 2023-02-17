package starter.section;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostUpdateSectionDef {

    @Steps
    starter.section.featureSectionAPI featureSectionAPI;

    // Post Update Valid id
    @Given("Post update section with valid json with {int}")
    public void postUpdateSectionWithValidJsonWithId(int id) {
        File json = new File(starter.section.featureSectionAPI.JSON_REQ_BODY +"/PostUpdateSection.json");
        featureSectionAPI.setPostUpdateSection(id,json);
    }

    @When("Send post update section request")
    public void sendPostUpdateSectionRequest() {
        SerenityRest.when().post(starter.section.featureSectionAPI.POST_UPDATE_SECTION);
    }

    @Then("Status code update should create be {int} No Content")
    public void statusCodeUpdateShouldCreateBeNoContent(int NoContent) {
        SerenityRest.then().statusCode(NoContent);
    }

    @And("Response body page should be id {long}")
    public void responseBodyPageShouldBeId(Long id) {
        SerenityRest.then().body(featureSectionResponses.ID,equalTo(id));
    }

    //Post Update Invalid id
    @Given("Post update section with invalid id {string}")
    public void postUpdateSectionWithInvalidId(String id) {
        File json = new File(starter.section.featureSectionAPI.JSON_REQ_BODY +"/PostUpdateSection.json");
        featureSectionAPI.setPostUpdateSectionInvalidId(id,json);
    }

    @When("Send post update section invalid request")
    public void sendPostUpdateSectionInvalidRequest() {
        SerenityRest.when().post(starter.section.featureSectionAPI.POST_UPDATE_SECTION);
    }
}
