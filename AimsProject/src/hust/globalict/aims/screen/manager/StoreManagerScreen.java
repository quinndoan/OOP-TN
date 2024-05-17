package hust.globalict.aims.screen.manager; // must rename the package once
import hust.globalict.aims.Interface.Playable;
import hust.globalict.aims.Media.Book;
import hust.globalict.aims.Media.CompactDisc;
import hust.globalict.aims.Media.DigitalVideoDisc;
import hust.globalict.aims.Media.Media;
import hust.globalict.aims.store.Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionListener;


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
    
        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        addBookMenuItem.addActionListener(e -> new AddBookToStoreScreen(store));
        smUpdateStore.add(addBookMenuItem);

    
        JMenuItem addCDMenuItem = new JMenuItem("Add CD");
        addCDMenuItem.addActionListener(e -> new AddCompactDiscToStoreScreen(store));
        smUpdateStore.add(addCDMenuItem);
    
        JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");
        addDVDMenuItem.addActionListener(e -> new AddDigitalDiscToStoreScreen(store));
        smUpdateStore.add(addDVDMenuItem);
    
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

           if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playMedia();
                }
            });
            container.add(playButton);
        }

            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        private void playMedia() {
            JDialog dialog = new JDialog();
            dialog.setTitle("Playing: " + media.getTitle());
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            dialog.add(new JScrollPane(textArea));
            dialog.setSize(400, 300);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
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


    public static void main(String[] args){
        Store store = new Store();

        store.addMedia(new Book("The Great Gatsby", "Classic", 10.99f));
        store.addMedia(new Book("1984", "Dystopian", 8.99f));
        store.addMedia(new CompactDisc("Thriller", "Pop","Michael Jackson",8.9f));
        store.addMedia(new CompactDisc("Back in Black", "Rock", "AC/DC",8.9f));
        store.addMedia(new DigitalVideoDisc("The Matrix", "Action", 19.99f, "Wachowski Brothers", 136));
        store.addMedia(new DigitalVideoDisc("The Godfather", "Crime", 15.99f, "Francis Ford Coppola", 175));
        store.addMedia(new Book("The Great Gatsby", "Classic", 10.99f));
        store.addMedia(new Book("1984", "Dystopian", 8.99f));
        store.addMedia(new CompactDisc("Thriller", "Pop","Michael Jackson",8.9f));
        store.addMedia(new CompactDisc("Back in Black", "Rock", "AC/DC",8.9f));
        store.addMedia(new DigitalVideoDisc("The Matrix", "Action", 19.99f, "Wachowski Brothers", 136));
        store.addMedia(new DigitalVideoDisc("The Godfather", "Crime", 15.99f, "Francis Ford Coppola", 175));

        new StoreManagerScreen(store);
    }

}