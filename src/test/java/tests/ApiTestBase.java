package tests;

import io.restassured.RestAssured;
import chris.lim.helpers.Config;
import org.testng.annotations.BeforeClass;

/**
 * Base test class for API tests, setting up the base URI.
 */
public class ApiTestBase {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = Config.BASE_URL;
    }
}
