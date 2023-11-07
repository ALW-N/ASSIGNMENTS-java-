public class Song {

    private String title;
    private String artist;
    private String album;
    private int duration;


    public Song() {
        title = "Untitled";
        artist = "Unknown";
        album = "No Album";
        duration = 0;
    }

    public Song(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Album: " + album);
        System.out.println("Duration: " + duration + " seconds");
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    public void play(boolean shuffle) {
        if (shuffle) {
            System.out.println("Shuffling and playing " + title + " by " + artist);
        } else {
            play();
        }
    }

    public void play(boolean shuffle, boolean repeat) {
        if (repeat) {
            System.out.println("Repeating and playing " + title + " by " + artist);
        } else {
            play(shuffle);
        }
    }

    public static void main(String[] args) {

        Song song1 = new Song("Song 1", "Artist 1", "Album 1", 180);
        Song song2 = new Song("Song 2", "Artist 2", "Album 2", 240);

        song1.displayInfo();
        song2.displayInfo();

        song1.play();
        song1.play(true);
        song1.play(true, true);
    }
}
