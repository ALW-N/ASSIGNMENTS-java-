import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}

public class Lab9 {
    private DefaultListModel<Song> songListModel;

    public Lab9() {
        // Create a list model to store songs
        songListModel = new DefaultListModel<>();

        // Create a JList to display songs
        JList<Song> songList = new JList<>(songListModel);

        // Create text fields for user input
        JTextField titleField = new JTextField(20);
        JTextField artistField = new JTextField(20);

        // Create a "Add Song" button
        JButton addSongButton = new JButton("Add Song");
        addSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the title and artist from text fields
                String title = titleField.getText();
                String artist = artistField.getText();

                // Add the new song to the list
                if (!title.isEmpty() && !artist.isEmpty()) {
                    Song newSong = new Song(title, artist);
                    songListModel.addElement(newSong);
                    // Clear text fields after adding the song
                    titleField.setText("");
                    artistField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both title and artist.");
                }
            }
        });

        // Create a "Play" button
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected song
                Song selectedSong = songList.getSelectedValue();
                if (selectedSong != null) {
                    // Simulate playing the song by showing a dialog
                    JOptionPane.showMessageDialog(null, "Now playing: " + selectedSong.getTitle());
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a song to play.");
                }
            }
        });

        // Create the main frame
        JFrame frame = new JFrame("Music Streaming App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Title: "));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Artist: "));
        inputPanel.add(artistField);
        inputPanel.add(addSongButton);

        // Add the song list and play button to the frame
        frame.add(new JScrollPane(songList), BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(playButton, BorderLayout.SOUTH);

        // Set frame properties
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab9();
            }
        });
    }
}
