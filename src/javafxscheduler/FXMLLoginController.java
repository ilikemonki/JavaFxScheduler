package javafxscheduler;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //This store a user attempting to log in. 
    //private User userAttempt; 
    
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
    public void loginButtonPushed (ActionEvent event) { 
        /*
        * Verify username and password  
        */
        String usernameAttempt = usernameTextField.getText();
        String passwordAttempt = passwordTextField.getText();
        DatabaseHandler userDB = new DatabaseHandler();
        boolean verified = false; 
        
        try {
            userDB.connect_CALENDAR();
            if (usernameAttempt != null && passwordAttempt != null) {
                String query = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD= ?";
                PreparedStatement pstmt;
                pstmt = userDB.conn.prepareStatement(query); 
                pstmt.setString(1, usernameAttempt);
                pstmt.setString(2, passwordAttempt);
                ResultSet rs = pstmt.executeQuery(); 
                if (rs.next()) {
                    verified = true; 
                }
            }
        } 
        catch (SQLException ex) {
            System.out.println("Verify account error: " + ex);
        }

        //If user is in the database
        if (verified == true) {
            try {
                /*
                * Switch to Main Calendar Scene
                */
                Parent mainCalendarParent = FXMLLoader.load(getClass().getResource("FXMLMainCalendar.fxml"));
                Scene mainCalendarScene = new Scene(mainCalendarParent);
                
                //This line gets stage informaion
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                
                window.setScene(mainCalendarScene);
                window.show();
            } catch (IOException ex) {
                System.out.println("Switching to Main Calendar Scene error: " + ex);
            }
        }
        
        //Else warning scene pops up
        else {
            try {
                Parent mainCalendarParent = FXMLLoader.load(getClass().getResource("FXMLPopUp.fxml"));
                Scene mainCalendarScene = new Scene(mainCalendarParent);
                
                //This line gets stage informaion
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                
                window.setScene(mainCalendarScene);
                window.show();
            } catch (IOException ex) {
                System.out.println("Switching to Pop Up Warning error: " + ex);
            }
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
