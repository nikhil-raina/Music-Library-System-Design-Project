package Model;

import ObjectModules.MediaCollection;
import ObjectModules.Response;

import java.text.ParseException;

public class ActionOnline implements Request {

    private final MediaCollection collection;

    public ActionOnline(MediaCollection collection) {
        this.collection = collection;
    }

    @Override
    public Response performRequest() throws ParseException {
        collection.setOnline();
        return new Response("Switched to the Online database");
    }
}
