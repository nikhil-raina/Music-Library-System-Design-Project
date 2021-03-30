package Model;

import ObjectModules.*;

import java.text.ParseException;

// Command Pattern: Concrete Command
public class ActionAddMedia implements Request{

    private String query;
    private MediaCollection collection;

    public ActionAddMedia(String query, MediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() throws ParseException {
        db db = this.collection.getDb();
        Library library = this.collection.getLibrary();
        String command = query.substring(0, (query.indexOf(";")));
        String req = query.substring((query.indexOf(";") + 1));

        // NEED TO CHANGE REQ SO ITS KEY OF SONG FOR PROPER FUNCTIONALITY
        switch (command) {
            case "song":
                for (Song song : db.getSongList().values()) {
                    if (song.getTitle().equals(req)) {
                        library.addMedia(song);
                        return new Response("Media added!");
                    }
                }
                return new Response("Error - Enter valid song name");
            case "release":
                for (Release release : db.getReleaseList().values()) {
                    if (release.getTitle().equals(req)) {
                        library.addMedia(release);
                        return new Response("Media added!");
                    }
                }
                return new Response("Error - Enter valid release name");
            default:
                return new Response("Error while entering media type. Type 'help;' for more details");

        }
    }
}
