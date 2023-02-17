package starter.feature.task;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class FeatureTaskAPI {
    public static final String URL = "https://api.todoist.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/feature/JSON/RequestBody";
    public static final String BEARER_TOKEN = "926819adf25c7ad819a21a0c84ea0f1221e57c88";
    public static final String DATE = "due.string";
    public static final String CONTENT = "content";
    public static final String PRIORITY = "priority";
    public static final String ERROR = "error";
    public static String JSON_SCHEMA = DIR + "/src/test/resources/feature/JSON/JSONSchema";
    public static String GET_LIST_TASK = URL + "/rest/v2/tasks";
    public static String GET_SINGLE_TASK = URL + "/rest/v2/tasks/{id}";
    public static String POST_CLOSE_TASK = URL + "/rest/v2/tasks/{id}/close";
    public static String POST_CREATE_TASK = URL + "/rest/v2/tasks";
    public static String POST_REOPEN_TASK = URL + "/rest/v2/tasks/{id}/reopen";
    public static String POST_UPDATE_TASK = URL + "/rest/v2/tasks/{id}";
    public static String DELETE_TASK = URL + "/rest/v2/tasks/{id}";
    public static String ID = "id";


    @Step("Get active task")
    public void  setGetActiveTask() {
        SerenityRest.given().headers("Authorization","Bearer "+ BEARER_TOKEN);
    }
    @Step("Get an active task")
    public void  setGetAnActiveTask(long id) {
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
                .pathParam(ID, id);
    }
    @Step("Update a task")
    public void  setPostUpdateATask(long id, File json) {
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam(ID,id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post close a task")
    public void  setPostCloseATask(long id) {
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
        .pathParam(ID, id);
    }

    @Step("Create a new task")
    public void setCreateANewTask(File json){
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Reopen a task")
    public void setReopenATask(long id) {
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
                .pathParam(ID, id);
    }

    @Step("Delete a task")
    public void  setPostDeleteATask(long id) {
        SerenityRest.given().headers("Authorization", "Bearer " + BEARER_TOKEN)
                .pathParam(ID, id);
    }
}
