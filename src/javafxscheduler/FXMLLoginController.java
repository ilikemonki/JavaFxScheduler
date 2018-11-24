package javafxscheduler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author chinhnguyen
 */
public class FXMLLoginController implements Initializable {
    
    //These items are for Log In Scene
    @FXML private Label signInLabel;
    @FXML private TextField usernameTextField; 
    @FXML private TextField passwordTextField;
    @FXML private Button loginButton; 
    
    /**
     * When this method is called, username and password are verified
     * If successful, Main Calendar Scene appears
     * If failed, warning scene appears.
     */
    public void loginButtonPushed (ActionEvent event) throws IOException { 
        Parent mainCalendarParent = FXMLLoader.load(getClass().getResource("FXMLMainCalendar.fxml"));
        Scene mainCalendarScene = new Scene(mainCalendarParent); 
        
        //This line gets stage informaion 
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        window.setScene(mainCalendarScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
