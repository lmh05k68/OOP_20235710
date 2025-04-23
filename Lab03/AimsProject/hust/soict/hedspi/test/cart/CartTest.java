// package hust.soict.hedspi.test.cart; // Keep original package
package hust.soict.hedspi.test.cart; // Added for clarity

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media; // Import Media as well

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects using the media.DigitalVideoDisc constructors
        // IDs will be assigned automatically by the Media constructor
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        // dvd1.setId(1); // ID is now set automatically, remove manual setting

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.95f); // Corrected length for Star Wars IV
        // dvd2.setId(2); // Remove manual setting

        // Using the constructor without director/length (director/length will get defaults from Disc)
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f); // Corrected name typo
        // dvd3.setId(3); // Remove manual setting


        // Add them to the cart
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // Add a duplicate to test contains check
        System.out.println("\nAttempting to add duplicate DVD:");
        cart.addMedia(dvd1); // Should print that it's already in the cart

        // Display contents of the cart
        System.out.println("\n*********** Cart Contents ************");
        cart.displayCart();

        // --- Test Searching ---
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
         cart.searchByTitle(searchTitleNotFound); // Search method prints not found message


        // Search by ID using the Cart's method
        System.out.println("\n*********** Search by ID ************");

        // --- Test Removing ---
         System.out.println("\n*********** Removing Test ************");
         System.out.println("Removing '" + dvd2.getTitle() + "' (using object reference)");
         cart.removeMedia(dvd2);
         cart.displayCart();

         System.out.println("\nAttempting to remove media not in cart:");
         DigitalVideoDisc dvd4 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 15.99f);
         cart.removeMedia(dvd4);
         cart.displayCart(); // Should be unchanged

         // Test emptying the cart
         System.out.println("\n*********** Emptying Cart ************");
         cart.emptyCart();
         cart.displayCart();
    }
}