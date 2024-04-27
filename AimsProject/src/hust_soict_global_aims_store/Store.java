package hust_soict_global_aims_store;
import java.util.ArrayList;
import java.util.Scanner;
import hust_soict_globalict_aims_media.*;

public class Store {
    private static int lastId = 1;
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

        CompactDisc newCD = new CompactDisc(lastId++, title, category, cost, artist);
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

        DigitalVideoDisc newDVD = new DigitalVideoDisc(lastId++, title, category, cost, director, length);
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

        Book newBook = new Book(lastId++, title, category, cost);
        itemsInStore.add(newBook);
        System.out.println("Sách đã được thêm vào cửa hàng.");
    }

    public static void seeMediaDetail(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        title = scanner.nextLine();
    
        Media media = store.searchMediaByTitle(title, store.getItemsInStore());
    
        if (media != null) {
            System.out.println("Media Details:");
            System.out.println(media.toString());
        } else {
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

    // Tìm kiếm media theo tiêu đề
    public Media searchMediaByTitle(String title, ArrayList<Media> items) {
        for (Media media : items) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Lấy media được chọn từ cửa hàng
    public static Media getSelectedMediaFromStore(Store store, Scanner scanner) {
        ArrayList<Media> itemsInStore = store.getItemsInStore();

        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media selectedMedia = store.searchMediaByTitle(title, itemsInStore);

        if (selectedMedia != null) {
            System.out.println("Selected media: " + selectedMedia.toString());
        } else {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
        }
        return selectedMedia;
    }
}
