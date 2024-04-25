package hust_soict_global_aims;

import hust_soict_global_aims_store.*;
import hust_soict_globalict_aims_media.*;
import hust_soict_globalict_aims_cart_Cart.*;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    return;
                case 1:
                    viewStore(store, cart, scanner);
                    break;
                case 2:
                    updateStore(store, scanner);
                    break;
                case 3:
                    seeCurrentCart(cart, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore(Store store, Cart cart, Scanner scanner) {
        storeMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                System.out.println("Returning to main menu...");
                break;
            case 1:
                store.seeMediaDetails(store,scanner);
                break;
            case 2:
                Media selectedMedia = Store.getSelectedMediaFromStore(store, scanner);
                if (selectedMedia != null) {
                    cart.addMedia(selectedMedia);
                    System.out.println("Media \"" + selectedMedia.getTitle() + "\" added to cart.");
                }
                break;
            case 3:
                store.play(store, scanner);
                break;
            case 4:
                // seeCurrentCart(cart);
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                break;
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void updateStore(Store store, Scanner scanner) {
        System.out.println("Options:");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        System.out.print("Please choose an option: ");
    
        int choice = scanner.nextInt();
    
        switch (choice) {
            case 0:
                System.out.println("Returning to main menu...");
                break;
            case 1:
                store.addMediaToStore(store, scanner);
                break;
            case 2:
                removeMediaFromStore(store, scanner);
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                break;
        }
    }
    
    
    public static void removeMediaFromStore(Store store, Scanner scanner) {
        System.out.println("Removing a media from the store...");
        // Ask user for media title to remove
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        title = scanner.nextLine(); // Read title
    
        // Search for media in the store
        Media mediaToRemove = store.searchMediaByTitle(title, store.getItemsInStore());
        if (mediaToRemove != null) {
            // If found, remove it from the store
            store.removeMedia(mediaToRemove);
        } else {
            // If not found, display error message
            System.out.println("Media with title \"" + title + "\" not found in the store.");
        }
    }
    

    public static void seeCurrentCart(Cart cart, Scanner scanner) {
        cartMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            // Implement logic for seeing current cart
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}
