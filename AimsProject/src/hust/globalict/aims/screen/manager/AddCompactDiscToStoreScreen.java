package hust.globalict.aims.screen.manager;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.globalict.aims.Media.CompactDisc;
import hust.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField categoryField;
    private JTextField artistField;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2)); // Thay đổi số lượng hàng thành 4
        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);

        panel.add(new JLabel("Artist:"));
        artistField = new JTextField();
        panel.add(artistField);

        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        return panel;
    }

    @Override
    void addItemToStore() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String artist = artistField.getText();
        float cost = Float.parseFloat(costField.getText());
        store.addMedia(new CompactDisc(title, category, artist,cost));
    }
}
