package starter.Section;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.TodoistURL;

public class DeleteSectionDef {

    @Steps
    starter.Section.featureSectionAPI featureSectionAPI;

    //valid id
    @Given("Delete section with valid id {int}")
    public void deleteSectionWithValidIdId(int id) {
        featureSectionAPI.setDeleteSection(id);
    }

    @When("Send delete section with valid request")
    public void sendDeleteSectionWithValidRequest() {
        SerenityRest.when().delete(TodoistURL.DELETE_SECTION);
    }

    // invalid id
    @Given("Delete section with invalid id {string}")
    public void deleteSectionWithInvalidId(String id) {
        featureSectionAPI.setDeleteSectionInvalid(id);
    }

    @When("Send delete section with invalid request")
    public void sendDeleteSectionWithInvalidRequest() {
        SerenityRest.when().delete(TodoistURL.DELETE_SECTION);
    }
}
