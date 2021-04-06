package WebObjects;

import ObjectModules.Release;
import ObjectModules.Song;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WebRelease {
        //Represents a release as returned by the MusicBrainz Web Service. Used to format data from GSon.
        private String id;
        private String title;
        @SerializedName("artist-credit")
        private List<WebObjects.WebArtistCredit> credits;
        private String date;
        private List<WebObjects.WebMedium> media;
        private String format;
        private List<Song> songList;
        //note that the songlist will be empty

    public String getId() {
        return id;
    }

    public List<WebMedium> getMedia() {
        return media;
    }

    public String getTitle() {
        return title;
    }

    public String getFormat() {
        return format;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public Release toRelease(){
            Date newdate = null;
            String format = media.get(0).getFormat();
            if(format == null){
                format = "No type";
            }
            try {
                if(date == null){
                    date = "0000";
                }
                if (date.length() == 4) {
                    newdate = new SimpleDateFormat("yyyy").parse(date);
                } else if (date.length() == 7) {
                    newdate = new SimpleDateFormat("yyyy-mm").parse(date);
                } else if (date.length() == 10) {
                    newdate = new SimpleDateFormat("yyyy-mm-dd").parse(date);


                }
                return new Release(id, credits.get(0).getName(), title, format, newdate, songList);
            } catch (ParseException e) {
                System.out.print("Date formatting error!");
                return null;
            }
        }
        public String toString(){
            return this.title +" by " + credits.get(0).getName() + "\n";
        }

    }

