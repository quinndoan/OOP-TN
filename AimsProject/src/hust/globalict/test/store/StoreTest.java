package hust.globalict.test.store;
import hust.globalict.aims.Media.DigitalVideoDisc;
import hust.globalict.aims.Media.Media;
import hust.globalict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        store.addMedia(dvd1);
 
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd2);
 
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation",18.78f,"Jenifer Thomas",18);
        store.addMedia(dvd3);

        System.out.println("Test add DVD:");
        System.out.println("The list after added");
        for (Media media : store.getItemsInStore()) {
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc disc = (DigitalVideoDisc) media;
                System.out.println(disc.getTitle());
            }
        }

        System.out.println("Test remove DVD:");
        store.removeMedia(dvd1);
        System.out.println("The list after remove " + dvd1.getTitle());
        for (Media media : store.getItemsInStore()) {
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc disc = (DigitalVideoDisc) media;
                System.out.println(disc.getTitle());
            }
        }
    }
}
