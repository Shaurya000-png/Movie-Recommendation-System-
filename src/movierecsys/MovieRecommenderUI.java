package movierecsys;

import javax.swing.*;
import java.awt.*;

public class MovieRecommenderUI extends JFrame {
    private MovieRecommendationSystem recommender;

    public MovieRecommenderUI(MovieRecommendationSystem recommender) {
        this.recommender = recommender;
        setTitle("Movie Recommendation System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        MovieRecommendationSystem recommender = new MovieRecommendationSystem();
        recommender.loadMoviesFromTextFile("movies.txt");
        SwingUtilities.invokeLater(() -> new MovieRecommenderUI(recommender).setVisible(true));
    }
}
