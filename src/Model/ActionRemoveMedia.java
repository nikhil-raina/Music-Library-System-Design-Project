package Model;

import ObjectModules.Library;
import ObjectModules.Release;
import ObjectModules.Response;
import ObjectModules.Song;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

// Command Pattern: Concrete Command
public class ActionRemoveMedia implements Request {

    private String query;
    private Library library;
    private Database db;

    public ActionRemoveMedia(String query, Library library, Database db) {
        this.query = query;
        this.library = library;
        this.db = db;
    }

    @Override
    public Response performRequest() throws ParseException {
        String command = query.substring(0, (query.indexOf(";")));
        String req = query.substring((query.indexOf(";") + 1));

        // NEED TO CHANGE REQ SO ITS KEY OF SONG FOR PROPER FUNCTIONALITY
        switch (command) {
            case "song":
                String guid = "ERROR";
                String artistGUID = "ERROR";
                int durationMilliSeconds = -1;
                String songTitle = "ERROR";
                for (Song s : db.csvReader.getSongList().values()) {
                    if (s.getTitle().equals(req)) {
                        guid = s.getGUID();
                        artistGUID = s.getArtistGUID();
                        durationMilliSeconds = s.getDuration();
                        songTitle = s.getTitle();
                    }
                }
                this.library.removeMedia(new Song(guid, artistGUID, durationMilliSeconds, songTitle));
            case "release":
                guid = "ERROR";
                artistGUID = "ERROR";
                String releaseTitle = "ERROR";
                String mediumType = "ERROR";
                Date issueDate = new Date();
                List<Song> songList = null;
                for (Release r : db.csvReader.getReleaseList().values()) {
                    if (r.getTitle().equals(req)) {
                        guid = r.getGUID();
                        artistGUID = r.getArtistGUID();
                        releaseTitle = r.getTitle();
                        mediumType = r.getMedia().toString();
                        issueDate = r.getIssueDate();
                        songList = r.getSongList();
                    }
                }
                this.library.removeMedia(new Release(guid, artistGUID, releaseTitle, mediumType, issueDate, songList));
        }
        return new Response("Media removed!");
    }
}
