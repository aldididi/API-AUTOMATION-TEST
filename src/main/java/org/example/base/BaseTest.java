package org.example.base;

import io.restassured.RestAssured;
import org.example.utils.ConfigReader;
import org.junit.BeforeClass;

public class BaseTest  {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = ConfigReader.getProperty("base.url");
        System.out.println("Base URI set to: " + RestAssured.baseURI);
    }
}
