
package hust_soict_globalict_aims_media;
import java.util.ArrayList;
import java.lang.Object;
import java.util.List;

// public class Book {
//     private int id;
//     private String title;
//     private String category;
//     private float cost;
//     private List<String> authors = new ArrayList<String>();

//     public Book(int id, String title, String category, float cost){
//         this.id = id;
//         this.title = title;
//         this.category = category;
//         this.cost = cost;
//     }
//     public int getID(){
//         return id;
//     }

//     public void setID(){
//         this.id = id;
//     }

//     public String getTitle(){
//         return title;
//     }

//     public void setTitle(){
//         this.title = title;
//     }

//     public String getCategory(){
//         return category;
//     }

//     public void setCategory(){
//         this.category = category;
//     }

//     public float getCost(){
//         return cost;
//     }
//     public void setCost(float cost){
//         this.cost = cost;
//     }

//     public List<String> getAuthors(){
//         return authors;
//     }

    public class Book extends Media{
        private List<String> authors = new ArrayList<>();
        
        public Book(){
            super();
        }
        public Book(int id, String title, String category, float cost){
            super(id, title, category, cost);
        }
        public List<String> getAuthors(){
            return authors;
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
