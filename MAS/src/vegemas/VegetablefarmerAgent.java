/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegemas;

import masmt3.message.MaSMTMessage;

/**
 *
 * @author User
 */
public class VegetablefarmerAgent extends masmt3.agent.MaSMTAgent {

    private String name;
    private String price;
     private String item;
    private int quantity;
    private String location;
    MaSMTMessage tempmes;

    public VegetablefarmerAgent() {
        super();
    }

    public VegetablefarmerAgent(String gp, String role, int id) {
        super(gp, role, id);
    }

    public VegetablefarmerAgent(String name, String price, String item, int quantity, String location,String group, String role, int id) {
         super(group, role, id);
        this.name = name;
        this.price = price;
        this.item = item;
        this.quantity = quantity;
        this.location = location;
        this.tempmes = tempmes;
    }

  
 

    @Override
    public void active() {
        System.out.println("[Active] .... " + super.agent);

    }

    @Override
    public void live() {
        tempmes = waitForMessage();

        if (tempmes.message.equals("get_vegetable")) {
            String newlocation = (tempmes.content);
             
            if (newlocation.equals(location)) {
                String m = "Found " + name + " selling " + quantity+" of Kg Rs."+price+" per 1Kg";
                System.out.println(m);
            }

        }
        setLive(false);

    }

    @Override
    public void end() {
       
    }

}
