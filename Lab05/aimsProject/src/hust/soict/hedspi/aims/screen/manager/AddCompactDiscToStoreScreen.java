package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;
import javax.swing.JOptionPane;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private static final long serialVersionUID = 1L;
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void addItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        int id = 11;
        CompactDisc cd = new CompactDisc(id, title, category, cost);

        store.addMedia(cd);

        JOptionPane.showMessageDialog(this, "CD added successfully!");
        this.dispose();
    }
}