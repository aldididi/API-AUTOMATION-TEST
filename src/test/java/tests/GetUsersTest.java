package tests;

import apiengine.CollectionAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUsersTest {
    CollectionAPI userApi = new CollectionAPI();

    @Test
    public void getUsersWithVariousLimit() {
        Object[] limits = {5, 6, 7,"abc"};
        System.out.println("get all users");
        for (Object limit : limits) {
            System.out.println("testing limits"+limit);
            Response response = userApi.getAllUsers(limit);
            int statusCode = response.getStatusCode();
            Object responseLimit = response.jsonPath().get("limit");
            Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 for limit " + limit);

            if(limit instanceof Integer){
                Assert.assertEquals(responseLimit, limit);
                System.out.println(limit);
            } else {
                Assert.assertNull(responseLimit, "limit invalid/null" + limit);
                System.out.println(limit + "' handled — API returned 200 with limit=null");
            }

            response.prettyPrint();

        }

    }
}
