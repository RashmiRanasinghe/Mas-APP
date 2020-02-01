/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegemas;

import java.util.Scanner;
import masmt3.agent.MaSMTAbstractAgent;
import masmt3.message.MaSMTMessage;

/**
 *
 * @author asus
 */
public class VegeBuyerAgent extends masmt3.agent.MaSMTAgent {

    String item;
    String location;
    

    MaSMTMessage tempmes;
   

    public VegeBuyerAgent() {
        super();
    }

    public VegeBuyerAgent(String group, String role, int id) {
        super(group, role, id);
        

    }

    @Override
    public void active() {
        Scanner in = new Scanner(System.in);
        System.out.println("[Active] .... " + super.agent);
         System.out.println("Enter Item name: (Item) : ");
       item= in.next();
        System.out.println("Enter city: (Location) : ");
        location = in.next();

        MaSMTAbstractAgent sender = new MaSMTAbstractAgent("masmt", "vegel", 1);
        MaSMTAbstractAgent reader = new MaSMTAbstractAgent("masmt", "vegel", 2);
        MaSMTMessage m = new MaSMTMessage(sender, reader, sender,
                "get_vegetable", "" + location, "text", "broadcast");
        sendMessage(m);

    }

    @Override
    public void live() {
        tempmes = waitForMessage();
        System.out.println("" + tempmes);
    }

    @Override
    public void end() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
