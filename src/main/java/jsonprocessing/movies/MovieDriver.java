package jsonprocessing.movies;
import java.util.List;

public class MovieDriver {
    static void main(String[] args) {
        MovieFileParser parser = new MovieFileParser();
        // First, separately test parseMovies
        //List<Movie> movies = parser.parseMovies("src/main/resources/movies/movies1.json");
        //System.out.println(movies);

        // Find and parse json files in the directory, provided by the first program argument (command line argument)
        // In IntelliJ, you can specify program arguments in Run->Edit Configurations
        // For this exercise, you need to specify src/main/resources/movies as a program argument
        List<Movie> allMovies = parser.findAndParseJsonFiles(args[0]);
        System.out.println(allMovies);
    }
}
