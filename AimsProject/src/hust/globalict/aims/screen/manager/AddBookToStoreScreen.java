package hust.globalict.aims.screen.manager;

import hust.globalict.aims.Media.Book;
import hust.globalict.aims.Media.CompactDisc;
import hust.globalict.aims.Media.DigitalVideoDisc;
import hust.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

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

