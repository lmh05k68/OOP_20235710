package hust.soict.hedspi.aims.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 121, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", "John Musker", 90, 18.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        System.out.println("\nAttempting to add duplicate DVD:");
        cart.addMedia(dvd1);

        System.out.println("\n*********** Cart Contents ************");
        cart.displayCart();

        System.out.println("\n*********** Search by Title ************");
        String searchTitleExact = "Star Wars";
        String searchTitlePartial = "king";
        String searchTitleNotFound = "Casablanca";

        System.out.println("Searching for exact title: '" + searchTitleExact + "'");
        Media resultExact = cart.searchByTitle(searchTitleExact);
        if (resultExact != null) {
            System.out.println("Found match: " + resultExact.toString());
        }

        System.out.println("\nSearching for partial title: '" + searchTitlePartial + "'");
        Media resultPartial = cart.searchByTitle(searchTitlePartial);
        if (resultPartial != null) {
            System.out.println("Found match: " + resultPartial.toString());
        }

        System.out.println("\nSearching for title not present: '" + searchTitleNotFound + "'");
        cart.searchByTitle(searchTitleNotFound);

        System.out.println("\n*********** Removing Test ************");
        System.out.println("Removing '" + dvd2.getTitle() + "' (using object reference)");
        cart.removeMedia(dvd2);
        cart.displayCart();

        System.out.println("\nAttempting to remove media not in cart:");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.removeMedia(dvd4);
        cart.displayCart();

        System.out.println("\n*********** Emptying Cart ************");
        cart.emptyCart();
        cart.displayCart();
    }
}