package ObjectModules;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Command Pattern: Receiver
public class Library implements LibraryElement {

    private List<LibraryElement> elements = new ArrayList<>();

    public void addElement(LibraryElement element) {
        elements.add(element);
    }

    public void removeElement(LibraryElement element) {
        elements.remove(element);
    }

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
    public ObjectModules.mediumType getMedia() {
        return null;
    }
}