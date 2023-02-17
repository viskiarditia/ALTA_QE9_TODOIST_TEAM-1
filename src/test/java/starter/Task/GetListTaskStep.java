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

public class GetListTaskStep {
    @Steps
    FeatureTaskAPI featureTaskAPI;

    @Given("Set get active task")
    public void setGetActiveTask() {
        featureTaskAPI.setGetActiveTask();
    }

    @When("Send request get active task")
    public void sendRequestGetActiveTask() {
        SerenityRest.when().get(TodoistURL.GET_LIST_TASK);
    }

    @And("Validate get active task json schema")
    public void validateGetActiveTaskJsonSchema() {
        File json = new File(Helper.JSON_SCHEMA +"/GetListTaskJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
