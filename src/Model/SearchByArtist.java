package Model;

import ObjectModules.LibraryElement;

import java.util.List;

// Strategy Pattern: Concrete Strategy
public class SearchByArtist implements mediaSearcher {
    @Override
    public List<LibraryElement> doSearch(String mediaName, Object collection) {
        return null;
    }
}
