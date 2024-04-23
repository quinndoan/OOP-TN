package hust_soict_globalict_aims_media;


public class DigitalVideoDisc extends Disc{

    public DigitalVideoDisc(){
        super();
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length){
        super(id, title, category,cost);
        this.setDirector(director);
        this.setLength(length);
    }

public boolean isMatch(String title){
    return this.getTitle().equals(title);
}

public String toString() {
    return getTitle() + "-"+getCategory()+ "-"+ getDirector()+"-"+getLength() +"-"+getCost();
}

}