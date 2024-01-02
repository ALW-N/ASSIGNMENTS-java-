// Package: musicstreaming.model

// Song class representing a music track
package musicstreaming.model;

import musicstreaming.service.Playable;

public class Song implements Playable {
    private String title;
    private String artist;

    // Constructor
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getters and setters (if needed)

    @Override
    public void play() {
        // Logic to start playing the song
        System.out.println("Playing: " + title + " by " + artist);
    }

    @Override
    public void pause() {
        // Logic to pause the song
        System.out.println("Pausing: " + title);
    }

    @Override
    public void stop() {
        // Logic to stop playing the song
        System.out.println("Stopping: " + title);
    }
}
