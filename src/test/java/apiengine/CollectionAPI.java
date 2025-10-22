package apiengine;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CollectionAPI {
    public Response userLogin(String requestBody){
        return RestAssured.given()
                .baseUri(Endpoints.BASEURL)
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("x-api-key","reqres-free-v1")
                .body(requestBody).log().all()
                .when().post(Endpoints.LOGIN);

    }
}
