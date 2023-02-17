package starter.section;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteSectionDef {

    @Steps
    starter.section.featureSectionAPI featureSectionAPI;

    //valid id
    @Given("Delete section with valid id {int}")
    public void deleteSectionWithValidIdId(int id) {
        featureSectionAPI.setDeleteSection(id);
    }

    @When("Send delete section with valid request")
    public void sendDeleteSectionWithValidRequest() {
        SerenityRest.when().delete(starter.section.featureSectionAPI.DELETE_SECTION);
    }

    @Then("Status code should with valid be {int} No Content")
    public void statusCodeShouldWithValidBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    // invalid id
    @Given("Delete section with invalid id {string}")
    public void deleteSectionWithInvalidId(String id) {
        featureSectionAPI.setDeleteSectionInvalid(id);
    }

    @When("Send delete section with invalid request")
    public void sendDeleteSectionWithInvalidRequest() {
        SerenityRest.when().delete(starter.section.featureSectionAPI.DELETE_SECTION);
    }

    @Then("Status Code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }
}
