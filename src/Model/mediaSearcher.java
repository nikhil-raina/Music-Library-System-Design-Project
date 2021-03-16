package Model;

import ObjectModules.Media;
import ObjectModules.mediaCollection;

import java.util.List;

// Strategy Pattern: Strategy
public interface mediaSearcher {
    public List<Media> doSearch(String mediaName, mediaCollection collection);
}
