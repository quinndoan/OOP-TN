package globalict.aims.store;
import java.util.ArrayList;
import java.util.Scanner;

import globalict.aims.Media.Book;
import globalict.aims.Media.CompactDisc;
import globalict.aims.Media.DigitalVideoDisc;
import globalict.aims.Media.Media;
import globalict.aims.cart.Cart;
public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    
    public void addMediaToStore(Scanner scanner) {
        System.out.println("Add media to store:");
        System.out.println("1. CD");
        System.out.println("2. DVD");
        System.out.println("3. Book");
        System.out.print("Pick the media type (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addCD(scanner);
                break;
            case 2:
                addDVD(scanner);
                break;
            case 3:
                addBook(scanner);
                break;
            default:
                System.out.println("Invalid type choice");
        }
    }

    private void addCD(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter director: ");
        String director = scanner.nextLine();
        System.out.print("Enter artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = scanner.nextFloat();

        CompactDisc newCD = new CompactDisc(title, category,artist,cost);
        itemsInStore.add(newCD);
        System.out.println("CD added.");
    }

    private void addDVD(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter director: ");
        String director = scanner.nextLine();
        System.out.print("Enter length: ");
        int length = scanner.nextInt();
        System.out.print("Enter cost: ");
        float cost = scanner.nextFloat();

        DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, cost, director, length);
        itemsInStore.add(newDVD);
        System.out.println("DVD added.");
    }

    private void addBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = scanner.nextFloat();

        Book newBook = new Book(title, category, cost);
        itemsInStore.add(newBook);
        System.out.println("Book added.");
    }

    public static Media seeMediaDetail(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        title = scanner.nextLine(); // Đọc tiêu đề
    
        Media media = store.searchMediaByTitle(title, store.getItemsInStore());
    
        if (media != null) {
            System.out.println("Media Details:");
            System.out.println(media.toString());
        } else {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
        }
    
        return media;
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
    
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Media \"" + media.getTitle() + "\" added to the store with ID: " + media.getId());
    }

    // Xóa một media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media \"" + media.getTitle() + "\" removed from the store.");
        } else {
            System.out.println("Media \"" + media.getTitle() + "\" not found in the store.");
        }
    }

    public void displayItemInStore() {
        for (Media media : itemsInStore) {
            System.out.println("ID: " + media.getId());
            System.out.println("Title: " + media.getTitle());
            System.out.println("------------------------");
        }
    }
    

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        System.out.println("List of media in the store:");
        store.displayItemInStore(); 
        System.out.print("Enter the title of the media you want to add to cart: ");
        String title = scanner.nextLine();
        title = scanner.nextLine(); 
    
        Media media = store.searchMediaByTitle(title, store.getItemsInStore());
    
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media \"" + title + "\" added to cart.");
            if (media instanceof DigitalVideoDisc) {
                int numberOfDVDsInCart = cart.countDVDsInCart();
                System.out.println("Number of DVDs in the cart: " + numberOfDVDsInCart);
            }
        } else {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
        }
    }
    

    public Media searchMediaByTitle(String title, ArrayList<Media> items) {
        for (Media media : items) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void playMedia(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media you want to play: ");
        String title = scanner.nextLine();
        title = scanner.nextLine(); // Đọc tiêu đề
    
        // Tìm kiếm media trong store dựa trên tiêu đề
        Media media = store.searchMediaByTitle(title, store.getItemsInStore());
    
        if (media != null) {
            media.play();
        } else {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
        }
    }
    

    public static void play(Store store, Scanner scanner) {   // only CD and DVD are allowed to play
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        title = scanner.nextLine(); // Đọc tiêu đề
    
        Media media = store.searchMediaByTitle(title, store.getItemsInStore());
    
        if (media != null) {
            System.out.println("Media Details:");
            System.out.println(media.toString());
    
            if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            } else if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            } else {
                System.out.println("Cannot play media. Media type not supported.");
            }
        } else {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
        }
    }
    
}
