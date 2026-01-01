package movierecsys;

public class MovieNode {
    Movie movie;
    MovieNode left;
    MovieNode right;

    public MovieNode(Movie movie) {
        this.movie = movie;
        this.left = null;
        this.right = null;
    }
}
