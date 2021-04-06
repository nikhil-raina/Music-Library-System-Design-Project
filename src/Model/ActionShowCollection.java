package Model;

import ObjectModules.MediaCollection;
import ObjectModules.Response;

import java.text.ParseException;

// Command Pattern: Concrete Command
public class ActionShowCollection implements Request{

    private String query;
    private MediaCollection collection;

    public ActionShowCollection(String query, MediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() {
        return this.collection.getLibrary().display();
    }

    @Override
    public Response undo() throws ParseException {
        return null;
    }

    @Override
    public Response redo() throws ParseException {
        return null;
    }
}
