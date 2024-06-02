package globalict.aims.Media;

public class DigitalVideoDisc extends Disc{
    private  String director;
    private int length;

    public DigitalVideoDisc(String title, String category, float cost, String author, int length){
        super(title, category,cost);
        this.setDirector(director);
        this.setLength(length);
    }
    public void setTitle(String title){
        super.setTitle(title);
    }

public boolean isMatch(String title){
    return this.getTitle().equals(title);
}

public String toString() {
    return getTitle() + "-"+getCategory()+ "-"+ getDirector()+"-"+getLength() +"-"+getCost();
}
public void play(){
    System.out.println("Play DVD: "+this.getTitle());
    System.out.println("DVD length: "+this.getLength());
}

}