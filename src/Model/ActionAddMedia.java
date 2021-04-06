package Model;

import ObjectModules.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

// Command Pattern: Concrete Command
public class ActionAddMedia implements Request {

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
                        return new Response("\nMedia added!");
                    }
                }
                return new Response("Error - Enter valid song name");
            case "release":
                for (Release release : db.getReleaseList().values()) {
                    if (release.getTitle().equals(req)) {
                        if(db instanceof WebService){
                            System.out.print("Populating songs...\n");
                            ArrayList<Song> songList = WebService.getInstance().populateSongs(release.getGUID(), release.getArtistGUID());
                            release.setSongList(songList);
                        }
                        library.addMedia(release);
                        return new Response("\nMedia added!");
                    }
                }
                return new Response("Error - Enter valid release name");
            default:
                return new Response("Error while entering media type. Type 'help;' for more details");

        }
    }

    @Override
    public Response undo() throws ParseException {
        ActionRemoveMedia request = new ActionRemoveMedia(query,collection);
        return request.performRequest();
    }

    @Override
    public Response redo() throws ParseException {
        return this.performRequest();
    }
}