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

    public void rateMedia(Song song, float rating) {
        song.setRating(rating);
    }

    public void rateMedia(Release release, float rating) {
        release.setRating(rating);
    }

    public List<LibraryElement> searchMedia(String query) {
        String command = query.substring(0, (query.indexOf(";")));
        String req = query.substring((query.indexOf(";") + 1));
        List<LibraryElement> returnList = new ArrayList<>();
        switch (command) {
            case "song":
            case "release":
                for (LibraryElement element : elements) {
                    if (element.getTitle().contains(req) || element.getArtistGUID().contains(req) ||
                            element.getRating() >= Integer.parseInt(req) ||
                            element.getDuration() >= Integer.parseInt(req))
                        returnList.add(element);
                }
                break;
            case "artist":
                for (LibraryElement element : elements) {
                    if (element.getArtistGUID().contains(req) || element.getRating() >= Integer.parseInt(req))
                        returnList.add(element);
                }
                break;
            default:
                System.out.println("usage: search => search; <song,artist,release>; <media name>");

        }
        returnList.sort((o1, o2) -> o2.getTitle().compareTo(o2.getTitle()));
        return returnList;
    }

    public Response display() {
        StringBuilder ret = new StringBuilder();
        for (LibraryElement e: elements) {
            ret.append("Title: ").append(e.getTitle()).append("\tDuration: ").append(e.getDuration()).append("\tRating: ").append(e.getRating()).append("\n");
        }
        if(ret.length() == 0)
            return new Response("No media in the library");
        return new Response(ret.toString());
    }

    public List<LibraryElement> getElements() {
        return elements;
    }
}