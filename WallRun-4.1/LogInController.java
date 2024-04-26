package sample.ordermenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.MenuBar;

public class LogInController implements Initializable {
    @FXML
    private Button secondaryButton;
    @FXML
    private Label nameOfUser;
    @FXML
    private Button mainButton;
    @FXML
    private Label logo;//if an employee, use this to change to WallRun Employee
    private Stage stage;
    private Scene scene;
    @FXML
    private MenuBar myMenuBar;

    Account currAccount = Account.getInstance();
    Order order = Order.getInstance();
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(currAccount.getPriv() == false){//is not a customer
            logo.setOpacity(1);
            mainButton.setText("Queue");
            secondaryButton.setVisible(false);
        }
        nameOfUser.setText(currAccount.getUserName());
    }
    public void switchViewOrder(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewOrderScreen.fxml"));
        stage = (Stage)myMenuBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();

    }
    public void switchToOrderMenu(ActionEvent event) throws IOException
    {
        if(currAccount.getPriv() == false) {//means isCust is false
            Parent root = FXMLLoader.load(getClass().getResource("orderQueue.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene((scene));
            stage.show();
        } else {//isCust is true, meaning they are a customerr
            Parent root = FXMLLoader.load(getClass().getResource("orderMenuScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene((scene));
            stage.show();
        }
    }

    public void backToTitle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("titleScreen.fxml"));
        stage = (Stage)myMenuBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
    public void switchToFAQ(ActionEvent event) throws IOException {
        currAccount.setRecent("loggedInScreen.fxml");
        Parent root = FXMLLoader.load(getClass().getResource("FAQScene.fxml"));
        stage = (Stage)myMenuBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
    public void quitApplication(ActionEvent event) throws IOException {
        System.exit(0);
    }


}
