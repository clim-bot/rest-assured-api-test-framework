package chris.lim.helpers;

import io.restassured.response.Response;

/**
 * Helper class for handling HTTP responses.
 */
public class ResponseHelper {

    /**
     * Returns the status code from the response.
     *
     * @param response the API response
     * @return the status code
     */
    public static int getStatusCode(Response response) {
        return response.getStatusCode();
    }
}
