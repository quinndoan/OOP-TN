package hust.globalict.test.cart;

import hust.globalict.aims.Media.DigitalVideoDisc;
import hust.globalict.aims.Media.Media;
import hust.globalict.aims.cart.Cart;

import java.util.ArrayList;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        ArrayList<Media> storeItems = new ArrayList<>();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        storeItems.add(dvd1);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        storeItems.add(dvd2);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.78f, "Jenifer Thomas", 18);
        storeItems.add(dvd3);
        cart.addMedia(dvd3);

        cart.print();
        cart.searchByID(1);
        cart.searchByTitle("The Lion King");
    }
}
