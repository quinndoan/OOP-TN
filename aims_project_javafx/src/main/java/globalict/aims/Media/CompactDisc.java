package globalict.aims.Media;
import java.util.ArrayList;

import globalict.aims.Interface.Playable;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist,float cost) {
        super(title, category, cost);
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
