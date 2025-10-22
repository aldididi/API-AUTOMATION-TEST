package tests;

import apiengine.CollectionAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.Payload;

public class GetData {
    CollectionAPI userApi = new CollectionAPI();
    @Test
    public void userLogin(){
        System.out.println("login user");
        String reqBody = Payload.userValidLogin("eve.holt@reqres.in", "pistol");
        Response response = userApi.userLogin(reqBody);
        Assert.assertEquals(response.getStatusCode(), 200, "Success Login");
        System.out.println(response.asPrettyString());
    }
}
