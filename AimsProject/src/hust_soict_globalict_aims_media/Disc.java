package hust_soict_globalict_aims_media;

public class Disc extends Media{
    private String director;
    private int length;

    public Disc(){
        super();
    }

    public Disc(int id, String title, String category, float cost){
        super(id, title, category,cost);
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
}