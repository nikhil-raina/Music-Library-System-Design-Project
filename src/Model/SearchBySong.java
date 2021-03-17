package Model;

import ObjectModules.Library;
import ObjectModules.LibraryElement;
import ObjectModules.Release;
import ObjectModules.Song;

import java.util.ArrayList;
import java.util.List;

// Strategy Pattern: Concrete Strategy
public class SearchBySong implements MediaSearcher {
    @Override
    public List<LibraryElement> doSearch(String mediaName, Object collection) {
        List<LibraryElement> searchedElements = new ArrayList<>();
        Database db;
        Library library;
        if (collection instanceof Database) {
            db = (Database) collection;
            for (Song s : db.getSongList().values()) {
                if (s.getTitle().contains(mediaName)) {
                    searchedElements.add(s);
                }
            }
        } else {
            library = (Library) collection;
            for (LibraryElement element: library.getElements()) {
                if (element.getTitle().equals(mediaName)) {
                    searchedElements.add(element);
                    break;
                } else if(element instanceof Release) {
                    for (Song song: ((Release) element).getSongList()) {
                        if (song.getTitle().equals(mediaName)) {
                            searchedElements.add(song);
                            break;
                        }
                    }
                }
            }
        }

        // Sorting via title
        searchedElements.sort((o1, o2) -> o2.getTitle().compareTo(o2.getTitle()));
        return searchedElements;
    }
}
