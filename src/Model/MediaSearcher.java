package Model;

import ObjectModules.LibraryElement;

import java.util.List;

// Strategy Pattern: Strategy
public interface MediaSearcher {
    public List<LibraryElement> doSearch(String mediaName, Object collection);
}
