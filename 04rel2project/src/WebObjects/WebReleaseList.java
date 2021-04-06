package WebObjects;

import WebObjects.WebRelease;

import java.util.List;

public class WebReleaseList {
        //Represents a Release List as returned by the MusicBrainz Web Service. Used to format data from GSon.
        private List<WebObjects.WebRelease> releases;

        public List<WebObjects.WebRelease> getRelease(){return this.releases; }
    }

