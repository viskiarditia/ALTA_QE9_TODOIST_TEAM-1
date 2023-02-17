package starter.section;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class featureSectionAPI {

    public static final String URL ="https://api.todoist.com";
    public static final String DIR =System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String BEARER_TOKEN= "926819adf25c7ad819a21a0c84ea0f1221e57c88";
    public static String JSON_SCHEMA = DIR +"/src/test/resources/JSON/JsonSchema";
    public static String GET_ALL_SECTION = URL+"/rest/v2/sections?project_id={id}";
    public static String GET_SINGLE_SECTIONS =URL+ "/rest/v2/sections/{id}";
    public static String POST_NEW_SECTION = URL +"/rest/v2/sections";
    public static String POST_UPDATE_SECTION = URL+"/rest/v2/sections/{id}";
    public static String DELETE_SECTION =URL+"/rest/v2/sections/{id}";

    // Get All Section valid
    @Step("Get all sections")
    public void  setGetAllSections(long id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
    // Get All Section invalid
    @Step("Get all sections invalid id")
    public void  setGetAllSectionsInvalidId(String id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

    // Get Single Section valid
    @Step("Get single section")
    public void setGetSingleSections(int id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }
    // Get Single Section invalid
    @Step("Get single section invalid id")
    public void setGetSingleSectionsInvalidId(String id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

    // Post Create new Section valid
    @Step("Post create new section")
    public void setPostNewSection( File json){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);

    }
    // Post Create new Section invalid
    @Step("Post create new section Invalid")
    public void setPostNewSectionInvalid( File json){
         SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);

    }


    // Post Update Section valid
    @Step("Post update section")
    public void setPostUpdateSection(int id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }
    // Post Update Section valid
    @Step("Post update section invalid")
    public void setPostUpdateSectionInvalidId(String id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }

    // Delete Section valid
    @Step("Delete section")
    public void setDeleteSection(int id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

    // Delete Section Invalid
    @Step("Delete section invalid")
    public void setDeleteSectionInvalid(String id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKEN)
                .pathParam("id",id);
    }

}
