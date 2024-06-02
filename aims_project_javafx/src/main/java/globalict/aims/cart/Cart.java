package globalict.aims.cart;
import java.util.Scanner;

import globalict.aims.Media.DigitalVideoDisc;
import globalict.aims.Media.Media;
import globalict.aims.store.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    
     private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
    public void addMedia(Media media) {
        itemsOrdered.add(media);
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }

    public Media searchByID(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("The media is found with the id: " + id + " " + media.toString());
                return media;
            }
        }
        System.out.println("The media with id " + id + " is not found");
        return null;
    }
    
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("The media is found with the title: " + title + " " + media.toString());
                return media;
            }
        }
        System.out.println("The media with title \"" + title + "\" is not found");
        return null;
    }

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {// case ask user
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

    public void sortMediaInCart(Scanner scanner) {
        System.out.println("Sort media in cart:");
        System.out.println("1. By Title");
        System.out.println("2. By Cost");
        System.out.print("Choose a sorting option (1-2): ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự new line
    
        switch (option) {
            case 1:
                itemsOrdered.sort(Media.COMPARE_BY_TITLE);
                break;
            case 2:
                itemsOrdered.sort(Media.COMPARE_BY_COST);
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
                return;
        }
    
        // Print the sorted items
        for (Media media : itemsOrdered) {
            System.out.println(media.getTitle() + " - " + media.getCost());
        }
    }
    
    public void placeOrder() {
        System.out.println("Order is created. Your cart is now empty.");
        itemsOrdered.clear();
    }
    
    public static void removeMediaFromCart(Cart cart, Scanner scanner) {
        System.out.println("Removing a media from the store...");
        // Ask user for media title to remove
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        title = scanner.nextLine(); // Read title
    
        // Search for media in the store
        Media mediaToRemove = cart.searchByTitle(title);
        if (mediaToRemove != null) {
            // If found, remove it from the store
            cart.removeMedia(mediaToRemove);
        } else {
            // If not found, display error message
            System.out.println("Media with title \"" + title + "\" not found in the cart.");
        }
    }
    public void playMedia(Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media you want to play: ");
        String title = scanner.nextLine();
        title = scanner.nextLine(); // Đọc tiêu đề
    
        // Tìm kiếm media trong store dựa trên tiêu đề
        Media media = cart.searchByTitle(title);
    
        if (media != null) {
            media.play();
        } else {
            System.out.println("Media with title \"" + title + "\" not found in the cart.");
        }
    }
    
    
    
}
