package chris.lim.helpers;

import io.restassured.response.Response;

/**
 * Utility class for handling JWT tokens.
 */
public class JwtTokenHelper {

    /**
     * Extracts the JWT token from the response body.
     *
     * @param response the API response
     * @return the JWT token as a String
     */
    public static String extractToken(Response response) {
        return response.jsonPath().getString("token");
    }
}
