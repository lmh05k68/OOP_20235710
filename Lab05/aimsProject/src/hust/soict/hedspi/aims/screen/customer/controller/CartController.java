package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.exception.PlayerException;
import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store; 
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Store store; 
	private Cart cart;
	private FilteredList<Media> filteredList;
	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, Integer> colMediaId;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private TextField tfFilter;

	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private RadioButton radioBtnFilterTitle;

	@FXML
	private ToggleGroup filterGroup;
	
	@FXML
	private Label costLabel;

	@FXML
	public void initialize() {
	    colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
	    colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
	    colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
	    colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

	    filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
	    tblMedia.setItems(filteredList);

	    btnPlay.setVisible(false);
	    btnRemove.setVisible(false);

	    tblMedia.getSelectionModel().selectedItemProperty().addListener(
	        (observable, oldValue, newValue) -> updateButtonBar(newValue)
	    );

	    tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
	        showFilteredMedia(newValue);
	    });

	    updateTotalCost(); 
	}

	private void updateButtonBar(Media media) {
		if (media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		} else {
			btnRemove.setVisible(true);
			btnPlay.setVisible(media instanceof Playable);
		}
	}

	private void showFilteredMedia(String filterText) {
		if (filterText == null) filterText = "";

		final String lowerCaseFilter = filterText.toLowerCase();

		filteredList.setPredicate(media -> {
			if (lowerCaseFilter.isEmpty()) {
				return true;
			}
			if (radioBtnFilterId.isSelected()) {
				return Integer.toString(media.getId()).contains(lowerCaseFilter);
			} else {
				return media.getTitle().toLowerCase().contains(lowerCaseFilter);
			}
		});
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
	    Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
	    if (selectedMedia != null) {
	        cart.removeMedia(selectedMedia);
	        updateTotalCost();
	    }
	}
	@FXML
	void btnViewStorePressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));
			ViewStoreController controller = new ViewStoreController();
			controller.setStore(store);
			controller.setCart(cart);
			loader.setController(controller);

			Parent root = loader.load();
			controller.displayMedia();

			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	void btnPlayPressed(ActionEvent event) {
	    Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
	    if (selectedMedia instanceof Playable) {
	        try {
	            ((Playable) selectedMedia).play();
	        } catch (PlayerException e) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Playback Error");
	            alert.setHeaderText(null);
	            alert.setContentText("Cannot play media: " + e.getMessage());
	            alert.showAndWait();
	        }
	    }
	}
	private void updateTotalCost() {
	    costLabel.setText(String.format("%.2f $", cart.totalCost()));
	}
}