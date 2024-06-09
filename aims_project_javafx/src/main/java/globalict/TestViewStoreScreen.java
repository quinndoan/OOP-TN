package globalict;

import globalict.aims.Media.Book;
import globalict.aims.Media.CompactDisc;
import globalict.aims.Media.DigitalVideoDisc;
import globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
    private static Store store;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Store.fxml"));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String[] args) {
        store = new Store();
        
         Book book1 = new Book("Book Title 1", "Book Category 1", 10.99f);
    store.addMedia(book1);

    CompactDisc cd1 = new CompactDisc("CD Title 1", "CD Category 1", "CD Artist 1", 15.99f);
    store.addMedia(cd1);

    DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD Title 1", "DVD Category 1", 20.99f, "DVD Director 1", 120);
    store.addMedia(dvd1);

    for (int i = 2; i <= 4; i++) {
        Book book = new Book("Book Title " + i, "Book Category " + i, 10.99f * i);
        store.addMedia(book);

        CompactDisc cd = new CompactDisc("CD Title " + i, "CD Category " + i, "CD Artist " + i, 15.99f * i);
        store.addMedia(cd);

        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD Title " + i, "DVD Category " + i, 20.99f * i, "DVD Director " + i, 120 * i);
        store.addMedia(dvd);
    }
        launch(args);
    }

}
