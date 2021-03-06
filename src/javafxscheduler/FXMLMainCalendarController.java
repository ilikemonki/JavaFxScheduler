package javafxscheduler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class FXMLMainCalendarController implements Initializable {

    //All items in Main Calendar Scene
    @FXML private MenuBar menuBar; 
    @FXML private Menu accountMenu; 
    @FXML private Menu appointmentMenu; 
    @FXML private Menu settingMenu; 
    @FXML private Menu helpMenu; 
    @FXML private MenuItem changeUsernameMenuItem; 
    @FXML private MenuItem changePasswordMenuItem; 
    @FXML private MenuItem accountDetailMenuItem; 
    @FXML private MenuItem logoutMenuItem;
    @FXML private MenuItem makeAppointmentMenuItem;
    @FXML private MenuItem cancelAppointmentMenuItem;
    @FXML private MenuItem changeAppointmentMenuItem;
    @FXML private MenuItem setCalenarRangeMenuItem;
    @FXML private MenuItem setCalendarColorMenuItem;
    
    //Store current user data. 
    private User currentUser;
    
    /**
     * When this method is called, currentUser's fields are initialized. 
     */
    public void initCurrentUser (User passUser) 
    {
        currentUser = passUser;
        System.out.println(currentUser.getUsername() + " -- " + currentUser.getPassword());
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
