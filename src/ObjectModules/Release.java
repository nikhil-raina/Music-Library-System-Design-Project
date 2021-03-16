package ObjectModules;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Release implements LibraryElement {
    private final String GUID;
    private final String artistGUID;
    private final String releaseTitle;
    private final Date issueDate;
    private final MediumType mediumType;
    private final List<Song> songList;

    public Release(String guid, String artistGUID, String releaseTitle, String mediumType, Date issueDate, List<Song> songList) throws ParseException {
        this.GUID = guid;
        this.artistGUID = artistGUID;
        this.releaseTitle = releaseTitle;

//        if (issueDate.length() == 4) {
//            issueDate1 = new SimpleDateFormat("yyyy").parse(issueDate);
//        } else if (issueDate.length() == 7) {
//            issueDate1 = new SimpleDateFormat("yyyy-mm").parse(issueDate);
//        } else {
//            issueDate1 = new SimpleDateFormat("yyyy-mm-dd").parse(issueDate);
//        }

        this.issueDate = issueDate;
        this.songList = songList;
        switch (mediumType) {
            case "Digital Media":
                this.mediumType = MediumType.DIGITAL_MEDIA;
                break;
            case "CD":
                this.mediumType = MediumType.CD;
                break;
            case "12\"\" Vinyl":
                this.mediumType = MediumType.VINYL_12;
                break;
            case "7\"\" Vinyl":
                this.mediumType = MediumType.VINYL_7;
                break;
            case "Vinyl":
                this.mediumType = MediumType.VINYL;
                break;
            case "Cassette":
                this.mediumType = MediumType.CASSETTE;
                break;
            case "Enhanced CD":
                this.mediumType = MediumType.ENHANCED_CD;
                break;
            default:
                this.mediumType = MediumType.NO_TYPE;
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

    public String getTitle() {
        return releaseTitle;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public MediumType getMedia() {
        return mediumType;
    }

    @Override
    public void setRating(float rating) { }

    public int getDuration() {
        int total = 0;
        for (int i = 0; i < songList.size(); i++) {
            total += songList.get(i).getDuration();
        }
        return total;
    }

    public float getRating() {
        return 0;
    }

    @Override
    public String toString() {
        System.out.println("Release: " + getTitle() + ", songs:");
        int index = 1;
        for (Song song : getSongList()) {
            if(song == null){
                break;
            }
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
