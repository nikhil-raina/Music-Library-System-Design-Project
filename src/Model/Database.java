package Model;

import ObjectModules.Artist;
import ObjectModules.Release;
import ObjectModules.Response;
import ObjectModules.Song;
import helpers.csvReader;

import java.util.HashMap;

public class Database {
    private HashMap<String, Artist> artistList;
    private HashMap<String, Release> releaseList;
    private HashMap<String, Song> songList;


    public Database() {
        csvReader csvReader = new csvReader();
        csvReader.populateDB();
        this.artistList = csvReader.getArtistList();
        this.releaseList = csvReader.getReleaseList();
        this.songList = csvReader.getSongList();
    }

    public HashMap<String, Artist> getArtistList() {
        return artistList;
    }

    public HashMap<String, Release> getReleaseList() {
        return releaseList;
    }

    public HashMap<String, Song> getSongList() {
        return songList;
    }
}
