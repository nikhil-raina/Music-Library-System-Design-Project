package Model;

import ObjectModules.Response;
import ObjectModules.mediaCollection;

public class ActionShowCollection implements Request{

    private String query;
    private mediaCollection collection;

    public ActionShowCollection(String query, mediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() {

        return null;
    }
}
