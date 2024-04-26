package sample.ordermenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewOrderController implements Initializable {
    private Stage stage;
    private Scene scene;
    Order order = Order.getInstance();
    Account currAccount = Account.getInstance();
    @FXML
    private Label inProgress;

    @FXML
    private Label completed;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        initWait();
    }
    public void switchtoLoggedIn(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("loggedInScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
    public void initWait(){
        int count = 0;
        int begin = 0, end = 1;

        for(int i= 0; i < order.getSize(); i++){
            begin = 0;
            end = 1;
            while(!order.getOrderItem(i).substring(begin, end).equals(".")){//findes account associated to order
                begin++;
                end++;
            }
            begin++;
            end++;

            //System.out.println(order.getOrderItem(i).substring(begin, end) + " = " + currAccount.getUserName());
            if(order.getOrderItem(i).substring(begin, order.getOrderItem(i).length()).equals(currAccount.getUserName())){
                inProgress.setText(inProgress.getText()+ "\n" + order.getOrderItem(i));
            }
        }

    }
}

