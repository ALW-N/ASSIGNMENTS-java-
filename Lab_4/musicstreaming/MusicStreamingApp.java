// Package: musicstreaming

// Main class representing the music streaming service
package musicstreaming;

import musicstreaming.model.Song;
import musicstreaming.service.MusicPlayer;

public class MusicStreamingApp {
    public static void main(String[] args) {
        // Create a song
        Song song = new Song("Nonstop ", "Drake");

        // Create a music player
        MusicPlayer musicPlayer = new MusicPlayer();

        // Play the song
        musicPlayer.play(song);

        // Pause the song
        musicPlayer.pause(song);

        // Stop the song
        musicPlayer.stop(song);
    }
}
