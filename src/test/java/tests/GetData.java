package tests;

import apiengine.CollectionAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.Payload;

public class GetData {
    CollectionAPI userApi = new CollectionAPI();

    @Test
    public void getUsers() {
        System.out.println("get all users");
        Response response = userApi.getAllUsers(5);
        Assert.assertEquals(response.getStatusCode(), 200, "Page request should return 200 OK");
        response.prettyPrint();
    }
}
