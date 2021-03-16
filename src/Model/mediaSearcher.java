package Model;

import ObjectModules.Media;
import ObjectModules.mediaCollection;

import java.util.List;

public interface mediaSearcher {
    public List<Media> doSearch(String mediaName, mediaCollection collection);
}
