package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

import javax.swing.*;
import java.awt.*;
public class StoreManagerScreen extends JFrame {
    private Store store;
    private int nextId = 1; 
    private static final long serialVersionUID = 1L;
    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> addCD());

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> addDVD());

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> addBook());

        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        smUpdateStore.add(addBook);

        menu.add(smUpdateStore);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> viewStore());

        JMenuItem removeMedia = new JMenuItem("Remove Media");
        removeMedia.addActionListener(e -> removeMedia());

        menu.add(viewStore);
        menu.add(removeMedia);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        return center;
    }

    private void addCD() {
        try {
            String title = JOptionPane.showInputDialog(this, "Enter CD Title:");
            String category = JOptionPane.showInputDialog(this, "Enter CD Category:");
            String director = JOptionPane.showInputDialog(this, "Enter CD Director:");
            String artist = JOptionPane.showInputDialog(this, "Enter CD Artist:");
            int length = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter CD Length:"));
            float cost = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter CD Cost:"));

            CompactDisc cd = new CompactDisc(nextId++, title, category, director, artist, length, cost);
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    private void addDVD() {
        try {
            String title = JOptionPane.showInputDialog(this, "Enter DVD Title:");
            String category = JOptionPane.showInputDialog(this, "Enter DVD Category:");
            String director = JOptionPane.showInputDialog(this, "Enter DVD Director:");
            int length = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter DVD Length:"));
            float cost = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter DVD Cost:"));

            DigitalVideoDisc dvd = new DigitalVideoDisc(nextId++, title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    private void addBook() {
        try {
            String title = JOptionPane.showInputDialog(this, "Enter Book Title:");
            String category = JOptionPane.showInputDialog(this, "Enter Book Category:");
            float cost = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Book Cost:"));

            Book book = new Book(nextId++, title, category, cost);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    private void viewStore() {
        if (store.getItemsInStore().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Store is empty.");
        } else {
            StringBuilder content = new StringBuilder();
            for (Media m : store.getItemsInStore()) {
                content.append(m.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, content.toString(), "Store Items", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void removeMedia() {
        String title = JOptionPane.showInputDialog(this, "Enter Title to Remove:");
        Media toRemove = null;
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                toRemove = m;
                break;
            }
        }
        if (toRemove != null) {
            store.removeMedia(toRemove);
            JOptionPane.showMessageDialog(this, "Removed successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Media not found!");
        }
    }

    public static void main(String[] args) {
        Store store = new Store();
        new StoreManagerScreen(store);
    }
}