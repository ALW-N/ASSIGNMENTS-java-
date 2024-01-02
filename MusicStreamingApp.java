import java.util.ArrayList;
import java.util.List;

class MusicTrack {
    private String title;

    public MusicTrack(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class MusicPlayer {
    private List<MusicTrack> playlist;
    private int currentTrackIndex;

    public MusicPlayer() {
        this.playlist = new ArrayList<>();
        this.currentTrackIndex = 0;
    }

    public void addTrack(MusicTrack track) {
        playlist.add(track);
    }

    public void play() {
        if (currentTrackIndex < playlist.size()) {
            MusicTrack currentTrack = playlist.get(currentTrackIndex);
            System.out.println("Now playing: " + currentTrack.getTitle());
            currentTrackIndex++;
        } else {
            System.out.println("End of playlist");
        }
    }
}

public class MusicStreamingApp {
    private MusicPlayer musicPlayer;
    private int iterationCounter;
    private final int MAX_ITERATIONS = 3;

    public MusicStreamingApp() {
        this.musicPlayer = new MusicPlayer();
        this.iterationCounter = 0;
    }

    public void addTrackToPlaylist(String trackTitle) {
        MusicTrack track = new MusicTrack(trackTitle);
        musicPlayer.addTrack(track);
        System.out.println("Track added to the playlist: " + trackTitle);
    }

    public void startStreaming() {
        Thread playbackThread = new Thread(() -> {
            while (iterationCounter < MAX_ITERATIONS) {
                musicPlayer.play();

                try {
                    // Simulate a delay between tracks
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                iterationCounter++;
            }
        });

        playbackThread.start();
    }

    public static void main(String[] args) {
        MusicStreamingApp streamingService = new MusicStreamingApp();

        // Add some tracks to the playlist
        streamingService.addTrackToPlaylist("Track 1");
        streamingService.addTrackToPlaylist("Track 2");
        streamingService.addTrackToPlaylist("Track 3");

        // Start the streaming service (multithreaded playback) for a limited number of iterations
        streamingService.startStreaming();
    }
}
