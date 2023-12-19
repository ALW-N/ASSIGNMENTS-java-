import java.util.ArrayList;
import java.util.List;

abstract class PlayableItem {
    public abstract void play();

    public abstract void displayInfo();
}

class Artist {
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Artist: " + name);
    }
}

class MediaItem extends PlayableItem {
    private String title;
    private Artist artist;

    public MediaItem(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        // Implementation specific to each subclass
        System.out.println("Playing media item...");
    }

    @Override
    public void displayInfo() {
        System.out.println("Media Item: " + title + " by " + artist);
    }
}

class Song extends PlayableItem {
    private int durationInSeconds;
    private Artist artist;

    public Song(String title, Artist artist, int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing Song...");
    }

    @Override
    public void displayInfo() {
        System.out.println("Song: " + artist + " - Duration: " + durationInSeconds + " seconds");
    }
}

class Podcast extends PlayableItem {
    private int durationInSeconds;
    private Artist artist;

    public Podcast(String title, Artist artist, int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing Podcast...");
    }

    @Override
    public void displayInfo() {
        System.out.println("Podcast: " + artist + " - Duration: " + durationInSeconds + " seconds");
    }
}

class Playlist {
    private String name;
    private List<PlayableItem> items;

    public Playlist(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addPlayableItem(PlayableItem item) {
        items.add(item);
    }

    public void play() {
        System.out.println("Playing Playlist: " + name);
        for (PlayableItem item : items) {
            item.displayInfo();
            item.play();
        }
    }
}

public class Music {
    public static void main(String[] args) {
        Artist artist = new Artist("Ed Sheeran");
        Song song = new Song("Shape of You", artist, 240);

        Artist techGurus = new Artist("Tech Gurus");
        Podcast podcast = new Podcast("Tech Talk", techGurus, 1800);

        Playlist playlist = new Playlist("My Favorites");
        playlist.addPlayableItem(song);
        playlist.addPlayableItem(podcast);

        playlist.play();
    }
}