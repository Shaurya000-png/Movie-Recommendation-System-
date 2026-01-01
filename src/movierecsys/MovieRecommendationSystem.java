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
        if (root == null) {
            return new MovieNode(movie);
        }
        // ordering logic placeholder
        return root;
    }
}
