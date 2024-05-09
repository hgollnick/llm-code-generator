package util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

/**
 * This class provides a utility method for reading files.
 */
public class FileReader {

    /**
     * This method reads a file from the given file path and returns its content as a string.
     * It uses the java.nio.file.Files class's readAllBytes method to read all bytes from the file into a byte array,
     * and then creates a new String from the byte array.
     * If an IOException occurs during the reading of the file, it is caught and a RuntimeException is thrown instead.
     *
     * @param filePath The path of the file to read.
     * @return The content of the file as a string.
     * @throws RuntimeException if an IOException occurs during the reading of the file.
     */
    public static String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}