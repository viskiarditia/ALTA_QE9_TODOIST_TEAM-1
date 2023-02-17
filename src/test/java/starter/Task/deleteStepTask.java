package starter.Task;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.TodoistURL;

public class deleteStepTask {
    @Steps
    FeatureTaskAPI featureTaskAPI;

    @Given("Delete a task with {long}")
    public void deleteATaskWithId(long id) {
        featureTaskAPI.setPostDeleteATask(id);
    }

    @When("Send Delete A task")
    public void sendDeleteATask() {
        SerenityRest.when().post(TodoistURL.DELETE_TASK);
    }
}
