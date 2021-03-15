package Model;

import ObjectModules.*;

import java.util.ArrayList;
import java.util.List;

// Command Pattern: Concrete Command
public class ActionSearchMedia implements Request{

    private String query;
    private Library library;
    private Database db;

    public ActionSearchMedia(String query, Library library, Database db) {
        this.query = query;
        this.library = library;
        this.db = db;
    }

    @Override
    public Response performRequest() {
        List<LibraryElement> searchedElements = new ArrayList<>();

        String command = query.substring(0, (query.indexOf(";")));
        String req = query.substring((query.indexOf(";") + 1));
        switch (command) {
            case "song":
                for (Song s : db.csvReader.getSongList().values()) {
                    if (s.getTitle().contains(req)) {
                        searchedElements.add(s);
                    }
                }
            case "release":
                for (Release r : db.csvReader.getReleaseList().values()) {
                    if (r.getTitle().contains(req)) {
                        searchedElements.add(r);
                    }
                }
                break;
//            case "artist": NEED TO IMPLEMENT SEARCHING BY ARTIST
//                for (Artist a : db.csvReader.getArtistList().values()) {
//                    if (a.getArtistGUID().contains(req) || a.getArtistName().contains(req))
//                        searchedElements.add(a.get);
//                }
//                break;
            default:
                return new Response("usage: search => search; <song,artist,release>; <media name>");

        }
        searchedElements.sort((o1, o2) -> o2.getTitle().compareTo(o2.getTitle()));
        String ret = "printing results...\n";
        for (LibraryElement e: searchedElements) {
            ret += e.toString() + "\n";
        }
        return new Response(ret);
    }
}
