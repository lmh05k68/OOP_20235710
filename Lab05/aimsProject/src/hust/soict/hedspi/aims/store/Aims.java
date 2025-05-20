package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.cart.Cart;

import java.util.Scanner;

public class Aims {

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View cart");
        System.out.println("2. Add media to cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            showMenu();
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    System.out.println("***** CART *****");
                    cart.displayCart();
                    break;

                case 2:
                    System.out.println("Choose type of media: 1. Book  2. DVD  3. CD");
                    int mediaType = Integer.parseInt(sc.nextLine());
                    Media media = null;

                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Cost: ");
                    float cost = Float.parseFloat(sc.nextLine());

                    switch (mediaType) {
                    case 1:
                        int id = 14; 
                        media = new Book(id, title, category, cost);
                        break;
                    case 2:
                        System.out.print("Director: ");
                        String directorDVD = sc.nextLine();
                        System.out.print("Length: ");
                        int lengthDVD = Integer.parseInt(sc.nextLine());
                        int id_ = 15; 
                        media = new DigitalVideoDisc(id_, title, category, directorDVD, lengthDVD, cost); // ✅ gán vào media
                        break;
                    case 3:
                        System.out.print("Director: ");
                        String directorCD = sc.nextLine();
                        System.out.print("Artist: ");
                        String artist = sc.nextLine();
                        int _id = 16;
                        media = new CompactDisc(_id, title, category, directorCD, artist, 0, cost); // ✅ gán vào media
                        break;
                    default:
                        System.out.println("Invalid media type.");
                }

                if (media != null) {
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                }
                break;

                case 3:
                    System.out.print("Enter the title of media to remove: ");
                    String removeTitle = sc.nextLine();
                    Media toRemove = cart.searchByTitle(removeTitle);
                    if (toRemove != null) {
                        cart.removeMedia(toRemove);
                        System.out.println("Removed from cart.");
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;

                case 4:
                    System.out.print("Enter title of media to play: ");
                    String playTitle = sc.nextLine();
                    Media mediaToPlay = cart.searchByTitle(playTitle);
                    if (mediaToPlay instanceof Playable) {
                        try {
                            ((Playable) mediaToPlay).play();
                        } catch (PlayerException e) {
                            System.err.println("Error playing media: " + e.getMessage());
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;

                case 5:
                    System.out.println("Order placed.");
                    cart.emptyCart();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}