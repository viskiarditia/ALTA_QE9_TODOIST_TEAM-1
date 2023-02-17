package starter.Task;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.TodoistURL;

public class postCloseStepTask {
    @Steps
    FeatureTaskAPI featureTaskAPI;

    @Given("Close a task with valid {long}")
    public void closeATaskWithValidId(long id) {
        featureTaskAPI.setPostCloseATask(id);
    }

    @When("Send close a task request")
    public void sendCloseATaskRequest() {SerenityRest.when().post(TodoistURL.POST_CLOSE_TASK);
        }


}

