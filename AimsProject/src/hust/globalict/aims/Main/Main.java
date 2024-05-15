package hust.globalict.aims.Main;

import hust.globalict.aims.Media.Book;
import hust.globalict.aims.Media.CompactDisc;
import hust.globalict.aims.Media.DigitalVideoDisc;
import hust.globalict.aims.Media.Media;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Media> mediaList = new ArrayList<>();
        CompactDisc cd = new CompactDisc(101, "Album X", "Music", 12.99f, "Artist A");
        DigitalVideoDisc dvd = new DigitalVideoDisc(201, "Movie Y", "Movie", 9.99f, "Director B",202);
        Book book = new Book(301, "Book Z", "Book", 19.9f);

        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
