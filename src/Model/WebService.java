package Model;

import ObjectModules.Artist;
import ObjectModules.Release;
import ObjectModules.Song;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class WebService implements db {
    private static final String SEARCH_URL_SONG =
            "https://musicbrainz.org/ws/2/recording?query=";
    private static final String SEARCH_URL_RELEASE =
            "https://musicbrainz.org/ws/2/release?query=";
    private static final String LOOKUP_RELEASE_URL = "https://musicbrainz.org/ws/2/release/";
    private static final String INC_SONGLIST_URL = "?inc=recordings";
    private static final String JSON_FORMAT = "&fmt=json";
    private HashMap<String, Song> songList = new HashMap<>();
    private HashMap<String, Release> releaseList = new HashMap<>();
    private static final WebService INSTANCE = new WebService();


    public static WebService getInstance(){
        return INSTANCE;
    }
    @Override
    public HashMap<String, Artist> getArtistList() {
        return null;
    }

    @Override
    public HashMap<String, Release> getReleaseList() {
        return this.releaseList;
    }

    @Override
    public HashMap<String, Song> getSongList() {
        return this.songList;
    }


    public void searchSongList(String query) {
        Gson gson = new Gson();
        WebRecording webrecording;
        HashMap<String, Song> newsongList = new HashMap<>();
        query = String.join("%20", query);

        try {
            URL queryUrl = new URL(SEARCH_URL_SONG + query + JSON_FORMAT);

            HttpsURLConnection connection =
                    (HttpsURLConnection) queryUrl.openConnection();

            connection.setRequestProperty("User-Agent",
                    "SWEN-262 Semester Project G4 (https://www.se.rit.edu)");

            connection.connect();
            InputStream input = connection.getInputStream();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStreamReader iReader = new InputStreamReader(input);
                BufferedReader reader = new BufferedReader(iReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    webrecording = gson.fromJson(line, WebRecording.class);
                    List<WebSong> recordings = webrecording.getrecordings();

                    for (int i = 0; i < recordings.size(); i++) {
                        System.out.print(i + 1 + ") " + recordings.get(i));
                        newsongList.put(recordings.get(i).title, recordings.get(i).toSong());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Connection error");
        }
        this.songList = newsongList;
    }


    public void searchReleaseList(String query) {
        Gson gson = new Gson();
        WebReleaseList webReleaseList;
        HashMap<String, Release> newreleaseList = new HashMap<>();
        query = String.join("%20", query);

        try {
            URL queryUrl = new URL(SEARCH_URL_RELEASE + query + JSON_FORMAT);

            HttpsURLConnection connection =
                    (HttpsURLConnection) queryUrl.openConnection();

            connection.setRequestProperty("User-Agent",
                    "SWEN-262 Semester Project G4 (https://www.se.rit.edu)");

            connection.connect();
            InputStream input = connection.getInputStream();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStreamReader iReader = new InputStreamReader(input);
                BufferedReader reader = new BufferedReader(iReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    webReleaseList = gson.fromJson(line, WebReleaseList.class);
                    List<WebRelease> releases = webReleaseList.getRelease();
                    for (int i = 0; i < releases.size(); i++) {
                        System.out.print(i + 1 + ") " + releases.get(i));
                            newreleaseList.put(releases.get(i).title, releases.get(i).toRelease());
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Connection error");
        }
        this.releaseList = newreleaseList;
    }


    public ArrayList<Song> populateSongs(String GUID, String ArtistGUID){
        //When adding a release, adds the list of songs on the release to the release.
        //A release cannot be queried and then have its related songs added in one request, thus this method
        Gson gson = new Gson();
        ArrayList<Song> newsongList = new ArrayList<>();


        try {
            URL queryUrl = new URL(LOOKUP_RELEASE_URL + GUID + INC_SONGLIST_URL + JSON_FORMAT);

            HttpsURLConnection connection =
                    (HttpsURLConnection) queryUrl.openConnection();

            connection.setRequestProperty("User-Agent",
                    "SWEN-262 Semester Project G4 (https://www.se.rit.edu)");

            connection.connect();
            InputStream input = connection.getInputStream();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStreamReader iReader = new InputStreamReader(input);
                BufferedReader reader = new BufferedReader(iReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    WebRelease release = gson.fromJson(line, WebRelease.class);
                    List<WebTrack> tracks = release.media.get(0).tracks;
                    for (int i = 0; i < tracks.size(); i++) {
                        System.out.print(i + 1 + ") " + tracks.get(i).recording.title + "\n");
                        newsongList.add(tracks.get(i).recording.toSong(ArtistGUID));

                    }
                }
            }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Connection error");
            }

            return newsongList;

    }


    public static class WebRecording{
        //Represents a Recording as returned by the MusicBrainz Web Service. Used to format data from GSon.
        private String created;
        private int count;
        private int offset;
        private List<WebSong> recordings;

        public List<WebSong> getrecordings() {
            return this.recordings;
        }

    }

    public static class WebReleaseList{
        //Represents a Release List as returned by the MusicBrainz Web Service. Used to format data from GSon.
        private List<WebRelease> releases;

        public List<WebRelease> getRelease(){return this.releases; }
    }


    public static class WebSong{
        //Represents a Song as returned by the MusicBrainz Web Service. Used to format data from GSon.
            private String id;
            private int score;
            private String title;
            private int length;
            private String disambiguation;
            private String video;
            @SerializedName("artist-credit")
            private List<artistcredit> credits;



            public String toString(){
                return this.title +" by " + credits.get(0).getName() + "\n";
            }
            public Song toSong(){
                return new Song(id, credits.get(0).getName(), length, title);
            }
            public Song toSong(String ArtistGUID){
                return new Song(id, ArtistGUID, length, title);
            }
            public void setCredits(List<artistcredit> credits){
                this.credits = credits;
            }
    }

    public static class artistcredit {
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
    public static class WebRelease {
        //Represents a release as returned by the MusicBrainz Web Service. Used to format data from GSon.
        private String id;
        private String title;
        @SerializedName("artist-credit")
        private List<artistcredit> credits;
        private String date;
        private List<WebMedium> media;
        private String format;
        private List<Song> songList;
        //note that the songlist will be empty

        public Release toRelease(){
            Date newdate = null;
            if(media.get(0).format == null){
                media.get(0).format = "No type";
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
                return new Release(id, credits.get(0).getName(), title, media.get(0).format, newdate, songList);
            } catch (ParseException e) {
                System.out.print("Date formatting error!");
                return null;
            }
        }
        public String toString(){
            return this.title +" by " + credits.get(0).getName() + "\n";
        }

    }

    public static class WebMedium{
        private String format;
        private List<WebTrack> tracks;
    }

    public static class WebTrack{
        private WebSong recording;
    }

}
