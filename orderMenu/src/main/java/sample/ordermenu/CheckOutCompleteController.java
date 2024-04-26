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
public class CheckOutCompleteController implements Initializable{
    Order order = Order.getInstance();
    String ordersToShow = "";
    private Stage stage;
    private Scene scene;
    @FXML
    private Text orderItemsText;
    @FXML
    private Label readyIn;
    @FXML
    private Button backToTitleButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 0; i < order.getSize(); i++) {
            ordersToShow = ordersToShow + order.getOrderItem(i) + "\n";
        }
        orderItemsText.setText(ordersToShow);
        readyIn.setText("Your order will be ready in about " + order.getSize()*5 + " minutes!");
    }
    public void backToTitle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("titleScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

}
