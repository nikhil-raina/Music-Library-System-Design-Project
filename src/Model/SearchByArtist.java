package Model;

import ObjectModules.Media;

import java.util.List;

// Strategy Pattern: Concrete Strategy
public class SearchByArtist implements mediaSearcher {
    @Override
    public List<Media> doSearch(String mediaName, Object collection) {
        return null;
    }
}
