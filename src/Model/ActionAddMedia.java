package Model;

import ObjectModules.Response;
import ObjectModules.mediaCollection;

// Command Pattern: Concrete Command
public class ActionAddMedia implements Request{

    private String query;
    private mediaCollection collection;

    public ActionAddMedia(String query, mediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() {

        return null;
    }
}
