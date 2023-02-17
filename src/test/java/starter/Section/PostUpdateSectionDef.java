package starter.Section;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Helper;
import starter.Utils.TodoistRespone;
import starter.Utils.TodoistURL;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostUpdateSectionDef {

    @Steps
    starter.Section.featureSectionAPI featureSectionAPI;

    // Post Update Valid id
    @Given("Post update section with valid json with {int}")
    public void postUpdateSectionWithValidJsonWithId(int id) {
        File json = new File(Helper.JSON_REQ_BODY +"/PostUpdateSection.json");
        featureSectionAPI.setPostUpdateSection(id,json);
    }

    @When("Send post update section request")
    public void sendPostUpdateSectionRequest() {
        SerenityRest.when().post(TodoistURL.POST_UPDATE_SECTION);
    }

    @And("Response body page should be id {long}")
    public void responseBodyPageShouldBeId(Long id) {
        SerenityRest.then().body(TodoistRespone.ID,equalTo(id));
    }

    //Post Update Invalid id
    @Given("Post update section with invalid id {string}")
    public void postUpdateSectionWithInvalidId(String id) {
        File json = new File(Helper.JSON_REQ_BODY +"/PostUpdateSection.json");
        featureSectionAPI.setPostUpdateSectionInvalidId(id,json);
    }

    @When("Send post update section invalid request")
    public void sendPostUpdateSectionInvalidRequest() {
        SerenityRest.when().post(TodoistURL.POST_UPDATE_SECTION);
    }
}
