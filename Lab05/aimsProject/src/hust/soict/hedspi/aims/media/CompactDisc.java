package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, String director, String artist, int length, float cost) {
        super(id, title, category, director, length, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + artist);

        for (Track track : tracks) {
            try {
                track.play(); 
            } catch (PlayerException e) {
                throw new PlayerException("ERROR playing track: " + track.getTitle() + " - " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + artist + " - " + getLength() + " : " + getCost() + "$";
    }
    @Override
    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

}