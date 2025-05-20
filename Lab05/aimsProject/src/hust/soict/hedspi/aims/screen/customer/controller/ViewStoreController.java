package hust.soict.hedspi.aims.screen.customer.controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.manager.MediaStore;

public class ViewStoreController {
    private Store store;
    private Cart cart;

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize() {
        displayMedia();
    }

    public void displayMedia() {
        if (store == null || cart == null) return;

        gridPane.getChildren().clear();
        int col = 0;
        int row = 0;

        for (Media media : store.getItemsInStore()) {
            MediaStore mediaNode = new MediaStore(media, cart);
            gridPane.add(mediaNode, col, row);

            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }
    }
    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
            CartController controller = new CartController(store, cart);
            loader.setController(controller);

            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
