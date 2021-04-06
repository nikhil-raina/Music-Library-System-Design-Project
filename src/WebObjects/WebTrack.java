package WebObjects;

public class WebTrack {
    public WebSong getRecording() {
        return recording;
    }

    //Represents a Track as returned by the MusicBrainz Web Service. Used to format data from GSon.
    private WebSong recording;
    }

