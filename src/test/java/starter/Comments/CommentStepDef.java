package starter.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Helper;
import starter.Utils.TodoistRespone;
import starter.Utils.TodoistURL;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class
CommentStepDef {
    @Steps
    CommentAPI commentAPI;

    //Create New Comment
    @Given("Create new comment with valid task_id")
    public void createNewCommentWithValidTask_id() {
        File json = new File(Helper.JSON_REQ_BODY+"/CreateNewComment.json");
        commentAPI.postCreateNewComment(json);
    }

    @When("create comment request with valid task ID")
    public void createCommentRequestWithValidTaskID() {
        SerenityRest.when().post(TodoistURL.CREATE_NEW_COMMENT);
    }

    @And("Response body should contain name Comment {string}")
    public void responseBodyShouldContainNameComment(String name) {
        SerenityRest.then()
                .body(TodoistRespone.CONTENT, equalTo(name));
    }


    @And("Validate create comment json schema validator")
    public void validateCreateCommentJsonSchemaValidator() {
        File json = new File(Helper.JSON_SCHEMA+"/CreateNewCommentSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchema(json));
    }

    //NegativeCase Create new comment with invalid task_id
    @Given("Create new comment with invalid task_id")
    public void createNewCommentWithInvalidTask_id() {
        File json = new File(Helper.JSON_REQ_BODY+"/CreateInvalidComment.json");
        commentAPI.postCreateNewComment(json);
    }

    @When("Create comment request with invalid task id")
    public void createCommentRequestWithInvalidTaskId() {
        SerenityRest.when().post(TodoistURL.CREATE_NEW_COMMENT);

    }

    //Get All Comment
    @Given("Get all comment with valid ID")
    public void getAllCommentWithValidID() {
        commentAPI.getAllComment();
    }

    @When("Send all comments request")
    public void sendAllComments() {
        SerenityRest.when().get(TodoistURL.GET_ALL_COMMENT);
    }


    @And("Validate get all comments json schema validator")
    public void validateGetAllCommentsJsonSchemaValidator() {
        File json = new File(Helper.JSON_SCHEMA+"/GetAllCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get a Comment
    @Given("Get comment with valid id {long}")
    public void getCommentWithValidIdId(long id) {
        commentAPI.getComment(id);
    }


    @When("Send get comment request")
    public void sendGetCommentRequest() {
        SerenityRest.when().get(TodoistURL.GET_COMMENT);
    }

    @And("Validate get comment json schema validator")
    public void validateGetCommentJsonSchemaValidator() {
        File json = new File(Helper.JSON_SCHEMA+"/GetCommentSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //End Get a Comment

    //Update Comment

    @Given("Update comment with valid id {long}")
    public void updateCommentWithValidIdId(long id) {
        File json = new File(Helper.JSON_REQ_BODY+"/UpdateComment.json");
        commentAPI.updateComment(id, json);
    }

    @When("Send post update comment request")
    public void sendPostUpdateCommentRequest() {
        SerenityRest.when().post(TodoistURL.UPDATE_COMMENT);
    }

    @And("Validate post update project json schema validator")
    public void validatePostUpdateProjectJsonSchemaValidator() {
        File json = new File(Helper.JSON_SCHEMA+"/UpdateCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Delete Comments
    @Given("Task delete comments with id {long}")
    public void taskDeleteCommentsWithIdId(long id) {
        commentAPI.deleteComment(id);
    }

    @When("Send task delete comments request")
    public void sendTaskDeleteCommentsRequest() {
        SerenityRest.when().delete(TodoistURL.DELETE_COMMENT);
    }

}