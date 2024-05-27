package hust.globalict.aims.Media;

import java.util.Comparator;
import java.util.Scanner;

import hust.globalict.aims.cart.Cart;

public abstract class Media {
    private static int lastId =1;
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        this.id = generateUniqueId();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    private static synchronized int generateUniqueId() {
        return lastId++;
    }
    public abstract void play();

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media other = (Media) obj;
        return title.equals(other.getTitle());
    }

    public static class CompareByTitle implements Comparator<Media> {
        @Override
        public int compare(Media media1, Media media2) {
            return media1.getTitle().compareTo(media2.getTitle());
        }
    }

    public static class CompareByCost implements Comparator<Media> {
        @Override
        public int compare(Media media1, Media media2) {
            return Float.compare(media2.getCost(), media1.getCost());
        }
    }

    public static void filterCartByID(Cart cart, Scanner scanner) {
        System.out.println("Filter media in cart by ID:");
        System.out.print("Enter the ID to filter: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự new line
    
        Media media = cart.searchByID(id);
        if (media != null) {
            System.out.println("Found media with ID " + id + ": " + media.getTitle());
        } else {
            System.out.println("No media found with ID " + id);
        }
    }
    public static void filterCartByTitle(Cart cart, Scanner scanner) {
        System.out.println("Filter media in cart by Title:");
        System.out.print("Enter the Title to filter: ");
        String title = scanner.nextLine();
    
        Media media = cart.searchByTitle(title);
        if (media != null) {
            System.out.println("Found media with Title " + title + ": " + media.getTitle());
        } else {
            System.out.println("No media found with Title " + title);
        }
    }

    public static final Comparator<Media> COMPARE_BY_TITLE = new CompareByTitle();

    public static final Comparator<Media> COMPARE_BY_COST = new CompareByCost();



     public static void filterMediaInCart(Cart cart, Scanner scanner) {
        System.out.println("Filter media in cart:");
        System.out.println("1. By ID");
        System.out.println("2. By Title");
        System.out.print("Choose a filtering option (1-2): ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự new line

        switch (option) {
            case 1:
                filterCartByID(cart, scanner);
                break;
            case 2:
                filterCartByTitle(cart, scanner);
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
                break;
        }
    }
   
}
