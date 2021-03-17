package ObjectModules;

import java.util.Objects;

public class Artist {
    private final String GUID;
    private final String artistName;
    private final String disambiguation;

    public Artist(String GUID, String artistName, String disambiguation) {
        this.GUID = GUID;
        this.artistName = artistName;
        this.disambiguation = disambiguation;
    }

    public String getArtistGUID() {
        return GUID;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getDisambiguation() {
        return disambiguation;
    }

    @Override
    public String toString() {
        return "Artist Name = " + getArtistName() + "\t";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return getArtistGUID().equals(artist.getArtistGUID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtistGUID());
    }
}
