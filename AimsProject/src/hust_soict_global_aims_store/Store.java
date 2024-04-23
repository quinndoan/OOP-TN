package hust_soict_global_aims_store;
import java.util.ArrayList;
import hust_soict_globalict_aims_media.DigitalVideoDisc;

public class Store{
    public ArrayList<DigitalVideoDisc> getItems(){
        return itemsOrdered;
    }

private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        itemsOrdered.add(disc);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        itemsOrdered.remove(disc);
    }

   
    

    

}