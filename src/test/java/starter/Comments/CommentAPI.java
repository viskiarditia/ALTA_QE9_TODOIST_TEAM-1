package starter.Comments;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class CommentAPI {

    public static final String URL = "https://api.todoist.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/features/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/features/JSON/JSONSchema";
    public static final String BEARER_TOKEN = "926819adf25c7ad819a21a0c84ea0f1221e57c88";
    public static final String GET_ALL_COMMENT = URL+"/rest/v2/comments/3224747581";
    public static final String CREATE_NEW_COMMENT = URL+"/rest/v2/comments";
    public static final String GET_COMMENT = URL+"/rest/v2/comments/{id}";
    public static final String UPDATE_COMMENT = URL+"/rest/v2/comments/{id}";
    public static final String DELETE_COMMENT = URL+"/rest/v2/comments/{id}";

    //Get all Comments
    @Step("Get all comment")
    public void getAllComment(){
        SerenityRest.given()
                .headers("Authorization", "Bearer 926819adf25c7ad819a21a0c84ea0f1221e57c88");
    }

    //Create New Comment
    @Step("Post create new Comment")
    public void postCreateNewComment(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Get Comment
    @Step("Get Comment")
    public void getComment(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

    //Get Comment with invalid id
//    @Step("Get invalid Comment")
//    public void getCommentInvalidId(long id) {
//        SerenityRest.given()
//                .headers("Authorization", "Bearer "+BEARER_TOKEN)
//                .pathParam("id",id);
//    }

    //Update Comment
    @Step("Update Comment")
    public void updateComment(long id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete Comment
    @Step("Delete Comment")
    public void deleteComment(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

}