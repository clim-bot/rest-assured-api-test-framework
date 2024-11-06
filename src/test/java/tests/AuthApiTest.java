package tests;

import chris.lim.helpers.JwtTokenHelper;
import chris.lim.helpers.JsonHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * API tests for authentication-related operations.
 */
public class AuthApiTest extends ApiTestBase {

    @Test
    public void testAuthWithCredentialsAndExtractToken() {
        Map<String, String> payload = new HashMap<>();
        payload.put("email", "eve.holt@reqres.in");
        payload.put("password", "cityslicka");

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(JsonHelper.toJson(payload))
                .when()
                .post("/login");

        assertThat(response.getStatusCode(), is(200));
        String token = JwtTokenHelper.extractToken(response);
        assertThat(token, notNullValue());
    }
}
