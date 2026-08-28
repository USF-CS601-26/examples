package fileio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// An example showing how to write to a file. Creates the file output.txt in the project directory.
public class WriteToFileExample {
        static void main(String[] args) {
            Path path = Path.of("output.txt");
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write("This is the first line. ");
                writer.newLine();
                writer.write("This is the second line.");
            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        }
}
