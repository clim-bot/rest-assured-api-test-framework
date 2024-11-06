package chris.lim.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

/**
 * Utility class for JSON manipulation.
 */
public class JsonHelper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts an object to its JSON representation.
     *
     * @param obj the object to convert
     * @return the JSON string
     */
    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }

    /**
     * Converts a JSON string to an object of the specified class.
     *
     * @param json  the JSON string
     * @param clazz the target class
     * @param <T>   the type of the target class
     * @return the converted object
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to object", e);
        }
    }
}
