package ObjectModules;

public class Song {
    private final String GUID;
    private final String artistGUID;
    private final int durationMilliSeconds;
    private final String songTitle;

    public Song(String guid, String artistGUID, int durationMilliSeconds, String songTitle) {
        this.GUID = guid;
        this.artistGUID = artistGUID;
        this.durationMilliSeconds = durationMilliSeconds;
        this.songTitle = songTitle;
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

    public String getSongTitle() {
        return songTitle;
    }

    @Override
    public String toString() {
        return "Song Title = " + getSongTitle() + ", duration =" + getDuration();
    }
}
