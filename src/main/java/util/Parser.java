package util;

import java.util.Map;

/**
 * Utility class for parsing inputs and converting boolean values to Python equivalent strings.
 */
public class Parser {

    /**
     * Converts a Map of inputs into a formatted String.
     *
     * @param input The Map of inputs to be parsed.
     * @return A formatted String representing the input Map.
     */
    public static String inputParser(Map<String, String> input) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            sb.append("'").append(entry.getKey()).append("':'").append(entry.getValue()).append("', ");
        }
        return sb.substring(0, sb.length() - 2); // remove trailing comma and space
    }

    /**
     * Converts a boolean value to its Python equivalent string.
     *
     * @param value The boolean value to be converted.
     * @return A String representing the Python equivalent of the boolean value.
     */
    public static String getPythonBooleanString(boolean value) {
        return value ? "True" : "False";
    }
}