package javafxscheduler;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler {
    // Attribute
    public Connection conn = null; 
    //public Statement stmt = null; 
    private String username = "root"; 
    private String pass = "12345678";

    /** Establish connection to JDBC */  /*
    public void connect_JDBC() throws ClassNotFoundException, SQLException {       
        // Register JDBC Driver
        Class.forName("com.mysql.jdbc.Driver");

        // Open a connection
        conn = DriverManager.getConnection("jdbc:mysql://localhost/?useSSL=false", username, pass);
    } */
    
    /** Establish connection to database CALENDAR */
    public void connect_CALENDAR() {
        try {
            // Register JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost/CALENDAR?useSSL=false", this.username, this.pass);
            System.out.println("Sucessfully connected to Calendar");
        } catch (ClassNotFoundException ex) {
            System.out.println("connect_Calendar() error: " + ex);
        } catch (SQLException ex) {
            System.out.println("connect_Calendar() error: " + ex);
        }
    }
    
    /** Close connection*/ 
    public void close_JDBC() {
        try {
            conn.close();
            System.out.println("Close JDBC");
        } catch (SQLException ex) {
            System.out.println("close_JDBC() error: " + ex);
        }
    }

    /*
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
    }  */
    
    
    public void createDatabase () {
        try {
            //db.connect_JDBC(); // Connect to mySQL
            
            // Open a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/?useSSL=false", username, pass);
            
            /**
             * Create database and tables
             */
            String query;
            Statement stmt = conn.createStatement();
            
            //Create database called Calendar
            stmt.execute("CREATE DATABASE IF NOT EXISTS CALENDAR");
            // Use database CALENDAR
            stmt.execute("USE CALENDAR");
            // Create table USERS
            query = "CREATE TABLE IF NOT EXISTS USERS (" +
                    "first_name varchar(32) not NULL, " +
                    "last_name varchar(32) not NULL, " +
                    "username varchar(32) not NULL, " +
                    "password varchar(32) not NULL, " +
                    "email varchar(32) not NULL " +
                    ")";
            stmt.execute(query);
            
            //Close conneciton.
            conn.close(); 
        } catch (ClassNotFoundException ex) {
            System.out.println("createDatabase() error: " + ex);
        } catch (SQLException ex) {
            System.out.println("createDatabase() error: " + ex);
        }
    }
}
 
