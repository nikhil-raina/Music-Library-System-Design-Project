package WebObjects;

import com.google.gson.annotations.SerializedName;

public class WebArtistCredit {
        //Repesents an artist as returned by the MusicBrainz Web Service. Used to format data from GSon.
        private String id;
        private String name;
        @SerializedName("sort-name")
        private String sortname;
        private String disambiguation;

        public String getName() {
            return name;
        }
    }

