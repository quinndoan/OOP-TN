package hust_soict_globalict_aims_cart_Cart;
import hust_soict_globalict_aims_media.DigitalVideoDisc;
import hust_soict_globalict_aims_media.Media;
import hust_soict_global_aims_store.*;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
        itemsOrdered.add(media);
    }
    
    public void removeMedia(Media media){
        itemsOrdered.remove(media);
    }
    public void searchByID(int id){
        for (Media media: itemsOrdered){
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc disc = (DigitalVideoDisc) media;
                if (disc.getId() == id){
                    System.out.println("The media is found with the id: " + id + " " + media.toString());
                    return;
                }
            }
        }
        System.out.println("The media with id " + id + " is not found");
    }
    

    public void searchByTitle(String title){
        boolean foundItem = false;
        for (Media media : itemsOrdered){
            DigitalVideoDisc disc =  (DigitalVideoDisc) media;
            if (disc.isMatch(title)){
                System.out.println("The DVD is found with title: "+title);
                foundItem = true;
            }
        }
        if (!foundItem){
            System.out.println("The DVD can not be found with title"+title);
        }
    }

    public void print(){
        if (itemsOrdered.isEmpty()){
            System.out.println("The cart is empty");
            return;
        }
        System.out.println("**********Cart**********");
        System.out.println("Ordered Items:");
        int index =1;
        float totalPrice =0;
        for (Media media: itemsOrdered){
            DigitalVideoDisc disc = (DigitalVideoDisc)media;
            System.out.println(index+ ".DVD-"+disc.toString());
            totalPrice += disc.getCost();
            index++;
        }
        System.out.println("TotalCost: "+totalPrice);
        System.out.println("************************");
    }

    public float totalCost(){
        float total =0;
        for (Media media: itemsOrdered){
            total += media.getCost();
        }
        return total;
    }

}