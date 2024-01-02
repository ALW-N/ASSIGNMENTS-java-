// Package: musicstreaming.service

// MusicPlayer class implementing the Playable interface
package musicstreaming.service;

import musicstreaming.model.Song;

public class MusicPlayer {
    public void play(Playable playable) {
        // Logic to play a playable item
        playable.play();
    }

    public void pause(Playable playable) {
        // Logic to pause a playable item
        playable.pause();
    }

    public void stop(Playable playable) {
        // Logic to stop a playable item
        playable.stop();
    }
}
