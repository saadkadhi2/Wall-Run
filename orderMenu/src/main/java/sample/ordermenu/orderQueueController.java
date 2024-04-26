package sample.ordermenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class orderQueueController implements Initializable {
    Order order = Order.getInstance();
    Account currAccount = Account.getInstance();
    String ordersToShow = "";
    private Stage stage;
    private Scene scene;
    @FXML
    private Text orderItemsText;
    @FXML
    private Button clear;
    @FXML
    private Button backToTitleButton;
    @FXML
    private Pane p;
    @FXML
    private ArrayList<CheckBox> cb = new ArrayList<>();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        initQueue();
    }
    public void initQueue(){
        if(p.getChildren().isEmpty() == false){
            p.getChildren().clear();
            cb.clear();
        }
        for(int i = 0; i < order.getSize(); i++) {
            cb.add(new CheckBox(order.getOrderItem(i)));
            p.getChildren().add(cb.get(i));
            if(i > 20 && i < 40){//essentially gets it to wrap around
                p.getChildren().get(i).setLayoutX(165);
                p.getChildren().get(i).setLayoutY(0 + ((i - 21) *20));
            }else if(i >= 40){
                p.getChildren().get(i).setLayoutX(330);
                p.getChildren().get(i).setLayoutY(0 + ((i - 40) *20));
            }else if(i <= 20){
                p.getChildren().get(i).setLayoutY(0 + (i*20));
            }
        }
    }

    public void clear(ActionEvent event)  throws IOException{
        //get rid of the order in queue.txt
        for(int i = 0; i < cb.size(); i++){
            if(cb.get(i).isSelected() == true){
                order.clear(order.getOrderItem(i));
            }
        }
        order.updateQueue_txt();
        initQueue();
        //send the notification of what done to that customer
    }
    public void backToTitle(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("titleScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
}
