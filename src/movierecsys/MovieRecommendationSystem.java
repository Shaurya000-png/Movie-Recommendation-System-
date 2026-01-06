package movierecsys;

import java.io.*;
import java.util.*;

public class MovieRecommendationSystem {
    private MovieNode root;

    public MovieRecommendationSystem() {
        root = null;
    }

    public void loadMoviesFromTextFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] movieData = line.split(",");
                if (movieData.length == 5) {
                    String title       = movieData[0].trim();
                    String genre       = movieData[1].trim();
                    double rating      = Double.parseDouble(movieData[2].trim());
                    int    year        = Integer.parseInt(movieData[3].trim());
                    String description = movieData[4].trim();
                    insert(new Movie(title, genre, rating, year, description));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private void insert(Movie movie) {
        root = insertRec(root, movie);
    }

    private MovieNode insertRec(MovieNode root, Movie movie) {
        if (root == null) return new MovieNode(movie);
        if (movie.getRating() < root.movie.getRating()) {
            root.left = insertRec(root.left, movie);
        } else if (movie.getRating() > root.movie.getRating()) {
            root.right = insertRec(root.right, movie);
        } else {
            if (movie.getYear() < root.movie.getYear()) {
                root.left = insertRec(root.left, movie);
            } else {
                root.right = insertRec(root.right, movie);
            }
        }
        return root;
    }

    public List<Movie> getSortedMovies() {
        List<Movie> sorted = new ArrayList<>();
        inOrderRec(root, sorted);
        return sorted;
    }

    private void inOrderRec(MovieNode root, List<Movie> list) {
        if (root != null) {
            inOrderRec(root.left, list);
            list.add(root.movie);
            inOrderRec(root.right, list);
        }
    }

    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> sorted   = getSortedMovies();
        List<Movie> filtered = new ArrayList<>();
        for (Movie m : sorted) {
            if (m.getGenre().equalsIgnoreCase(genre)) filtered.add(m);
        }
        return filtered.size() > 10 ? filtered.subList(0, 10) : filtered;
    }
}
