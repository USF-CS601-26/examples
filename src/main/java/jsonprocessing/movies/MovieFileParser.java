package jsonprocessing.movies;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Before you work on this class, look at jsonprocesing examples:
// https://github.com/USF-CS601-26/examples/tree/main/src/main/java/jsonprocessing
public class MovieFileParser {

    /** Parse a given json file with movies - see the structure of the file movies1.json
     * in the src/main/resources/movies folder of the project
     * @param jsonFilepath A path to the json file, given as a string
     * @return an ArrayList of Movie-s
    */
    public List<Movie> parseMovies(String jsonFilepath) {
        List<Movie> movies = new ArrayList<>();
        try (FileReader fr = new FileReader(jsonFilepath)) {
            JsonObject jo = (JsonObject) JsonParser.parseReader(fr);
            JsonArray jsonArr = jo.getAsJsonArray("movies");
            for (JsonElement movieObj: jsonArr) {
                String title = ((JsonObject)movieObj).get("title").getAsString();
                int year = Integer.parseInt(((JsonObject)movieObj).get("year").getAsString());
                String director = ((JsonObject)movieObj).get("director").getAsString();
                String allCast = ((JsonObject)movieObj).get("cast").getAsString();
                String[] cast = allCast.split(", ");
                Movie movie = new Movie(title, year, director, cast);
                movies.add(movie);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

        return movies;
    }

    /** Traverse a given directory to find all .json files with movies,
     * parse them and return a list of Movies.
     * @param directory input directory
     * @return a list of movies extracted from all the json files in this directory
     */
    public List<Movie> findAndParseJsonFiles(String directory) {
        List<Movie> movies = new ArrayList<>();
        Path p = Paths.get(directory);
        try (DirectoryStream<Path> pathsInDir = Files.newDirectoryStream(p)) {
            for (Path path : pathsInDir) {
                if (!Files.isDirectory(path) && (path.toString().endsWith(".json"))) {
                    List<Movie> moviesInOneJson = parseMovies(path.toString());
                    movies.addAll(moviesInOneJson);
                }
            }
        } catch (IOException e) {
            System.out.println("Can not open directory: " + directory);
        }
        System.out.println("Total number of movies parsed: " + movies.size());
        return movies;
    }
}
