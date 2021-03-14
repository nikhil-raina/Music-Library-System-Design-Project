package ObjectModules;

import java.util.Date;

public interface LibraryElement {
    public String getArtistGUID();
    public String getTitle();
    public int getDuration();
    public float getRating();
    public Date getIssueDate();
    public ObjectModules.mediumType getMedia();
}
