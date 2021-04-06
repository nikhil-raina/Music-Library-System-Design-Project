package WebObjects;

import java.util.List;

public class WebMedium {
    public String getFormat() {
        return format;
    }

    public List<WebTrack> getTracks() {
        return tracks;
    }

    private String format;
        private List<WebObjects.WebTrack> tracks;
    }

