package starter.feature.task;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class getSingleStepTask {
    @Steps
    FeatureTaskAPI featureTaskAPI;

    //Get Single
    @Given("Get an active task with valid {long}")
    public void getAnActiveTaskWithValidID(long id) {
        featureTaskAPI.setGetAnActiveTask(id);
    }

    @When("Send Get an active task request")
    public void sendGetAnActiveTask() {
        SerenityRest.when().get(FeatureTaskAPI.GET_SINGLE_TASK);
    }

    @And("Validate Get an active task json schema")
    public void validateGenAnActiveTaskJsonSchema() {
        File json = new File(FeatureTaskAPI.JSON_SCHEMA +"/GetSingleTaskJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body should be {long}")
    public void responseBodyShouldBeId(long id) {
        SerenityRest.then().body(FeatureTaskAPI.ID, equalTo(id));
    }

    //Get Single Invalid id
    @Given("Get an active task with invalid {long}")
    public void getAnActiveTaskWithInvalidId(long id) {
        featureTaskAPI.setGetAnActiveTask(id);
    }
}
