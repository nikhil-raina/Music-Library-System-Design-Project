package ObjectModules;

import java.util.Date;
import java.util.Objects;

public class Song implements LibraryElement {
    private final String GUID;
    private final String artistGUID;
    private final int durationMilliSeconds;
    private final String songTitle;
    private float rating;

    public Song(String guid, String artistGUID, int durationMilliSeconds, String songTitle) {
        this.GUID = guid;
        this.artistGUID = artistGUID;
        this.durationMilliSeconds = durationMilliSeconds;
        this.songTitle = songTitle;
        this.rating = 0;
    }

    public String getGUID() {
        return GUID;
    }

    public String getArtistGUID() {
        return artistGUID;
    }

    public int getDuration() {
        return durationMilliSeconds;
    }

    public String getTitle() {
        return songTitle;
    }

    public ObjectModules.mediumType getMedia() {
        return null;
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public Date getIssueDate() {
        return null;
    }

    @Override
    public String toString() {
        return "Song Title = " + getTitle() + ", duration = " + getDuration();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return getGUID().equals(song.getGUID()) && getTitle().equals(song.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGUID(), getTitle());
    }
}
