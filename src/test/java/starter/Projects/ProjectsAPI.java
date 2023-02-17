package starter.Projects;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ProjectsAPI {

    public static final String BASE_URL = "https://api.todoist.com/rest/v2";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JSONSchema";
    public static final String BEARER_TOKEN = "926819adf25c7ad819a21a0c84ea0f1221e57c88";
    public static final String BEARER_INVALID_TOKEN = "926819adf25c7ad819a21a0c84ea0f1221e57@3$D%";
    public static final String GET_ALL_PROJECTS = BASE_URL+"/projects";
    public static final String INVALID_GET_ALL_PROJECTS = BASE_URL+"/project";
    public static final String CREATE_NEW_PROJECT = BASE_URL+"/projects";
    public static final String GET_PROJECT = BASE_URL+"/projects/{id}";
    public static final String UPDATE_PROJECT = BASE_URL+"/projects/{id}";
    public static final String DELETE_PROJECT = BASE_URL+"/projects/{id}";
    public static final String GET_ALL_COLLABORATOR = BASE_URL+"/projects/{id}/collaborators";

    //Get All Project Positive Case
    @Step("Get all projects")
    public void getAllProjects() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN);
    }
    //Get all project invalid token
    @Step("Get all projects with invalid token")
    public void getAllProjectsInvalidToken() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_INVALID_TOKEN);
    }
    //Get All Project invalid url Negative Case
    @Step("Get all projects with invalid url")
    public void invalidGetAllProjects() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN);
    }

    //Create New Project 2 Positive Case and 1 negative
    @Step("Post create a new project")
    public void postCreateNewProject(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Get Project valid id Positive Case
    @Step("Get a project with valid id")
    public void getValidProject(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
    //Get Project invalid id Positive Case
    @Step("Get a project with invalid id")
    public void getInvalidProject(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
    //Post Update a Project valid id Positive case
    @Step("Update project")
    public void updateProject(long id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    //Post Update a Project invalid id Negative case
    @Step("Update invalid project")
    public void updateInvalidProject(String id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete valid id Project
    @Step("Delete project")
    public void deleteProject(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
    //Delete invalid id project
    @Step("Delete invalid id project")
    public void deleteInvalidProject(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

    //Collaborator Project
    @Step("Get all collaborator")
    public void getAllCollaborator(long id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
}