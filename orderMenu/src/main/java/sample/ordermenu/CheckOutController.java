package sample.ordermenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckOutController implements Initializable{
    private Stage stage;
    private Scene scene;
    String ordersToShow = "";
    @FXML
    private Button clearButton;
    @FXML
    private Button backButton;
    @FXML
    private Button checkoutButton;
    @FXML
    private Text orderItemsText;
    Order order = Order.getInstance();
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 0; i < order.getSize(); i++) {
            ordersToShow = ordersToShow + order.getOrderItem(i) + "\n";
        }
        orderItemsText.setText(ordersToShow);
    }
    public void clear(ActionEvent event) throws IOException {
        order.clearAll();
        Parent root = FXMLLoader.load(getClass().getResource("checkoutScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("orderMenuScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
    public void checkOut(ActionEvent event) throws IOException {
        order.updateQueue_txt();

        Parent root = FXMLLoader.load(getClass().getResource("checkoutComplete.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
}
