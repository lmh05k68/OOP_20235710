package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.cart.Cart;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MediaStore extends VBox {
    public MediaStore(Media media, Cart cart) {
        // Title & Cost labels
        Label title = new Label(media.getTitle());
        title.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        Label cost = new Label(String.format("%.2f $", media.getCost()));

        // Button(s)
        Button addToCartButton = new Button("Add to cart");
        addToCartButton.setOnAction(e -> {
            try {
                cart.addMedia(media);
                System.out.println(media.getTitle() + " added to cart");
            } catch (Exception ex) {
                System.err.println("Cannot add to cart: " + ex.getMessage());
            }
        });

        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(title, cost);

        // If media is playable
        if (media instanceof Playable) {
            Button playButton = new Button("Play");
            playButton.setOnAction(e -> {
                try {
                    ((Playable) media).play();
                } catch (Exception ex) {
                    System.err.println("Error playing media: " + ex.getMessage());
                }
            });
            this.getChildren().add(playButton);
        }

        this.getChildren().add(addToCartButton);
        this.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-padding: 10;");
    }
}