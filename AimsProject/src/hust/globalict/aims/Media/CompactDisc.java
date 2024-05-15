package hust.globalict.aims.Media;
import hust.globalict.aims.Interface.Playable.Playable;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track does not exist in the CD.");
        }
    }

    public int getTotalLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public boolean isMatch(String title){
        return this.getTitle().equals(title);
    }
    
    public String toString() {
        return getTitle() + "-"+getCategory()+ "-"+ getDirector()+"-"+getArtist() +"-"+getCost();
    }

    public void play(){
        System.out.println("Play CD: "+ getTitle());
        System.out.println("Total tracks: "+tracks.size());
        System.out.println("CD length: "+this.getTotalLength());

        for (Track track: tracks){
            track.play();
        }
    }
}