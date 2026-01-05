package movierecsys;

import java.util.*;

public class MovieRecommendationSystem {
    private MovieNode root;

    public MovieRecommendationSystem() {
        root = null;
    }

    private void insert(Movie movie) {
        root = insertRec(root, movie);
    }

    private MovieNode insertRec(MovieNode root, Movie movie) {
        if (root == null) return new MovieNode(movie);
        if (movie.getRating() < root.movie.getRating()) {
            root.left = insertRec(root.left, movie);
        } else {
            root.right = insertRec(root.right, movie);
        }
        return root;
    }
}
