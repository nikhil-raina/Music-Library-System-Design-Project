package Model;

import ObjectModules.*;

import java.util.List;

// Strategy Pattern: Concrete Strategy
public class SearchByArtist implements MediaSearcher {
    @Override
    public List<LibraryElement> doSearch(String mediaName, Object collection) {
//        List<LibraryElement> searchedElements = new ArrayList<>();
//        Database db = null;
//        Library library = null;
//        if (collection instanceof Database) {
//            db = (Database) collection;
//            for (Artist a : db.csvReader.getArtistList().values()) {
//                if (a.getArtistName().contains(mediaName)) {
//                    // Artist is not a Library Element
//                    // searchedElements.add(a);
//                }
//            }
//        } else {
//            library = (Library) collection;
//            for (Song s : db.csvReader.getSongList().values()) {
//                if (s.getTitle().contains(mediaName)) {
//                    searchedElements.add(s);
//                }
//            }
//        }
//
//        // Sorting via title
//        searchedElements.sort((o1, o2) -> o2.getTitle().compareTo(o2.getTitle()));
//        return searchedElements;
        return null;
    }
}
