package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc{

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length){
        super(id, title, category,cost);
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