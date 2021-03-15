package Model;

import ObjectModules.*;

import java.text.ParseException;

// Command Pattern: Concrete Command
public class ActionRateMedia implements Request {

    private String query;
    private Library library;
    private Database db;

    public ActionRateMedia(String query, Library library, Database db) {
        this.query = query;
        this.library = library;
        this.db = db;
    }

    @Override
    public Response performRequest() throws ParseException {
        String command = query.substring(0, (query.indexOf(";")));
        String req = query.substring((query.indexOf(";") + 1));
        String name = req.substring(0, (req.indexOf(";")));
        float rating = Float.parseFloat(req.substring(req.indexOf(";") + 1));

        Song rateThisSong = null;
        for (LibraryElement s : this.library.getElements()) {
            if (s.getTitle().equals(name)) {
                s.setRating(rating);
            }
        }
        return  new Response("Media rated!");
    }
}
