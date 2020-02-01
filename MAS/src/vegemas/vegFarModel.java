/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegemas;

import DBClass.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @asus
 */

    public class vegFarModel {

    private String price;
    private String item;
    private String location;
    private int quantity;
    private String name;
    private Connection con;

    public vegFarModel() {
    }

    public vegFarModel(String name,String price, String item,int quantity, String location) {
        this.name= name;
        this.price = price;
        this.item = item;
        this.quantity = quantity;
        this.location = location;
        con=DBConnection.getCon();
    }

    @Override
    public String toString() {
        return  "(" + this.item + "- " + this.quantity + " items , " + this.price + " per each.)";
    }

    public boolean input() {
        boolean status = false;
        
        
        try {
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO `buyer` (`Name`, `Item`, `Price`,`Quantity`,`Location`) VALUES ('"+name+"','"+item+"','"+price+"','"+quantity+"','"+location+"')";
            st.executeUpdate(sql);
            status=true;
        } catch (SQLException ex) {
            Logger.getLogger(BuyerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuyerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return status;
    }

}
//THIS class is for testing data.
