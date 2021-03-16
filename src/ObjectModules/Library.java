package ObjectModules;

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
}