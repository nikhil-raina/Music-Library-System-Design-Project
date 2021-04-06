package Model;

import ObjectModules.Library;
import ObjectModules.LibraryElement;
import ObjectModules.Release;
import ObjectModules.Song;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Strategy Pattern: Concrete Strategy
public class SearchBySong implements MediaSearcher {
    @Override
    public List<LibraryElement> doSearch(String mediaName, Object collection) {
        List<LibraryElement> searchedElements = new ArrayList<>();
        Grouping db;
        WebService dbr;
        Library library;
        if (collection instanceof Grouping) {
            db = (Grouping) collection;
            System.out.print("GROUPING");
            for (Song s : db.getSongList().values()) {
                if (s.getTitle().contains(mediaName)) {
                    searchedElements.add(s);
                }
            }
        }
        else if (collection instanceof WebService) {
            dbr = (WebService) collection;
            dbr.searchSongList(mediaName);
            for (Song s : dbr.getSongList().values()) {
                if (s.getTitle().contains(mediaName)) {
                    searchedElements.add(s);
                }
            }
        }

        else {
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
        searchedElements.sort(Comparator.comparing(LibraryElement::getTitle));
        return searchedElements;
    }
}
