package globalict;

import globalict.aims.cart.Cart;
import globalict.aims.Media.Media;
import globalict.aims.Interface.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {

    private Cart cart;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label costLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private Button placeOrder;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
     //   costLabel.setText(cart.totalCost() + " $");
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        tblMedia.setItems(this.cart.getItemsOrdered());

        costLabel.setText(cart.totalCost() + "$");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {

                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    updateButtonBar(newValue);
                }
            }
        );

        tfFilter.textProperty().addListener(
            new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }

            private void showFilteredMedia(String keyword) {
                FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());

                if (!keyword.isEmpty() && radioBtnFilterId.isSelected()) {
                    filteredList.setPredicate(media -> {
                        String idString = String.valueOf(media.getId());
                        return idString.equals(keyword);
                    });
                } else if (!keyword.isEmpty() &&  radioBtnFilterTitle.isSelected()) {
                    filteredList.setPredicate(media -> {
                        String title = media.getTitle().toLowerCase();
                        return title.contains(keyword.toLowerCase());
                    });
                } else {
                    filteredList.setPredicate(null);
                }
                tblMedia.setItems(filteredList);
            }
        });

    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }
}
