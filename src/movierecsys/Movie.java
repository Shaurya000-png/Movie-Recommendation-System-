package movierecsys;

/**
 * Represents a movie with its metadata.
 */
public class Movie {
    private String title;
    private String genre;
    private double rating;
    private int year;
    private String description;

    public Movie(String title, String genre, double rating, int year, String description) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
        this.description = description;
    }

    public String getTitle()       { return title; }
    public String getGenre()       { return genre; }
    public double getRating()      { return rating; }
    public int    getYear()        { return year; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s [%.1f]", title, year, genre, rating);
    }
}
