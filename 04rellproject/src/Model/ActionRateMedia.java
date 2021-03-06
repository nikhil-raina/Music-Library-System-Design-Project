package Model;

import ObjectModules.*;

import java.text.ParseException;

// Command Pattern: Concrete Command
public class ActionRateMedia implements Request {

    private String query;
    private MediaCollection collection;

    public ActionRateMedia(String query, MediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() throws ParseException {
        Library library = this.collection.getLibrary();
        String req = query.substring((query.indexOf(";") + 1));
        String name = req.substring(0, (req.indexOf(";")));
        float rating = Float.parseFloat(req.substring(req.indexOf(";") + 1));
        boolean didRate = false;

        for (LibraryElement s : library.getElements()) {
            if (s.getTitle().equals(name)) {
                didRate = true;
                s.setRating(rating);
            }
        }
        if (didRate)
            return new Response("Media rated!");
        else
            return new Response("Sorry, media not in the Grouping...");
    }
}
