package starter.feature.task;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class postReopenStepTask {
    @Steps
    FeatureTaskAPI featureTaskAPI;

    @Given("Reopen a task with {long}")
    public void givenReopenATaskWithId(long id) {
        featureTaskAPI.setReopenATask(id);
    }

    @When("Send Reopen A Task")
    public void sendReopenATask() {
        SerenityRest.when().post(FeatureTaskAPI.POST_REOPEN_TASK);
    }
}
