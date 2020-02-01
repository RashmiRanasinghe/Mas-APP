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
import java.util.logging.Level;
import java.util.logging.Logger;
import masmt3.message.MaSMTMessage;

/**
 *
 * @author asus
 */
public class BuyerAgent extends masmt3.agent.MaSMTAgent {

    
    public BuyerModel buyer;
    MaSMTMessage mes;
 private Connection con ; 
    public BuyerAgent(BuyerModel buyer, String group, String role, int id) {
        super(group, role, id);
        this.buyer = buyer;
    }
    
     String mess;
    public BuyerAgent( String mess) {
        
       this.mess= mess;
       con = DBConnection.getCon();
    }

    @Override
    public void active() {


    }

    @Override
    public void live() {

        
        mes = waitForMessage();
        System.out.println(agent + "<<" +mes);
        wait(1000);

        wait(1000);
    }

    @Override
    public void end() {
    }
 public boolean add(){
        boolean status = false;
        
        
        try {
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO `messagetable` (`Message`,`Reply`) VALUES ('"+mess+"','"+null+"')";
            st.executeUpdate(sql);
            status=true;
        } catch (SQLException ex) {
            Logger.getLogger(BuyerAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuyerAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return status;
    }

}
