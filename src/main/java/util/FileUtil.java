package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * This class provides a utility method for reading files.
 */
public class FileUtil {

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

    /**
     * Creates a new file at the specified filePath and writes the given content into it.
     * If the file already exists, it updates the file with the new content.
     *
     * @param filePath The path where the file should be created or updated.
     * @param content  The content to write into the file.
     */
    public static void createFile(String filePath, String content) {
        File file = new File(filePath);

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
            System.out.println("Successfully wrote to the file: " + file.getName());
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    /**
     * Compresses multiple files into a single zip file.
     *
     * @param files   Array of file paths to be included in the zip.
     * @param zipPath The path where the zip file should be created.
     */
    public static void createZip(String[] files, String zipPath) {
        try {
            FileOutputStream fos = new FileOutputStream(zipPath);
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            for (String filePath : files) {
                File file = new File(filePath);
                FileInputStream fis = new FileInputStream(file);

                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }

                fis.close();
            }
            zipOut.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

}