package Model;

import ObjectModules.MediaCollection;
import ObjectModules.Response;

// Command Pattern: Concrete Command
public class ActionCreateCollection implements Request {

    private String query;
    private MediaCollection collection;

    public ActionCreateCollection(String query, MediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() {

        return new Response("There is no requirement for this.");
    }

}
