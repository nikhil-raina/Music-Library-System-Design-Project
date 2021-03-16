package Model;

import ObjectModules.Library;
import ObjectModules.LibraryElement;
import ObjectModules.Release;
import ObjectModules.Song;

import java.util.ArrayList;
import java.util.List;

// Strategy Pattern: Concrete Strategy
public class SearchByRelease implements mediaSearcher {
    @Override
    public List<LibraryElement> doSearch(String mediaName, Object collection) {
        List<LibraryElement> searchedElements = new ArrayList<>();
        Database db;
        Library library;
        Release release;
        if (collection instanceof Database) {
            db = (Database) collection;
            for (Release r: db.getReleaseList().values()) {
                if (r.getTitle().equals(mediaName)) {
                    searchedElements.add((LibraryElement) r.getSongList());
                    break;
                }
            }
        } else {
            library = (Library) collection;
            for (LibraryElement element: library.getElements()) {
                if (element.getTitle().equals(mediaName)) {
                    release = (Release) element;
                    searchedElements.add((LibraryElement) release.getSongList());
                    break;
                }
            }
        }

        // Sorting via title
        searchedElements.sort((o1, o2) -> o2.getTitle().compareTo(o2.getTitle()));
        return searchedElements;
    }
}

