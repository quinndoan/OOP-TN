package hust.globalict.aims.screen.manager;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.globalict.aims.Media.DigitalVideoDisc;
import hust.globalict.aims.store.Store;

public class AddDigitalDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField categoryField;
    private JTextField directorField;
    private JTextField lengthField;

    public AddDigitalDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    @Override
    protected JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);

        panel.add(new JLabel("Director:"));
        directorField = new JTextField();
        panel.add(directorField);

        panel.add(new JLabel("Length:"));
        lengthField = new JTextField();
        panel.add(lengthField);

        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        return panel;
    }

    @Override
    protected void addItemToStore() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String director = directorField.getText();
        int length = Integer.parseInt(lengthField.getText());
        float cost = Float.parseFloat(costField.getText());
        store.addMedia(new DigitalVideoDisc(title, category, cost, director, length));
    }
}
