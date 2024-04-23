package hust_soict_global_aims_store;

import hust_soict_globalict_aims_media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        store.addDigitalVideoDisc(dvd1);
 
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addDigitalVideoDisc(dvd2);
 
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation",18.78f,"Jenifer Thomas",18);
        store.addDigitalVideoDisc(dvd3);

        System.out.println("Test add DVD:");
        System.out.println("The list after added");
        for (DigitalVideoDisc disc: store.getItems()){
            System.out.println(disc.getTitle());
        }

        System.out.println("Test remove DVD:");
        store.removeDigitalVideoDisc(dvd1);
        System.out.println("The list after remove " + dvd1.getTitle());
        for (DigitalVideoDisc disc: store.getItems()){
            System.out.println(disc.getTitle());
        }
    }
}
