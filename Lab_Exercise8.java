import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Song class representing a song in the music streaming service
class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}

// Playlist class representing a user's playlist
class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void displayPlaylist() {
        System.out.println("Playlist: " + name);
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}

// MusicStreamingService class managing playlists and songs
class MusicStreamingService {
    Map<String, Playlist> playlists;

    public MusicStreamingService() {
        this.playlists = new HashMap<>();
    }

    public void createPlaylist(String playlistName) {
        Playlist playlist = new Playlist(playlistName);
        playlists.put(playlistName, playlist);
    }

    public void addSongToPlaylist(String playlistName, Song song) {
        Playlist playlist = playlists.get(playlistName);
        if (playlist != null) {
            playlist.addSong(song);
        } else {
            System.out.println("Playlist not found: " + playlistName);
        }
    }

    public void displayPlaylists() {
        System.out.println("Available Playlists:");
        for (Map.Entry<String, Playlist> entry : playlists.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}

public class Lab_Exercise8 {
    public static void main(String[] args) {
        MusicStreamingService streamingService = new MusicStreamingService();

        streamingService.createPlaylist("My Favorites");
        streamingService.createPlaylist("Workout Mix");

        Song song1 = new Song("Song 1", "Artist 1");
        Song song2 = new Song("Song 2", "Artist 2");

        streamingService.addSongToPlaylist("My Favorites", song1);
        streamingService.addSongToPlaylist("Workout Mix", song2);

        streamingService.displayPlaylists();
        streamingService.addSongToPlaylist("Nonexistent Playlist", new Song("Invalid Song", "Invalid Artist"));

        streamingService.displayPlaylists();
        streamingService.playlists.get("My Favorites").displayPlaylist();
        streamingService.playlists.get("Workout Mix").displayPlaylist();
    }
}
