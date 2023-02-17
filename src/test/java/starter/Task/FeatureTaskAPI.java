package starter.Task;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Helper;

import java.io.File;

public class FeatureTaskAPI {

    @Step("Get active task")
    public void  setGetActiveTask() {
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN);
    }

    @Step("Get an active task")
    public void  setGetAnActiveTask(long id) {
        SerenityRest.given().headers("Authorization", "Bearer " + Helper.BEARER_TOKEN)
                .pathParam(Helper.ID, id);
    }

    @Step("Update a task")
    public void  setPostUpdateATask(long id, File json) {
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .pathParam(Helper.ID,id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post close a task")
    public void  setPostCloseATask(long id) {
        SerenityRest.given().headers("Authorization", "Bearer " + Helper.BEARER_TOKEN)
        .pathParam(Helper.ID, id);
    }

    @Step("Create a new task")
    public void setCreateANewTask(File json){
        SerenityRest.given().headers("Authorization", "Bearer " + Helper.BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Reopen a task")
    public void setReopenATask(long id) {
        SerenityRest.given().headers("Authorization", "Bearer " + Helper.BEARER_TOKEN)
                .pathParam(Helper.ID, id);
    }

    @Step("Delete a task")
    public void  setPostDeleteATask(long id) {
        SerenityRest.given().headers("Authorization", "Bearer " + Helper.BEARER_TOKEN)
                .pathParam(Helper.ID, id);
    }
}
