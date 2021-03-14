package Model;

import ObjectModules.Response;
import ObjectModules.mediaCollection;

// Command Pattern: Concrete Command
public class ActionCreateCollection implements Request {

    private String query;
    private mediaCollection collection;

    public ActionCreateCollection(String query, mediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() {

        return null;
    }

}
