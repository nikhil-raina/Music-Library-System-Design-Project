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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class WebService implements db {
    private static final String SEARCH_URL =
            "https://musicbrainz.org/ws/2/recording?query=";
    private static final String JSON_FORMAT = "&fmt=json";

    @Override
    public HashMap<String, Artist> getArtistList() {
        return null;
    }

    @Override
    public HashMap<String, Release> getReleaseList() {
        return null;
    }

    @Override
    public HashMap<String, Song> getSongList() {
        return null;
    }

    @Override
    public HashMap<String, Song> getSongList(String query) {
        Gson gson = new Gson();
        WebRecording webrecording;
        try {
            URL queryUrl = new URL(SEARCH_URL + query + JSON_FORMAT);

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

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Connection error");
        }

        return null;
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

}
