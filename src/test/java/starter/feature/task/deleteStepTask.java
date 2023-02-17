package starter.feature.task;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class deleteStepTask {
    @Steps
    FeatureTaskAPI featureTaskAPI;

    @Given("Delete a task with {long}")
    public void deleteATaskWithId(long id) {
        featureTaskAPI.setPostDeleteATask(id);
    }

    @When("Send Delete A task")
    public void sendDeleteATask() {
        SerenityRest.when().post(FeatureTaskAPI.DELETE_TASK);
    }
}
