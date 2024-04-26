package sample.ordermenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomizeController {

    Order order = Order.getInstance();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button smallButton;

    @FXML
    Button mediumButton;

    @FXML
    Button largeButton;

    @FXML
    CheckBox Pepperoni;

    @FXML
    CheckBox Sausage;

    @FXML
    CheckBox Bacon;

    @FXML
    CheckBox Chicken;

    @FXML
    CheckBox Ham;

    @FXML
    CheckBox Spinach;

    @FXML
    CheckBox Olive;

    @FXML
    CheckBox Pepper;

    @FXML
    CheckBox Mushroom;

    @FXML
    CheckBox Cheese;

    @FXML
    CheckBox Onions;

    @FXML
    CheckBox Pineapple;

    String size = "Medium";


    public void setSmall(ActionEvent event) throws IOException
    {
        size = "Small";
        smallButton.setStyle("-fx-background-color: #5e1328;");
        mediumButton.setStyle("-fx-background-color: #8C1D40;");
        largeButton.setStyle("-fx-background-color: #8C1D40;");
    }

    public void setMedium(ActionEvent event) throws IOException
    {
        size = "Medium";
        smallButton.setStyle("-fx-background-color: #8C1D40;");
        mediumButton.setStyle("-fx-background-color: #5e1328;");
        largeButton.setStyle("-fx-background-color: #8C1D40;");
    }

    public void setLarge(ActionEvent event) throws IOException
    {
        size = "Large";
        smallButton.setStyle("-fx-background-color: #8C1D40;");
        mediumButton.setStyle("-fx-background-color: #8C1D40;");
        largeButton.setStyle("-fx-background-color: #5e1328;");
    }

    public void returnToMenu(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("orderMenuScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

    public void addToOrder(ActionEvent event) throws IOException
    {
        String orderText = "" + size + " Pizza";
        if (Pepperoni.isSelected())
        {
            orderText = "" + orderText + ", " + "Pepperoni";
        }
        if (Sausage.isSelected())
        {
            orderText = "" + orderText + ", " + "Sausage";
        }
        if (Bacon.isSelected())
        {
            orderText = "" + orderText + ", " + "Bacon";
        }
        if (Chicken.isSelected())
        {
            orderText = "" + orderText + ", " + "Chicken";
        }
        if (Ham.isSelected())
        {
            orderText = "" + orderText + ", " + "Ham";
        }
        if (Spinach.isSelected())
        {
            orderText = "" + orderText + ", " + "Spinach";
        }
        if (Olive.isSelected())
        {
            orderText = "" + orderText + ", " + "Olive";
        }
        if (Pepper.isSelected())
        {
            orderText = "" + orderText + ", " + "Pepper";
        }
        if (Mushroom.isSelected())
        {
            orderText = "" + orderText + ", " + "Mushroom";
        }
        if (Cheese.isSelected())
        {
            orderText = "" + orderText + ", " + "Cheese";
        }
        if (Onions.isSelected())
        {
            orderText = "" + orderText + ", " + "Onions";
        }
        if (Pineapple.isSelected())
        {
            orderText = "" + orderText + ", " + "Pineapple";
        }
        order.addToOrder(orderText);
        returnToMenu(event);
    }
}