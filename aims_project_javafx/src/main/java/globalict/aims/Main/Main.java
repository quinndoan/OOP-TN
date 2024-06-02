package globalict.aims.Main;

import java.util.ArrayList;

import globalict.aims.Media.Book;
import globalict.aims.Media.CompactDisc;
import globalict.aims.Media.DigitalVideoDisc;
import globalict.aims.Media.Media;

public class Main {
    public static void main(String[] args){
        ArrayList<Media> mediaList = new ArrayList<>();
        CompactDisc cd = new CompactDisc("Album X", "Music", "Artist A",12.9f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("Movie Y", "Movie", 9.99f, "Director B",202);
        Book book = new Book("Book Z", "Book", 19.9f);

        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
