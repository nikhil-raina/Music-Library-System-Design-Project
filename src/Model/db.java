package Model;

import ObjectModules.Artist;
import ObjectModules.Release;
import ObjectModules.Song;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

public interface db {
     HashMap<String, Artist> getArtistList();

     HashMap<String, Release> getReleaseList();

     HashMap<String, Song> getSongList();
     HashMap<String, Song> getSongList(String query) throws IOException;

}
