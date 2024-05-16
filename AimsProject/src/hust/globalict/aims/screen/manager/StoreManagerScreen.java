package hust.globalict.aims.screen.manager; // must rename the package once
import hust.globalict.aims.Interface.Playable;
import hust.globalict.aims.Media.Book;
import hust.globalict.aims.Media.CompactDisc;
import hust.globalict.aims.Media.DigitalVideoDisc;
import hust.globalict.aims.Media.Media;
import hust.globalict.aims.store.Store;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StoreManagerScreen extends JFrame{
    private Store store;

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;

    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View store"));
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout((new BoxLayout(header,BoxLayout.X_AXIS)));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i=0; i<9;i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    public class MediaStore extends  JPanel{
        private Media media;
        public MediaStore (Media media){
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(),Font.PLAIN,15));
            title.setAlignmentX(CENTER_ALIGNMENT);

            JLabel cost = new JLabel (""+media.getCost()+" $");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout((new FlowLayout(FlowLayout.CENTER)));

            if (media instanceof Playable){
                JButton playButton = new JButton("Play");
                container.add(playButton);
            }
            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    public StoreManagerScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item to Store");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createFormPanel(), BorderLayout.CENTER);
        cp.add(createButtonPanel(), BorderLayout.SOUTH);

        setJMenuBar(createMenuBar());
    }

    public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        panel.add(new JLabel("Author:"));
        JTextField authorField = new JTextField();
        panel.add(authorField);

        return panel;
    }

    @Override
    void addItemToStore() {
        String title = titleField.getText();
        float cost = Float.parseFloat(costField.getText());
        String author = ((JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(5)).getText();
        store.addMedia(new Book(title, author, cost));
    }
}

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        panel.add(new JLabel("Artist:"));
        JTextField artistField = new JTextField();
        panel.add(artistField);

        return panel;
    }

    @Override
    void addItemToStore() {
        String title = titleField.getText();
        float cost = Float.parseFloat(costField.getText());
        String artist = ((JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(5)).getText();
        store.addMedia(new CompactDisc(title, artist, cost));
    }
}

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        panel.add(new JLabel("Director:"));
        JTextField directorField = new JTextField();
        panel.add(directorField);

        return panel;
    }

    @Override
    void addItemToStore() {
        String title = titleField.getText();
        float cost = Float.parseFloat(costField.getText());
        String director = ((JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(5)).getText();
        store.addMedia(new DigitalVideoDisc(title, director, cost));
    }
}




    public static void main(String[] args){
        Store store = new Store();

       DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd5);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc(6, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd6);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc(7, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd7);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc(8, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd8);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc(9, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd9);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc(10, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        store.addMedia(dvd10);
 
 
        new StoreManagerScreen(store);
    }

}
