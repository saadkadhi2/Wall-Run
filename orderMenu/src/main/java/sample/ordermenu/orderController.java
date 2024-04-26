package sample.ordermenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class orderController implements Initializable {
    private Stage stage;
    private Scene scene;
    Order order = Order.getInstance();
    @FXML
    private Tab t1;
    @FXML
    private Tab t2;
    @FXML
    private Tab t3;
    @FXML
    private Label justAdded;    //displays what they just added to order
    //food buttons within ordering menu
    @FXML
    private Label justAdded1;
    @FXML
    private Label justAdded2;
    @FXML
    private Button pizzaB1;
    @FXML
    private Button pizzaB2;
    @FXML
    private Button pizzaB3;
    @FXML
    private Button pizzaB4;
    @FXML
    private Button pizzaB5;
    @FXML
    private Button pizzaB6;
    @FXML
    private Button sidesB1;
    @FXML
    private Button sidesB2;
    @FXML
    private Button sidesB3;
    @FXML
    private Button sidesB4;
    @FXML
    private Button sidesB5;
    @FXML
    private Button sidesB6;
    @FXML
    private Button drinksB1;
    @FXML
    private Button drinksB2;
    @FXML
    private Button drinksB3;
    @FXML
    private Button drinksB4;
    @FXML
    private Button drinksB5;
    @FXML
    private Button drinksB6;
    @FXML
    private Button orderCheckoutB1;
    @FXML
    private Button orderCheckoutB2;
    @FXML
    private Button orderCheckoutB3;
    @FXML
    private Button orderBackB1;
    @FXML
    private Button orderBackB2;
    @FXML
    private Button orderBackB3;


    @FXML
    private void handleMenuButton(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        if(sourceButton.equals(pizzaB1)) {
            try {
                switchToCustomPizza(event);
                justAdded.setText("Custom Pizza added to cart");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (sourceButton.equals(pizzaB2)){
            justAdded.setText("Cheese Pizza added to cart");
            order.addToOrder("Cheese Pizza");
        } else if (sourceButton.equals(pizzaB3)){
            justAdded.setText("Pepperoni Pizza added to cart");
            order.addToOrder("Pepperoni Pizza");
        } else if (sourceButton.equals(pizzaB4)){
            justAdded.setText("Sausage Pizza added to cart");
            order.addToOrder("Sausage Pizza");
        } else if (sourceButton.equals(pizzaB5)){
            justAdded.setText("Hawaiian Pizza added to cart");
            order.addToOrder("Hawaiian Pizza");
        } else if (sourceButton.equals(pizzaB6)){
            justAdded.setText(" Vegetable Pizza added to cart");
            order.addToOrder("Vegetable Pizza");
        } else if (sourceButton.equals(sidesB1)){
            justAdded1.setText("Breadsticks added to cart");
            order.addToOrder("Breadsticks");
        } else if (sourceButton.equals(sidesB2)){
            justAdded1.setText("Salad added to cart");
            order.addToOrder("Salad");
        } else if (sourceButton.equals(sidesB3)){
            justAdded1.setText("Mozzarella Sticks added to cart");
            order.addToOrder("Mozzarella Sticks");
        } else if (sourceButton.equals(sidesB4)){
            justAdded1.setText("Chicken Nuggets added to cart");
            order.addToOrder("Chicken Nuggets");
        } else if (sourceButton.equals(sidesB5)){
            justAdded1.setText("Ice cream added to cart");
            order.addToOrder("Ice cream");
        } else if (sourceButton.equals(sidesB6)){
            justAdded1.setText("Cookies added to cart");
            order.addToOrder("Cookies");
        } else if (sourceButton.equals(drinksB1)){
            justAdded2.setText("Water added to cart");
            order.addToOrder("Water");
        } else if (sourceButton.equals(drinksB2)){
            justAdded2.setText("Fountain Drink added to cart");
            order.addToOrder("Fountain Drink");
        } else if (sourceButton.equals(drinksB3)){
            justAdded2.setText("Lemonade added to cart");
            order.addToOrder("Lemonade");
        } else if (sourceButton.equals(drinksB4)){
            justAdded2.setText("Iced Tea added to cart");
            order.addToOrder("Iced Tea");
        } else if (sourceButton.equals(drinksB5)){
            justAdded2.setText("Slush added to cart");
            order.addToOrder("Slush");
        } else if (sourceButton.equals(drinksB6)){
            justAdded2.setText("Coffee added to cart");
            order.addToOrder("Coffee");
        }
    }

    public void handleCheckout(ActionEvent event) throws IOException {//switches to checkout screen
        Parent root = FXMLLoader.load(getClass().getResource("checkoutScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //repetitive code to change color of active tab.
        t1.setOnSelectionChanged(event -> {
            if(t1.isSelected()) {
                t1.setStyle("-fx-background-color: #850505;");
                t2.setStyle("-fx-background-color: #F3BD3F;");
                t3.setStyle("-fx-background-color: #F3BD3F;");
            } else if(t2.isSelected()) {
                t1.setStyle("-fx-background-color: #F3BD3F;");
                t2.setStyle("-fx-background-color: #850505;");
                t3.setStyle("-fx-background-color: #F3BD3F;");

            } else if(t3.isSelected()){
                t1.setStyle("-fx-background-color: #F3BD3F;");
                t2.setStyle("-fx-background-color: #F3BD3F;");
                t3.setStyle("-fx-background-color: #850505;");
            }
        });
        t2.setOnSelectionChanged(event -> {
            if(t1.isSelected()) {
                t1.setStyle("-fx-background-color: #850505;");
                t2.setStyle("-fx-background-color: #F3BD3F;");
                t3.setStyle("-fx-background-color: #F3BD3F;");
            } else if(t2.isSelected()) {
                t1.setStyle("-fx-background-color: #F3BD3F;");
                t2.setStyle("-fx-background-color: #850505;");
                t3.setStyle("-fx-background-color: #F3BD3F;");

            } else if(t3.isSelected()){
                t1.setStyle("-fx-background-color: #F3BD3F;");
                t2.setStyle("-fx-background-color: #F3BD3F;");
                t3.setStyle("-fx-background-color: #850505;");
            }
        });
        t3.setOnSelectionChanged(event -> {
            if(t1.isSelected()) {
                t1.setStyle("-fx-background-color: #850505;");
                t2.setStyle("-fx-background-color: #F3BD3F;");
                t3.setStyle("-fx-background-color: #F3BD3F;");
            } else if(t2.isSelected()) {
                t1.setStyle("-fx-background-color: #F3BD3F;");
                t2.setStyle("-fx-background-color: #850505;");
                t3.setStyle("-fx-background-color: #F3BD3F;");

            } else if(t3.isSelected()){
                t1.setStyle("-fx-background-color: #F3BD3F;");
                t2.setStyle("-fx-background-color: #F3BD3F;");
                t3.setStyle("-fx-background-color: #850505;");
            }
        });
        //end of active tab color switch
        //start of Menu buttons to add menu items to Order class
        pizzaB1.setOnAction(this::handleMenuButton);
        pizzaB2.setOnAction(this::handleMenuButton);
        pizzaB3.setOnAction(this::handleMenuButton);
        pizzaB4.setOnAction(this::handleMenuButton);
        pizzaB5.setOnAction(this::handleMenuButton);
        pizzaB6.setOnAction(this::handleMenuButton);
        sidesB1.setOnAction(this::handleMenuButton);
        sidesB2.setOnAction(this::handleMenuButton);
        sidesB3.setOnAction(this::handleMenuButton);
        sidesB4.setOnAction(this::handleMenuButton);
        sidesB5.setOnAction(this::handleMenuButton);
        sidesB6.setOnAction(this::handleMenuButton);
        drinksB1.setOnAction(this::handleMenuButton);
        drinksB2.setOnAction(this::handleMenuButton);
        drinksB3.setOnAction(this::handleMenuButton);
        drinksB4.setOnAction(this::handleMenuButton);
        drinksB5.setOnAction(this::handleMenuButton);
        drinksB6.setOnAction(this::handleMenuButton);
        //end of Menu buttons
    }
    public void switchToCheckout(ActionEvent event) throws IOException {

    }
    public void switchToTitle(ActionEvent event) throws IOException {//no longer switches to title, switches to login screen
        Parent root = FXMLLoader.load(getClass().getResource("loggedInScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

    public void switchToCustomPizza(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("customizePizza.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
}
