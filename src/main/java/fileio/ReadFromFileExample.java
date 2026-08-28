package fileio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// An example demonstrating how to read lines from the file
public class ReadFromFileExample {
    static void main() {
        Path path = Path.of("src/main/resources/input.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("Could not read from the file " + e.getMessage());
        }
    }
}
