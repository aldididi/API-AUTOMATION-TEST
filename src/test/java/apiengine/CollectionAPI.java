package apiengine;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CollectionAPI {

    public Response getAllUsers(int limit){
        return RestAssured.given()
                .baseUri(Endpoints.BASEURL)
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("app-id","6112dc7c3f812e0d9b6679dd")
                .log().all()
                .when().get(Endpoints.GETUSER + limit);

    }
}
