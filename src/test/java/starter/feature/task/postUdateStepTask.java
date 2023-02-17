package starter.feature.task;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class postUdateStepTask {
    @Steps
    FeatureTaskAPI featureTaskAPI;
//    @Given("Update task id {long} with special character")
//    public void updateTaskWithSpecialCharacter(long id) {
//        File json = new File(FeatureTaskAPI.JSON_REQ_BODY+"/PostUpdateTaskSpecialCharacterBody.json");
//        featureTaskAPI.setUpdateTaskWithSpecialCharacter(id,json);
//    }


    @Given("Update task with valid json and {long}")
    public void updateTaskWithValidJsonAndId(long id) {
        File json = new File(FeatureTaskAPI.JSON_REQ_BODY + "/PostUpdateTaskBody.json");
        featureTaskAPI.setPostUpdateATask(id, json);
    }

    @When("Send update task request")
    public void sendUpdateTaskRequest() {
        SerenityRest.when().post(FeatureTaskAPI.POST_UPDATE_TASK);
    }

    @And("Response body should be {string}")
    public void responseBodyShouldBe(String content) {
        SerenityRest.then().body(FeatureTaskAPI.CONTENT, equalTo(content));

    }

}
