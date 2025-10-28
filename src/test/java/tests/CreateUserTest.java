package tests;

import apiengine.CollectionAPI;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.example.utils.TestData;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import payloads.Payload;

import java.io.File;
import java.util.UUID;

public class CreateUserTest {

    private  CollectionAPI collectionAPI;
    private static final int STATUS_OK = 200;
    private static final int STATUS_BAD_REQUEST = 400;

    @BeforeClass
    public void setup(){
        collectionAPI = new CollectionAPI();
    }

    private String buildUserPayload(String email) {
        return Payload.createUser(
                "mr", "adudu", "dudududu",
                "https://randomuser.me/api/portraits/med/men/74.jpg",
                "male", email,
                "1963-04-12T15:41:39.051Z",
                "76120280",
                "6839, Lavendelvej",
                "Agerbæk",
                "Sjælland",
                "Denmark",
                "0:00"
        );
    }
    private String buildUserPayload2(String email, String gender) {
        return Payload.createUser(
                "mr", "adudu", "dudududu",
                "https://randomuser.me/api/portraits/med/men/74.jpg",
                gender, email,
                "1963-04-12T15:41:39.051Z",
                "76120280",
                "6839, Lavendelvej",
                "Agerbæk",
                "Sjælland",
                "Denmark",
                "0:00"
        );
    }

    @DataProvider(name="genderProvider")
    public Object[][] getGender() {
        return new Object[][] {
                {"male", false},
                {"female", false},
                {null, true},
                {"unknown", true}
        };
    }

    @Test
    public void createUser() {
        String randomizeEmail = "user_"+ UUID.randomUUID().toString().substring(0,8)+"@mail.com";
        String reqBody = buildUserPayload(randomizeEmail);
        Response response = collectionAPI.createUser(reqBody);
        Assert.assertEquals(response.getStatusCode(), STATUS_OK);
        response.prettyPrint();
        TestData.createdEmail = response.jsonPath().getString("email");
        TestData.createdId = response.jsonPath().getString("id");
        System.out.println("stored email:"+TestData.createdEmail);
        System.out.println("stored id"+TestData.createdId);
    }

    @Test
    public void validateSchemaCreateUser() {
        Response response = collectionAPI.getAllUsers(1);
        response.then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/test/resources/schemas/createUser.json")));

        System.out.println("Schema validation passed for /user?limit=1");
    }

    @Test(dependsOnMethods = {"createUser"})
    public void createUserDuplicatedEmail() {
        String reqBody = buildUserPayload(TestData.createdEmail);
        Response response = collectionAPI.createUser(reqBody);
        Assert.assertEquals(response.getStatusCode(), STATUS_BAD_REQUEST,"400 expected, email already user");
        response.prettyPrint();
    }

    @Test(dependsOnMethods = {"createUser"}, dataProvider = "genderProvider")
    public void createUserWithGender(String gender, boolean expectBadRequest) {

        String randomEmail = "user_" + UUID.randomUUID().toString().substring(0,8) + "@mail.com";
        String reqBody = buildUserPayload2(randomEmail, gender);

        System.out.println("gender: " + gender);
        Response response = collectionAPI.createUser(reqBody);

        int expectedStatus = expectBadRequest ? STATUS_BAD_REQUEST : STATUS_OK;
        Assert.assertEquals(response.getStatusCode(), expectedStatus,"gender is mismatch: "+gender);
        response.prettyPrint();
    }

    @Test(dependsOnMethods = {"createUser"})
    public void createUserMissingEmail() {
        String reqBody = buildUserPayload(null);
        Response response = collectionAPI.createUser(reqBody);
        Assert.assertEquals(response.getStatusCode(), STATUS_BAD_REQUEST,"400 expected, email is missing");
        response.prettyPrint();
    }
    @Test(dependsOnMethods = {"createUser"})
    public void createUserWrongEmailFormat() {
        String reqBody = buildUserPayload("email.com");
        Response response = collectionAPI.createUser(reqBody);
        Assert.assertEquals(response.getStatusCode(), STATUS_BAD_REQUEST,"400 expected, email is missing");
        response.prettyPrint();
    }
}
