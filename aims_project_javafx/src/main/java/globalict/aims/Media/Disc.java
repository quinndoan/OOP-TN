package globalict.aims.Media;

public class Disc extends Media{
    private String director;
    private int length;

    public Disc(String title, String category, float cost){
        super(title, "Disc",cost);
        this.director = director;
        this.length = length;

    }
    

    public String getDirector(){
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }
    public void play() {
        // void
    }
}