package globalict.aims.Media;
import globalict.aims.Interface.Playable;
import globalict.aims.exception.PlayerException;
public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle(){
        return title;
    }
    public int getLength(){
        return length;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setLength(int length){
        this.length = length;
    }

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

    public void play() throws PlayerException {
    if (this.getLength() > 0) {
        System.out.println("Playing tracks: "+this.getTitle());
        System.out.println("Track Length: "+this.getLength());
    } else {
        throw new PlayerException("ERROR: DVD length is non-positive!");
    }
}

   
}
