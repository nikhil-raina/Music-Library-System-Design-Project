package ObjectModules;

public class Artist extends Media{
    private final String artistGUID;
    private final String artistName;
    private final String disambiguation;

    public Artist(String artistGUID, String artistName, String disambiguation) {
        this.artistGUID = artistGUID;
        this.artistName = artistName;
        this.disambiguation = disambiguation;
    }

    public String getArtistGUID() {
        return artistGUID;
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
}
