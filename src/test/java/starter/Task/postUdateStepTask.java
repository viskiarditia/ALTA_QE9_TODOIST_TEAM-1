package starter.Task;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Helper;
import starter.Utils.TodoistURL;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class postUdateStepTask {
    @Steps
    FeatureTaskAPI featureTaskAPI;

    @Given("Update task with valid json and {long}")
    public void updateTaskWithValidJsonAndId(long id) {
        File json = new File(Helper.JSON_REQ_BODY + "/PostUpdateTaskBody.json");
        featureTaskAPI.setPostUpdateATask(id, json);
    }

    @When("Send update task request")
    public void sendUpdateTaskRequest() {
        SerenityRest.when().post(TodoistURL.POST_UPDATE_TASK);
    }

    @And("Response body should be {string}")
    public void responseBodyShouldBe(String content) {
        SerenityRest.then().body(Helper.CONTENT, equalTo(content));

    }

}
