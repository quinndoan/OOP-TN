package hust.globalict.aims.screen.manager;

import javax.swing.*;

import hust.globalict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField titleField;
    protected JTextField costField;

    public AddItemToStoreScreen(Store store) {
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

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreManagerScreen(store);
                dispose();
            }
        });
        menu.add(viewStoreItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        return menuBar;
    }

    abstract JPanel createFormPanel();

    JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToStore();
                dispose();
            }
        });
        panel.add(addButton);
        return panel;
    }

    abstract void addItemToStore();
}
