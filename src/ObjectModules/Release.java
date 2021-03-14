package ObjectModules;

import java.util.List;
import java.util.Objects;

public class Release extends Media {
    private final String GUID;
    private final String artistGUID;
    private final String releaseTitle;
    private final String issueDate;
    private final mediumType mediumType;
    private final List<Song> songList;

    public Release(String guid, String artistGUID, String releaseTitle, String mediumType, String issueDate, List<Song> songList) {
        this.GUID = guid;
        this.artistGUID = artistGUID;
        this.releaseTitle = releaseTitle;
        this.issueDate = issueDate;
        this.songList = songList;
        switch (mediumType) {
            case "Digital Media":
                this.mediumType = ObjectModules.mediumType.DIGITAL_MEDIA;
                break;
            case "CD":
                this.mediumType = ObjectModules.mediumType.CD;
                break;
            case "12\"\" Vinyl":
                this.mediumType = ObjectModules.mediumType.VINYL_12;
                break;
            case "7\"\" Vinyl":
                this.mediumType = ObjectModules.mediumType.VINYL_7;
                break;
            case "Vinyl":
                this.mediumType = ObjectModules.mediumType.VINYL;
                break;
            case "Cassette":
                this.mediumType = ObjectModules.mediumType.CASSETTE;
                break;
            default:
                this.mediumType = ObjectModules.mediumType.ENHANCED_CD;
                break;
        }
    }

    public List<Song> getSongList() {
        return songList;
    }

    public String getGUID() {
        return GUID;
    }

    public String getArtistGUID() {
        return artistGUID;
    }

    public String getReleaseTitle() {
        return releaseTitle;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public ObjectModules.mediumType getMediumType() {
        return mediumType;
    }

    @Override
    public String toString() {
        System.out.println("Release: " + getReleaseTitle() + ", songs:");
        int index = 1;
        for (Song song : getSongList()) {
            System.out.println(index + ". " + song.toString());
            index++;
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release = (Release) o;
        return getGUID().equals(release.getGUID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGUID());
    }
}
