package sample.ordermenu;
//AES related imports
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

//Javafx and io imports
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
import javafx.stage.Stage;
import static java.lang.System.exit;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    Account currAccount = Account.getInstance();
    @FXML
    private Button backToTitleButton;
    @FXML
    private Button backToTitleButton1;
    @FXML
    private Label welcomeText;
    @FXML
    private Label userExists;//used for when creating account and user already exists
    @FXML
    private CheckBox employeeCheck;
    private Stage stage;
    private Scene scene;
    private Parent root;
    //For logging in
    @FXML
    private Label incCred;
    @FXML
    private Label signedAs;
    @FXML
    private TextField userNameLogin;
    @FXML
    private TextField passwordLogin;
    @FXML
    private TextField userNameCreate;
    @FXML
    private TextField passwordCreate;
    @FXML
    private MenuBar myMenuBar;


    public void switchToLogin(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

    public void switchToLoggedIn(ActionEvent event) throws IOException//for logging in
    {
        boolean success = false;
        File file = new File("src/main/resources/sample/ordermenu/data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String userData;
        String u = userNameLogin.getText();
        String p = passwordLogin.getText();
        String fullLog =  u + "." + p;

        while ((userData = br.readLine()) != null){//reads data.txt file
            if(userData.equals( fullLog + ".0" )){//is a customer because 0 designates a customer, 1 designated admin
                success = true;
                currAccount.setUserName(u);
                currAccount.setPassword(p);
                currAccount.setPriv(true);
            }else if((userData).equals( fullLog + ".1")) {//this means they are registered as an admin/chef
                success = true;
                currAccount.setUserName(u);
                currAccount.setPassword(p);
                currAccount.setPriv(false);
            }
        }
        if(success == true){    //They Move on
            Parent root = FXMLLoader.load(getClass().getResource("loggedInScreen.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene((scene));
            stage.show();

        }else{                  //They must try again
            incCred.setOpacity(1.0);
        }
    }
    public void createAccount(ActionEvent event) throws IOException
    {
        boolean doesExist = false;
        File file = new File("src/main/resources/sample/ordermenu/data.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        File readFile = new File("src/main/resources/sample/ordermenu/data.txt");
        BufferedReader br = new BufferedReader(new FileReader(readFile));

        String userInfo = userNameCreate.getText() + "." + passwordCreate.getText(), userData;

        while ((userData = br.readLine()) != null) {//reads data.txt file
            if (userData.equals(userInfo + ".0") || userData.equals(userInfo + ".1")) {//checks if account username already exists
                userExists.setOpacity(1);
                doesExist = true;
            }
        }

        if(!doesExist){//can make account successfully
            System.out.println("inside if reached");
            if (employeeCheck.isSelected()) {//creating employee account
                userInfo = userInfo + ".1";
            } else {//creating customer account
                userInfo = userInfo + ".0";
            }
            bw.write(userInfo + "\n");
            bw.flush();
            Parent root = FXMLLoader.load(getClass().getResource("titleScreen.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene((scene));
            stage.show();
            bw.close();
            br.close();
        }

    }
    public void switchToCreateAccount(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("createAccountScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
    public void backToTitle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("titleScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

    public void switchToFAQ(ActionEvent event) throws IOException {
        currAccount.setRecent("titleScreen.fxml");
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