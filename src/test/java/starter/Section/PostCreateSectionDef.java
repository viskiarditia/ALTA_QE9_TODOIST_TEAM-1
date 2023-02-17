package starter.Section;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Helper;
import starter.Utils.TodoistRespone;
import starter.Utils.TodoistURL;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class PostCreateSectionDef {

    @Steps
    starter.Section.featureSectionAPI featureSectionAPI;

    // Post Create Valid body
    @Given("Post new section with valid body")
    public void postNewSectionWithValidBody() {
        File json = new File(Helper.JSON_REQ_BODY + "/PostCreateSection.json");
        featureSectionAPI.setPostNewSection(json);
    }

    @When("Send post new section request")
    public void sendPostNewSectionRequest() {
        SerenityRest.when().post(TodoistURL.POST_NEW_SECTION);
    }

    @And("Response body page should contain project_id {int} and name {string}")
    public void responseBodyPageShouldContainProject_idProjectAndNameName(int project, String name) {
        SerenityRest.then().body(TodoistRespone.PROJECT, equalTo(project))
                .body(TodoistRespone.NAME, equalTo(name));
    }

    @And("Validate create section json schema")
    public void validateCreateSectionJsonSchema() {
        File json = new File(Helper.JSON_SCHEMA + "/CreateSectionSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Post Create invalid body Empty fill Field Name
    @Given("Post new section with invalid body Empty fill Field Name")
    public void postNewSectionWithInvalidBodyEmptyFillFieldName() {
        File json = new File(Helper.JSON_REQ_BODY + "/PostCreateSectionEmptyFillFieldName.json");
        featureSectionAPI.setPostNewSectionInvalid(json);
    }

    @When("Send post new section invalid request")
    public void sendPostNewSectionInvalidRequest() {
        SerenityRest.when().post(TodoistURL.POST_NEW_SECTION);
    }

    // Post Create invalid body without Field Name
    @Given("Post new section with invalid body without Field Name")
    public void postNewSectionWithInvalidBodyWithoutFieldName() {
        File json = new File(Helper.JSON_REQ_BODY + "/PostCreateSectionWithoutFieldName.json");
        featureSectionAPI.setPostNewSectionInvalid(json);
    }

    // Post Create invalid body Empty fill Field Project Id
    @Given("Post new section with invalid body Empty fill Field Project Id")
    public void postNewSectionWithInvalidBodyEmptyFillFieldProjectId() {
        File json = new File(Helper.JSON_REQ_BODY + "/PostCreateSectionEmptyFillFieldProjectId.json");
        featureSectionAPI.setPostNewSectionInvalid(json);
    }

    // Post Create invalid body without Field Project Id
    @Given("Post new section with invalid body without Field Project Id")
    public void postNewSectionWithInvalidBodyWithoutFieldProjectId() {
        File json = new File(Helper.JSON_REQ_BODY + "/PostCreateSectionWithoutFieldProjectId.json");
        featureSectionAPI.setPostNewSectionInvalid(json);
    }
}


