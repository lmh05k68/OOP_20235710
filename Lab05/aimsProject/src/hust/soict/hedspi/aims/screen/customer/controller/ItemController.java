package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;
import hust.soict.hedspi.aims.cart.Cart;

public class ItemController {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (!cart.getItemsOrdered().contains(media)) {
            cart.addMedia(media);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Added to Cart");
            alert.setHeaderText(null);
            alert.setContentText("The item \"" + media.getTitle() + "\" was added to the cart.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Already in Cart");
            alert.setHeaderText(null);
            alert.setContentText("The item \"" + media.getTitle() + "\" is already in the cart.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Playing Media");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }
}