
package hust.globalict.aims.Media;
import java.util.ArrayList;
import java.util.List;


    public class Book extends Media{
        private String author;
        private List<String> authors = new ArrayList<>();
        public Book(String title, String category, float cost){
            super(title, "Book", cost);
            this.author = author;
        }
        public List<String> getAuthors(){
            return authors;
        }
        public void play(){
            // void since Book can not play
        }

        public boolean isMatch(String title){
            return this.getTitle().equals(title);
        }
        
        public String toString() {
            return getTitle() + "-"+getCategory()+ "-"+getCost();
        }


    public void addAuthor(String authorName){
        if (!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println("Add author sucessfully");
        }
        else {
            System.out.println("Author already exists");
        }
    }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println("Remove author sucessfully");
        }
        else {
            System.out.println("Author not exists");
        }
    }

}
