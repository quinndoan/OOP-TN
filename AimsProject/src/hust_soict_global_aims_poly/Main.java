package hust_soict_global_aims_poly;

import java.util.ArrayList;
import hust_soict_globalict_aims_media.*;
import hust_soict_globalict_aims_media.CompactDisc;
import hust_soict_globalict_aims_media.DigitalVideoDisc;

public class Main {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<>();
        CompactDisc cd = new CompactDisc(101, "Album X", "Music", 12.99f, "Artist A");
        DigitalVideoDisc dvd = new DigitalVideoDisc(201, "Movie Y", "Movie", 9.99f, "Director B",202);
        Book book = new Book(301, "Book Z", "Book", 19.9f);

        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);

        // Iterate through the list and print media information
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
