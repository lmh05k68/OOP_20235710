package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import javax.swing.JOptionPane;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
	private static final long serialVersionUID = 1L;
    public AddDVDToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void addItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        int id = 12;
        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost);

        store.addMedia(dvd);

        JOptionPane.showMessageDialog(this, "DVD added successfully!");
        this.dispose();
    }
}