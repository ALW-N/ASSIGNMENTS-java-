class StreamingService {
    private MusicPlayer musicPlayer;
    private int iterationCounter;
    private final int MAX_ITERATIONS = 3;

    public StreamingService() {
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
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                iterationCounter++;
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

        // Start the streaming service (multithreaded playback) for a limited number of iterations
        streamingService.startStreaming();
    }
}
