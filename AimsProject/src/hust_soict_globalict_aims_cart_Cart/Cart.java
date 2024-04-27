package hust_soict_globalict_aims_cart_Cart;
import hust_soict_globalict_aims_media.DigitalVideoDisc;
import hust_soict_globalict_aims_media.Media;
import hust_soict_global_aims_store.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        itemsOrdered.add(media);
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }

    public void searchByID(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("The media is found with the id: " + id + " " + media.toString());
                return;
            }
        }
        System.out.println("The media with id " + id + " is not found");
    }

    public void searchByTitle(String title) {
        boolean foundItem = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("The media is found with the title: " + title + " " + media.toString());
                foundItem = true;
            }
        }
        if (!foundItem) {
            System.out.println("The media with title \"" + title + "\" is not found");
        }
    }

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
    System.out.print("Enter the title of the media: ");
    String title = scanner.nextLine();
    title = scanner.nextLine(); // Đọc tiêu đề

    Media media = store.searchMediaByTitle(title, store.getItemsInStore());

    if (media != null) {
        cart.addMedia(media);
        System.out.println("Media \"" + media.getTitle() + "\" added to cart.");
    } else {
        System.out.println("Media with title \"" + title + "\" not found in the store.");
    }
}


    public int countDVDsInCart() {
        int count = 0;
        for (Media media : itemsOrdered) {
            if (media instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }

    public void print() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty");
            return;
        }
        System.out.println("**********Cart**********");
        System.out.println("Ordered Items:");
        int index = 1;
        float totalPrice = 0;
        for (Media media : itemsOrdered) {
            System.out.println(index + ". " + media.toString());
            totalPrice += media.getCost();
            index++;
        }
        System.out.println("Total Cost: $" + totalPrice);
        System.out.println("************************");
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
}
