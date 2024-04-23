package hust_soict_globalict_aims_cart_CartTest;
import hust_soict_globalict_aims_cart_Cart.*;
import hust_soict_globalict_aims_media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args){
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        cart.addDigitalVideoDisc(dvd1);
 
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        cart.addDigitalVideoDisc(dvd2);
 
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation",18.78f,"Jenifer Thomas",18);
        cart.addDigitalVideoDisc(dvd3);


        cart.print();
        cart.searchByID(1);
        cart.searchByTitle("The Lion King");

    

    }
}
