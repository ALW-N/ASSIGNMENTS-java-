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
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty. Add tracks first.");
            return;
        }

        // Simulate playing the current track
        MusicTrack currentTrack = playlist.get(currentTrackIndex);
        System.out.println("Playing: " + currentTrack.getTitle());

        // Increment the index for the next track
        currentTrackIndex = (currentTrackIndex + 1) % playlist.size();
    }
}

class StreamingService {
    private MusicPlayer musicPlayer;

    public StreamingService() {
        this.musicPlayer = new MusicPlayer();
    }

    public void addTrackToPlaylist(String trackTitle) {
        MusicTrack track = new MusicTrack(trackTitle);
        musicPlayer.addTrack(track);
        System.out.println("Track added to the playlist: " + trackTitle);
    }

    public void startStreaming() {
        Thread playbackThread = new Thread(() -> {
            while (true) {
                musicPlayer.play();

                try {
                    // Simulate a delay between tracks
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        playbackThread.start();
    }
}

public class MusicStreamingApp {
    public static void main(String[] args) {
        StreamingService streamingService = new StreamingService();

        // Add some tracks to the playlist
        streamingService.addTrackToPlaylist("Track 1");
        streamingService.addTrackToPlaylist("Track 2");
        streamingService.addTrackToPlaylist("Track 3");

        // Start the streaming service (multithreaded playback)
        streamingService.startStreaming();
    }
}

