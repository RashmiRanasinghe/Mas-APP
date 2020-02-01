/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegemas;

import DBClass.DBConnection;
import GUI.AddBuyer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserDetails {
    private String userName;
    private String password;
    private Connection con ;
    public UserDetails(String userName, String password) {
        this.userName = userName;
        this.password = password;
        con = DBConnection.getCon();
    }

 
  
    public boolean authenticate(){
        boolean status = false;
        
        
        try {
            Statement st = con.createStatement();
            
            String sql = "SELECT `Password` FROM `login` WHERE `userName`='"+userName+"'";
            st.executeQuery(sql);
            ResultSet rs=st.getResultSet();
                   
              String dbPassWord="";
              try{
            while (rs.next()) {
             dbPassWord= rs.getString("password");
            }
            if(password.equals(dbPassWord)){
            status=true;
            }
              }catch(SQLException e){
                  System.out.println(e.getMessage());
              }
        } catch (SQLException ex) {
            Logger.getLogger(UserDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
return status;
    }
    
      public boolean Addusers(){
        boolean status = false;
        
        
        try {
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO `login`(`userName`, `password`) VALUES ('"+userName+"','"+password+"')";  
            st.executeUpdate(sql);
            status=true;
        } catch (SQLException ex) {
            Logger.getLogger(AddBuyer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddBuyer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return status;
    }
}
