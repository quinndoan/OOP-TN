package hust_soict_global_aims_store;
import java.util.ArrayList;
import java.util.Scanner;
import hust_soict_globalict_aims_media.*;

public class Store {
    private static int lastId = 0;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMediaToStore(Scanner scanner) {
        System.out.println("Adding a new media to the store...");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        title = scanner.nextLine(); // Read title
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = scanner.nextFloat();

        Media newMedia = new Media(++lastId, title, category, cost); 
        addMedia(newMedia);
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



    public static Media getSelectedMediaFromStore(Store store, Scanner scanner) {
        ArrayList<Media> itemsInStore = store.getItemsInStore();
        
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        title = scanner.nextLine(); // Read title
    
        Media selectedMedia = store.searchMediaByTitle(title, itemsInStore);
    
        if (selectedMedia == null) {
            System.out.println("Media with title \"" + title + "\" not found.");
        }
    
        return selectedMedia;
    }
    


    public static Media searchMediaByTitle(String title, ArrayList<Media> mediaList){
        for (Media media: mediaList){
            if (media.getTitle().equalsIgnoreCase(title)){
                return media;
            }
        }
        return null;
    }
    

      public static void seeMediaDetails(Store store, Scanner scanner) {
    System.out.println("Enter the title of the media: ");
    String title = scanner.nextLine(); 
    title = scanner.nextLine(); // Read title
    Media media = store.searchMediaByTitle(title, store.getItemsInStore());
    if (media != null) {
        System.out.println("Media Details:");
        System.out.println(media.toString());
    } else {
        System.out.println("Media with title \"" + title + "\" not found.");
    }
}

public static void play(Store store, Scanner scanner) {
    ArrayList<Media> itemsInStore = store.getItemsInStore();
    
    System.out.println("Enter the title of the media you want to play: ");
    String title = scanner.nextLine();
    title = scanner.nextLine(); // Read title

    Media selectedMedia = store.searchMediaByTitle(title, itemsInStore);

    if (selectedMedia != null) {
        System.out.println("Playing media: " + selectedMedia.getTitle());
    } else {
        System.out.println("Media with title \"" + title + "\" not found.");
    }
}

}
