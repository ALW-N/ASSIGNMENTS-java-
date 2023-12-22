// Generic interface for songs

import java.util.ArrayList;
import java.util.List;

interface Song<T> {
    T getSongDetails();
}

// Example of a concrete Song implementation
class MusicFile implements Song<String> {
    private String title;

    public MusicFile(String title) {
        this.title = title;
    }

    @Override
    public String getSongDetails() {
        return title;
    }
}

// Generic playlist class
class Playlist<T extends Song<?>> {
    private String playlistName;
    private List<T> songs;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.songs = new ArrayList<>();
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void addSong(T song) {
        songs.add(song);
        System.out.println("Added '" + song.getSongDetails() + "' to playlist '" + playlistName + "'");
    }

    public void displayPlaylist() {
        System.out.println("Playlist: " + playlistName);
        for (T song : songs) {
            System.out.println("- " + song.getSongDetails());
        }
    }
}

public class MusicApp {
    public static void main(String[] args) {
        // Create a playlist of MusicFiles
        Playlist<MusicFile> myPlaylist = new Playlist<>("My Favorite Songs");

        // Add songs to the playlist
        myPlaylist.addSong(new MusicFile("Song 1"));
        myPlaylist.addSong(new MusicFile("Song 2"));
        myPlaylist.addSong(new MusicFile("Song 3"));

        // Display the playlist
        myPlaylist.displayPlaylist();
    }
}
