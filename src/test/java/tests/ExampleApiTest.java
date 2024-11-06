package tests;

import chris.lim.helpers.ResponseHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Example API tests using Rest Assured and Hamcrest.
 */
public class ExampleApiTest extends ApiTestBase {

    @Test
    public void testGetUsers() {
        Response response = RestAssured.given()
                .when()
                .get("/users?page=2");

        assertThat(ResponseHelper.getStatusCode(response), is(200));
        assertThat(response.jsonPath().getList("data"), hasSize(greaterThan(0)));
        assertThat(response.jsonPath().getString("data[0].first_name"), equalTo("Michael"));
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John\", \"job\": \"leader\" }";
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/users");

        assertThat(ResponseHelper.getStatusCode(response), is(201));
        assertThat(response.jsonPath().getString("name"), equalTo("John"));
        assertThat(response.jsonPath().getString("job"), equalTo("leader"));
    }
}
