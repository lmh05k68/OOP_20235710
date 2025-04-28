package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import javax.swing.JOptionPane;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void addItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        Book book = new Book(title, category, cost);
        store.addMedia(book);

        JOptionPane.showMessageDialog(this, "Book added successfully!");
        this.dispose();
    }
}