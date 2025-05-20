package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    private static final long serialVersionUID = 1L;
    protected JTextField titleField;
    protected JTextField categoryField;
    protected JTextField costField;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add Item to Store");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4, 2, 10, 10));

        cp.add(new JLabel("Title:"));
        titleField = new JTextField();
        cp.add(titleField);

        cp.add(new JLabel("Category:"));
        categoryField = new JTextField();
        cp.add(categoryField);

        cp.add(new JLabel("Cost:"));
        costField = new JTextField();
        cp.add(costField);

        JButton addButton = new JButton("Add");
        cp.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        setVisible(true);
    }

    protected abstract void addItem();
}