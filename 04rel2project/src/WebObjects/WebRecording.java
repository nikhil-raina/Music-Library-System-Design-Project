package WebObjects;

import java.util.List;

public class WebRecording {
        //Represents a Recording as returned by the MusicBrainz Web Service. Used to format data from GSon.
        private String created;
        private int count;
        private int offset;
        private List<WebSong> recordings;

        public List<WebSong> getrecordings() {
            return this.recordings;
        }

    }

