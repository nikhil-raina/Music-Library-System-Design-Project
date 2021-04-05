package Model;

import ObjectModules.Artist;
import ObjectModules.Release;
import ObjectModules.Song;
import WebObjects.WebReleaseList;
import WebObjects.WebRecording;
import WebObjects.WebTrack;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
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
                    webrecording = gson.fromJson(line, WebObjects.WebRecording.class);
                    List<WebObjects.WebSong> recordings = webrecording.getrecordings();

                    for (int i = 0; i < recordings.size(); i++) {
                        System.out.print(i + 1 + ") " + recordings.get(i));
                        newsongList.put(recordings.get(i).getTitle(), recordings.get(i).toSong());
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
        WebObjects.WebReleaseList webReleaseList;
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
                    webReleaseList = gson.fromJson(line, WebObjects.WebReleaseList.class);
                    List<WebObjects.WebRelease> releases = webReleaseList.getRelease();
                    for (int i = 0; i < releases.size(); i++) {
                        System.out.print(i + 1 + ") " + releases.get(i));
                            newreleaseList.put(releases.get(i).getTitle(), releases.get(i).toRelease());
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
                    WebObjects.WebRelease release = gson.fromJson(line, WebObjects.WebRelease.class);
                    List<WebObjects.WebTrack> tracks = release.getMedia().get(0).getTracks();
                    for (int i = 0; i < tracks.size(); i++) {
                        System.out.print(i + 1 + ") " + tracks.get(i).getRecording().getTitle() + "\n");
                        newsongList.add(tracks.get(i).getRecording().toSong(ArtistGUID));

                    }
                }
            }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Connection error");
            }

            return newsongList;

    }


}
