/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class DBConnection {
    


    private static String url = "jdbc:mysql://localhost:3306/mas";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "";
    private static Connection con;
    
    public static Connection getCon() {
        try {
            Class.forName(driverName);
            
                con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
                System.out.println("Failed to create the database connection");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not FOund");
        }
       
        return con;
    }

}
  

