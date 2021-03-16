package Model;

import ObjectModules.LibraryElement;

import java.util.List;

// Strategy Patter: Context (describes what needs to be done)
public class MediaList {
    private final mediaSearcher searcher;
    private final String mediaName;
    private final Object collection;


    public MediaList(mediaSearcher searcher, String mediaName, Object collection) {
        this.searcher = searcher;
        this.mediaName = mediaName;
        this.collection = collection;
    }

    public String getMediaName() {
        return mediaName;
    }

    public Object getCollection() {
        return collection;
    }

    public mediaSearcher getSearcher() {
        return searcher;
    }

    public List<LibraryElement> search() {
        return getSearcher().doSearch(getMediaName(), getCollection());
    }

}
