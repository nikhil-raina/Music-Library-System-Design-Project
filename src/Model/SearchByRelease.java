package Model;

import ObjectModules.LibraryElement;

import java.util.List;

// Strategy Pattern: Concrete Strategy
public class SearchByRelease implements mediaSearcher {
    @Override
    public List<LibraryElement> doSearch(String mediaName, Object collection) {
        return null;
    }
}
