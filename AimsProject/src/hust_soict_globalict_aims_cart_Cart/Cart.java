package hust_soict_globalict_aims_cart_Cart;
import hust_soict_globalict_aims_media.DigitalVideoDisc;

import java.util.ArrayList;

public class Cart {
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        itemsOrdered.add(disc);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        itemsOrdered.remove(disc);
    }

    public void searchByID(int id){
        for (DigitalVideoDisc disc: itemsOrdered){
            if (disc.getId()==id){
                System.out.println("The DVD is found with the id: "+id +" "+ disc.toString());
                return;
            }
        }
        System.out.println("The DVD is not found");
    }

    public void searchByTitle(String title){
        boolean foundItem = false;
        for (DigitalVideoDisc disc: itemsOrdered){
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
        for (DigitalVideoDisc disc: itemsOrdered){
            System.out.println(index+ ".DVD-"+disc.toString());
            totalPrice += disc.getCost();
            index++;
        }
        System.out.println("TotalCost: "+totalPrice);
        System.out.println("************************");
    }

}