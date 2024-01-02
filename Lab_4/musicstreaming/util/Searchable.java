// Package: musicstreaming.util

// Searchable interface defining common behaviors for searchable items
package musicstreaming.util;

import musicstreaming.model.Song;

import java.util.ArrayList;
import java.util.List;

public interface Searchable {
    List<Song> search(String keyword);
}
