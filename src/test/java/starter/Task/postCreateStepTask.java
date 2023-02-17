package starter.Task;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Helper;
import starter.Utils.TodoistURL;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class postCreateStepTask {

    @Steps
    FeatureTaskAPI featureTaskAPI;

    @Given("Post create user with file json")
    public void postCreateUserWithFileJson() {
        File json = new File(Helper.JSON_REQ_BODY + "/PostCreateTaskBody.json");
        featureTaskAPI.setCreateANewTask(json);
    }
    @When("Send Create Active Task")
    public void sendCreateActiveTask() {
        SerenityRest.when().post(TodoistURL.POST_CREATE_TASK);
    }

    @And("Validate Create a new task json schema")
    public void validateCreateANewTaskJsonSchema() {
        File json = new File(Helper.JSON_SCHEMA+"/PostCreateNewUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body Should contain name {string} and date {string} and priority {int}")
    public void responseBodyShouldContainNameAndDateAndPriority(String content, String date, int proprity) {
        SerenityRest.then().body(Helper.CONTENT, equalTo(content))
                .body(Helper.DATE, equalTo(date))
                .body(Helper.PRIORITY, equalTo(proprity));
    }

    @Given("Post create user with blank file json")
    public void postCreateUserWithBlankFileJson() {
        File json = new File(Helper.JSON_REQ_BODY + "/PostCreateTaskBlankBody.json");
        featureTaskAPI.setCreateANewTask(json);
    }

    @And("Response body Should be error {string}")
    public void responseBodyShouldBeError(String error) {
        SerenityRest.then().body(equalTo(error));
    }
}


