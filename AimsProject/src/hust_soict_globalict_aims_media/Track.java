package hust_soict_globalict_aims_media;
import hust_soict_global_aims_Interface.*;
public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle(){
        return title;
    }
    public int getLength(){
        return length;
    }
    // public void setTitle(String title){
    //     this.title = title;
    // }
    // public void setLength(int length){
    //     this.length = length;
    // }

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if (obj ==null || getClass()!=obj.getClass()){
            return false;
        }
        Track other = (Track)obj;
        return title.equals(other.title) && length == other.length;
    }

    public void play(){
        System.out.println("Playing tracks: "+this.getTitle());
        System.out.println("Track Length: "+this.getLength());
    }
}
