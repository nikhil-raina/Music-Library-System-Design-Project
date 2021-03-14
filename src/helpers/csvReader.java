package helpers;

import ObjectModules.Artist;
import ObjectModules.Release;
import ObjectModules.Song;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class csvReader {
    static HashMap<String, Artist> artistList = new HashMap<>();
    static HashMap<String, Release> releaseList = new HashMap<>();
    static HashMap<String, Song> songList = new HashMap<>();
    static String[] checkTypeList = {"Digital Media", "CD", "12\"\" Vinyl", "Vinyl", "7\"\" Vinyl", "Cassette", "Enhanced CD"};
    static String COMMA_DELIMITER = ",";

    public void populateDB() {
        try {
            File artistData = new File("src/data_set/artists.csv");
            File releaseData = new File("src/data_set/releases.csv");
            File songData = new File("src/data_set/songs.csv");

            this.readArtistFile(artistData);
            this.readSongFile(songData);
            this.readReleaseFile(releaseData);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readArtistFile (File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(COMMA_DELIMITER);
                if(data.length == 2)
                    artistList.put(data[0], new Artist(data[0], data[1].replace("\t",""), ""));
                else
                    artistList.put(data[0], new Artist(data[0], data[1].replace("\t",""), data[2]));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Artist --- Error while reading data from the File ---");
            System.out.println(e);
        }
    }

    public void readReleaseFile (File file) {
        List<String> list = Arrays.asList(checkTypeList);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(COMMA_DELIMITER);
                ArrayList<Song> songs = new ArrayList<>();
                for (int idx = 5; data.length > idx; idx++) {
                    if(!list.contains(data[3])){
                        data[2] = data[2] + "," + data[3];
                        LinkedList<String> s = new LinkedList<String>(Arrays.asList(data));
                        String remove = s.remove(3);
                        data = (String[]) s.toArray(new String[data.length]);
                    }
                    Song song = songList.get(data[idx]);
                    songs.add(song);
                }
                releaseList.put(data[0], new Release(data[0], data[1], data[2], data[3], data[4], songs));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Release --- Error while reading data from the File ---");
            System.out.println(e);
        }
    }

    public void readSongFile (File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(COMMA_DELIMITER);
                songList.put(data[0], new Song(data[0], data[1], Integer.parseInt(data[2]), data[3]));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Song --- Error while reading data from the File ---");
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        csvReader reader = new csvReader();
        reader.populateDB();
        System.out.println("Data Read");
    }
}
