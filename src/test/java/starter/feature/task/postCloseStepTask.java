package starter.feature.task;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class postCloseStepTask {
    @Steps
    FeatureTaskAPI featureTaskAPI;

    //Scenarioa Close a task with valid id
    @Given("Close a task with valid {long}")
    public void closeATaskWithValidId(long id) {
        featureTaskAPI.setPostCloseATask(id);
    }

    @Then("Status code should be {int} NoContent")
    public void statusCodeShouldBeNoContent(int noContent) {SerenityRest.then().statusCode(noContent);
    }

    @When("Send close a task request")
    public void sendCloseATaskRequest() {SerenityRest.when().post(FeatureTaskAPI.POST_CLOSE_TASK);
        }


}

