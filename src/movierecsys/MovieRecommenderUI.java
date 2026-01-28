package movierecsys;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MovieRecommenderUI extends JFrame {
    private MovieRecommendationSystem recommender;
    private JComboBox<String> genreDropdown;
    private DefaultTableModel tableModel;

    public MovieRecommenderUI(MovieRecommendationSystem recommender) {
        this.recommender = recommender;
        setTitle("Movie Recommendation System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        try {
            BufferedImage backgroundImage = ImageIO.read(new File("background.jpg"));
            mainPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel topPanel = new JPanel(new FlowLayout());
        genreDropdown = new JComboBox<>(new String[]{
            "Action", "Sci-Fi", "Drama", "Fantasy", "Biography",
            "Thriller", "War", "Romance", "Musical", "Comedy"
        });
        JButton recommendButton = new JButton("Recommend");
        topPanel.add(new JLabel("Genre:"));
        topPanel.add(genreDropdown);
        topPanel.add(recommendButton);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Title", "Genre", "Rating", "Year", "Description"}, 0);
        JTable movieTable = new JTable(tableModel);
        mainPanel.add(new JScrollPane(movieTable), BorderLayout.CENTER);

        recommendButton.addActionListener(e ->
            updateMovieTable(recommender.getMoviesByGenre((String) genreDropdown.getSelectedItem())));

        movieTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = movieTable.getSelectedRow();
                if (selectedRow >= 0) showMovieDetailsPopup(selectedRow);
            }
        });
    }

    private void updateMovieTable(List<Movie> movies) {
        tableModel.setRowCount(0);
        movies.forEach(movie -> tableModel.addRow(new Object[]{
            movie.getTitle(), movie.getGenre(), movie.getRating(), movie.getYear(), movie.getDescription()
        }));
    }

    private void showMovieDetailsPopup(int selectedRow) {
        String title       = (String)  tableModel.getValueAt(selectedRow, 0);
        String genre       = (String)  tableModel.getValueAt(selectedRow, 1);
        double rating      = (Double)  tableModel.getValueAt(selectedRow, 2);
        int    year        = (Integer) tableModel.getValueAt(selectedRow, 3);
        String description = (String)  tableModel.getValueAt(selectedRow, 4);

        JTextArea detailsArea = new JTextArea(String.format(
            "Title: %s\nGenre: %s\nRating: %.1f\nYear: %d\n\nDescription:\n%s",
            title, genre, rating, year, description
        ));
        detailsArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(detailsArea), "Movie Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        MovieRecommendationSystem recommender = new MovieRecommendationSystem();
        recommender.loadMoviesFromTextFile("movies.txt");
        SwingUtilities.invokeLater(() -> new MovieRecommenderUI(recommender).setVisible(true));
    }
}
