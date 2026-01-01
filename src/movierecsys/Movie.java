package movierecsys;

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
}
