package Model;

import ObjectModules.*;

import java.text.ParseException;

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
        Database db = this.collection.getDb();
        Library library = this.collection.getLibrary();
        String command = query.substring(0, (query.indexOf(";")));
        String req = query.substring((query.indexOf(";") + 1));

        // NEED TO CHANGE REQ SO ITS KEY OF SONG FOR PROPER FUNCTIONALITY
        switch (command) {
            case "song":
                for (LibraryElement element : library.getElements()) {
                    boolean found = false;
                    if (element instanceof Release) {
                        for (Song song: ((Release) element).getSongList()) {
                            if (song.getTitle().equals(req)) {
                                library.removeMedia(song);
                                ((Release) element).getSongList().remove(song);
                                found = true;
                                break;
                            }
                        }
                    }
                    if (found) {
                        break;
                    }
                    if (element.getTitle().equals(req)) {
                        Song song = (Song) element;
                        library.removeMedia(song);
                        break;
                    }
                }
                break;

            case "release":
                for (Release release : db.getReleaseList().values()) {
                    if (release.getTitle().equals(req)) {
                        library.removeMedia(release);
                        break;
                    }
                }
                break;

            default:
                return new Response("Error while entering media type. Type 'help;' for more details");
        }
        return new Response("Media removed!");
    }
}
