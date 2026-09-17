package jsonprocessing.movies;

/**
 * A class that represents a movie.
 */
public class Movie {
    // FILL IN CODE:
    // add variables: title, year, director, cast
    private String title;
    private int year;
    private String director;
    private String[] cast;

    public Movie(String title, int year, String director, String[] cast) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.cast = new String[cast.length];
        for (int i = 0; i < cast.length; i++) {
            this.cast[i] = cast[i];
        }
    }

    public String toString() {
        return "(" + title + ", " + director + ")";
    }
    // This class will be used while parsing .json movie files located in the resources/movies folder
    // Before you start working on this problem,
    // look at any of the following files to understand the structure:
    // movies1.json, movies2.json, movies3.json
}
