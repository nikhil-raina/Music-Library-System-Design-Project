package WebObjects;

import ObjectModules.Song;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WebSong {
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    //Represents a Song as returned by the MusicBrainz Web Service. Used to format data from GSon.
            private String id;
            private int score;
            private String title;
            private int length;
            private String disambiguation;
            private String video;
            @SerializedName("artist-credit")
            private List<WebArtistCredit> credits;



            public String toString(){
                return this.title +" by " + credits.get(0).getName() + "\n";
            }
            public Song toSong(){
                return new Song(id, credits.get(0).getName(), length, title);
            }
            public Song toSong(String ArtistGUID){
                return new Song(id, ArtistGUID, length, title);
            }
            public void setCredits(List<WebObjects.WebArtistCredit> credits){
                this.credits = credits;
            }
    }

