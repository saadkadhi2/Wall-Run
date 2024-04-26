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

public class FAQController implements Initializable {
    Account currAccount = Account.getInstance();
    private Stage stage;
    private Scene scene;
    @FXML
    private Button backButton1;
    @FXML
    private Text faqText;
    @FXML
    private MenuBar myMenuBar;
    String s = "Q: Where will I be charged?\nA: Your order is directly tied to your MyASU and will be charged to your account.\nQ: What do we serve?\nA: We mainly server Pizzas!\n";

    public void initialize(URL url, ResourceBundle resourceBundle) {
        faqText.setText(s);
    }
    public void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(currAccount.getRecent()));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

    public void switchToFAQ(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FAQScene.fxml"));
        stage = (Stage)myMenuBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

    public void quitApplication(ActionEvent event) throws IOException {
        System.exit(0);
    }
    public void backToTitle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("titleScreen.fxml"));
        stage = (Stage)myMenuBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
}