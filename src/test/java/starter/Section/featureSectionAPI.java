package starter.Section;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Helper;

import java.io.File;

public class featureSectionAPI {

    // Get All Section valid
    @Step("Get all sections")
    public void  setGetAllSections(long id){
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .pathParam("id",id);
    }
    // Get All Section invalid
    @Step("Get all sections invalid id")
    public void  setGetAllSectionsInvalidId(String id){
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .pathParam("id",id);
    }

    // Get Single Section valid
    @Step("Get single section")
    public void setGetSingleSections(int id){
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .pathParam("id",id);
    }
    // Get Single Section invalid
    @Step("Get single section invalid id")
    public void setGetSingleSectionsInvalidId(String id){
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .pathParam("id",id);
    }

    // Post Create new Section valid
    @Step("Post create new section")
    public void setPostNewSection( File json){
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);

    }
    // Post Create new Section invalid
    @Step("Post create new section Invalid")
    public void setPostNewSectionInvalid( File json){
         SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);

    }


    // Post Update Section valid
    @Step("Post update section")
    public void setPostUpdateSection(int id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }
    // Post Update Section valid
    @Step("Post update section invalid")
    public void setPostUpdateSectionInvalidId(String id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }

    // Delete Section valid
    @Step("Delete section")
    public void setDeleteSection(int id){
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .pathParam("id",id);
    }

    // Delete Section Invalid
    @Step("Delete section invalid")
    public void setDeleteSectionInvalid(String id){
        SerenityRest.given().headers("Authorization","Bearer "+ Helper.BEARER_TOKEN)
                .pathParam("id",id);
    }

}
