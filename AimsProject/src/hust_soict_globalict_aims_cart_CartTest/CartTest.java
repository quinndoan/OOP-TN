package hust_soict_globalict_aims_cart_CartTest;

import hust_soict_globalict_aims_cart_Cart.Cart;
import hust_soict_globalict_aims_media.DigitalVideoDisc;
import hust_soict_globalict_aims_media.Media;

import java.util.ArrayList;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        ArrayList<Media> storeItems = new ArrayList<>();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        storeItems.add(dvd1);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        storeItems.add(dvd2);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.78f, "Jenifer Thomas", 18);
        storeItems.add(dvd3);
        cart.addMedia(dvd3);

        cart.print();
        cart.searchByID(1);
        cart.searchByTitle("The Lion King");
    }
}
