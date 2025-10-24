package apiengine;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CollectionAPI {

    public Response getAllUsers(Object limit){
        return RestAssured.given()
                .baseUri(Endpoints.BASEURL)
                .basePath(Endpoints.GETUSER)
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("app-id", Endpoints.APPID)
                .queryParam("limit", limit)
                .log().all()
                .when()
                .get();

    }
    public Response createUser(String requestBody){
        return RestAssured.given()
                .baseUri(Endpoints.BASEURL)
                .basePath(Endpoints.CREATEUSER)
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("app-id", Endpoints.APPID)
                .body(requestBody).log().all()
                .when().post();
    }

}
