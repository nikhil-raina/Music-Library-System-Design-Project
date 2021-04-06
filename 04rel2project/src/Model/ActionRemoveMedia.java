package Model;

import ObjectModules.*;

import java.text.ParseException;
import java.util.List;

// Command Pattern: Concrete Command
public class ActionRemoveMedia implements Request {

    private String query;
    private MediaCollection collection;

    public ActionRemoveMedia(String query, MediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() throws ParseException {
        Library library = this.collection.getLibrary();
        String command = query.substring(0, (query.indexOf(";")));
        String req = query.substring((query.indexOf(";") + 1));

        switch (command) {
            case "song":
                for (LibraryElement element : library.getElements()) {
                    if (element instanceof Release) {
                        List<Song> songList = ((Release) element).getSongList();
                        for (Song song : songList) {
                            if (song.getTitle().equals(req)) {
                                songList.remove(song);
                                return new Response("Song removed!");
                            }
                        }
                    }
                    else {
                        Song song = (Song) element;
                        if (song.getTitle().equals(req)) {
                            library.removeMedia(song);
                            return new Response("Song removed!");
                        }
                    }
                }
                return new Response("Remove fail: Song not present in the user library");

            case "release":
                for (LibraryElement element : library.getElements()) {
                    Release release = (Release) element;
                    if (release.getTitle().equals(req)) {
                        library.removeMedia(release);
                        return new Response("Release removed!");
                    }
                }
                return new Response("Remove fail: Release not present in the user library");

            default:
                return new Response("Error while entering media type. Type 'help;' for more details");
        }
    }

    @Override
    public Response undo() throws ParseException {
        ActionAddMedia request = new ActionAddMedia(query,collection);
        return request.performRequest();
    }

    @Override
    public Response redo() throws ParseException {
        return null;
    }
}
