package Model;

import ObjectModules.LibraryElement;

import java.util.List;

// Strategy Pattern: Strategy
public interface mediaSearcher {
    public List<LibraryElement> doSearch(String mediaName, Object collection);
}
