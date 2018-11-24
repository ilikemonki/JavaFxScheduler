package javafxscheduler;
import java.sql.*;

public class DatabaseHandler {
    // Attribute
    public Connection conn = null; 
    public Statement stmt = null; 
    private String username = "root"; 
    private String pass = "12345678";

    /** Establish connection to JDBC */
    public void connect_JDBC() {
        try {
         // Setting for JDBC
            String url = "jdbc:mysql://localhost/?useSSL=false";
            
            // Register JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            conn = DriverManager.getConnection(url, username, pass);
        }
        catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
    
    /** Establish connection to database CALENDAR */
    public void connect_CALENDAR() {
        try {
         // Setting for JDBC
            String url = "jdbc:mysql://localhost/CALENDAR?useSSL=false";
            
            // Register JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            conn = DriverManager.getConnection(url, this.username, this.pass);
        }
        catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
    
    /** Close connection*/ 
    public void close_JDBC() {
        try {
            conn.close();
            System.out.println("Close JDBC");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    // Execute update statement  -- Might not need
    public void stmt_execute(String query) {
        try {
            this.stmt = conn.createStatement();
            stmt.execute(query); 
            System.out.println("Database executed successfully.");
        } 
        catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }
    } 
}
 
