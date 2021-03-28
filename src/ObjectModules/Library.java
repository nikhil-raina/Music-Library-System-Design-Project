package ObjectModules;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Command Pattern: Receiver
public class Library implements LibraryElement {

    private List<LibraryElement> elements = new ArrayList<>();

    @Override
    public String getArtistGUID() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public float getRating() {
        return 0;
    }

    @Override
    public Date getIssueDate() {
        return null;
    }

    @Override
    public MediumType getMedia() {
        return null;
    }

    @Override
    public void setRating(float rating) { }

    public void addMedia(Song song) {
        elements.add(song);
    }

    public void addMedia(Release release) {
        elements.add(release);
    }

    public void removeMedia(Song song) {
        elements.remove(song);
    }

    public void removeMedia(Release release) {
        elements.remove(release);
    }

    public Response display() {
        StringBuilder ret = new StringBuilder();
        for (LibraryElement e: elements) {
            ret.append("Title: ").append(e.getTitle()).append("\tDuration: ").append(e.getDuration()).append("\tRating: ").append(e.getRating()).append("\n");
            if (e instanceof Release) {
                int idx = 1;
                Release release = (Release) e;
                for (Song song: release.getSongList()) {
                    ret.append("\t").append(idx).append(". ").append("Title: ").append(song.getTitle()).append("\tDuration: ").append(song.getDuration()).append("\tRating: ").append(song.getRating()).append("\n");
                    idx++;
                }
            }
        }
        if(ret.length() == 0)
            return new Response("No media in the library");
        return new Response(ret.toString());
    }

    public List<LibraryElement> getElements() {
        return elements;
    }

    public void makeLibrary(JsonArray elements) throws ParseException {
        this.elements = new ArrayList<>();
        int RELEASE_LIMIT = 6;
        for(int elementIdx = 0; elementIdx < elements.size(); elementIdx++) {
            JsonObject elementObj = elements.get(elementIdx).getAsJsonObject();
            if (elementObj.size() == RELEASE_LIMIT) {
                getElements().add(this.makeLibraryElement(elementObj));
            } else {
                getElements().add(new Song(elementObj.get("GUID").toString(), elementObj.get("artistGUID").toString(),
                        Integer.parseInt(elementObj.get("durationMilliSeconds").toString()),
                        elementObj.get("songTitle").toString().replace("\"",""),
                        Float.parseFloat(elementObj.get("rating").toString())));
            }
        }
    }

    public LibraryElement makeLibraryElement(JsonObject obj) throws ParseException {
        List<Song> songList = new ArrayList<>();
        JsonArray songs = obj.getAsJsonArray("songList");
        for (int songIdx = 0; songIdx < songs.size(); songIdx++) {
            JsonObject song = songs.get(songIdx).getAsJsonObject();
            songList.add(new Song(song.get("GUID").toString().replace("\"",""),
                    song.get("artistGUID").toString().replace("\"",""),
                    Integer.parseInt(song.get("durationMilliSeconds").toString()),
                    song.get("songTitle").toString().replace("\"", ""),
                    Float.parseFloat(song.get("rating").toString())));
        }
        String issueDate = obj.get("issueDate").toString().replace("\"","");
        Date date = new SimpleDateFormat("MMM dd, yyyy, HH:mm:ss a").parse(issueDate);
        return new Release(obj.get("GUID").toString().replace("\"",""),
                obj.get("artistGUID").toString().replace("\"",""),
                obj.get("releaseTitle").toString().replace("\"",""),
                obj.get("mediumType").toString().replace("\"",""),
                date, songList);
    }
}