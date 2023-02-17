package starter.Utils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class errorCode {

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {SerenityRest.then().statusCode(OK);}

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFount) {
        SerenityRest.then().statusCode(notFount);
    }

    @And("Respone status code {int} Forbidden")
    public void responeStatusCodeForbidden(int Forbidden) {
        SerenityRest.then().statusCode(Forbidden);
    }

    @Then("Status code is {int} No Content")
    public void statusCodeIsNoContent(int NoContent) {
        SerenityRest.then().statusCode(NoContent);
    }

    @Then("Status code should be {int} Unauthorize")
    public void statusCodeShouldBeUnauthorize(int Unauthorize) {
        SerenityRest.then().statusCode(Unauthorize);
    }
}
