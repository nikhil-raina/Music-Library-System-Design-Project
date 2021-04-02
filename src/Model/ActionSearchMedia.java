package Model;

import ObjectModules.*;

import java.text.ParseException;

// Command Pattern: Concrete Command
public class ActionSearchMedia implements Request{

    private String query;
    private MediaCollection collection;

    public ActionSearchMedia(String query, MediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() {
        Response response = new Response();
        MediaList mediaList;
        String mediaType = query.substring(0, (query.indexOf(";")));
        String mediaName = query.substring((query.indexOf(";") + 1));
        Object collection = this.collection.getLibrary();
        if (mediaName.contains(";")) {
            collection = this.collection.getDb();
            mediaName = mediaName.substring(0, mediaName.indexOf(";"));
        }
        switch (mediaType) {
            case "song":
                mediaList = new MediaList(new SearchBySong(), mediaName, collection);
                break;
            case "release":
                mediaList = new MediaList(new SearchByRelease(), mediaName, collection);
                break;
            case "artist":
                mediaList = new MediaList(new SearchByArtist(), mediaName, collection);
                break;
            default:
                return new Response("Error while entering media type. Type 'help;' for more details");
        }
        response.makeResponse(mediaList.search());
        return response;
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
