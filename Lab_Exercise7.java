import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Structure for a song
class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getter methods for accessing private fields
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

public class Lab_Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of songs from the user
        System.out.print("Enter the number of songs: ");
        int numSongs = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Create a list of songs
        List<Song> songs = new ArrayList<>();

        // Get songs information from the user
        for (int i = 0; i < numSongs; i++) {
            System.out.print("Enter the title of song " + (i + 1) + ": ");
            String title = scanner.nextLine();

            System.out.print("Enter the artist of song " + (i + 1) + ": ");
            String artist = scanner.nextLine();

            songs.add(new Song(title, artist));
        }

        // Ask the user for sorting criteria
        System.out.print("\nChoose sorting criteria (1 for title, 2 for artist): ");
        int sortingChoice = scanner.nextInt();

        // Sort songs based on user input
        if (sortingChoice == 1) {
            songs.sort(Comparator.comparing(Song::getTitle));
        } else if (sortingChoice == 2) {
            songs.sort(Comparator.comparing(Song::getArtist));
        } else {
            System.out.println("Invalid sorting choice. Defaulting to sorting by title.");
            songs.sort(Comparator.comparing(Song::getTitle));
        }

        // Display sorted songs
        System.out.println("\nSorted Songs:");
        for (Song song : songs) {
            System.out.println("Title: " + song.getTitle() + ", Artist: " + song.getArtist());
        }

        // Close the scanner
        scanner.close();
    }
}
