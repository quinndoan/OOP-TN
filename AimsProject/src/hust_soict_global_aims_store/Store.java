package hust_soict_global_aims_store;
import java.util.ArrayList;
import java.util.Scanner;
import hust_soict_globalict_aims_media.*;

public class Store {
    private static int lastId = 0;
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
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
