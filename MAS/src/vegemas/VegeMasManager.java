/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegemas;

import masmt3.masmt.Settings;
import masmt3.message.MaSMTMessage;

/**
 *
 * @author User
 */
public class VegeMasManager extends masmt3.agent.MaSMTManager {

    MaSMTMessage tempmes;

    public VegeMasManager() {
        super();
        new Settings(50, 100, 10);
    }

    public static void main(String[] args) {
        VegeMasManager rm1 = new VegeMasManager();
        rm1.start();
    }

    @Override
    public void active() {

        System.out.println("[Active] MANAGER  .... " + super.agent);
        setNumberofClients(6);
        agents[0] = new VegeBuyerAgent("masmt", "client", 1);
        agents[1] = new VegetablefarmerAgent("Chanaka","100", "Carrot",20, "Anuradhapura", "masmt", "vegel", 2 ); 
        agents[2] = new VegetablefarmerAgent("perera","150", "Carrot",20, "Kandy", "masmt", "vegel", 3 );
        agents[3] = new VegetablefarmerAgent("Bandara","60", "Carrot",20, "Polonnaruwa", "masmt", "vegel", 4);
        agents[4] = new VegetablefarmerAgent("Chamara","70", "Carrot",20, "Anuradhapura", "masmt", "vegel", 5 );
        agents[5] = new VegetablefarmerAgent("pubudu","80", "Carrot",20, "KURUNAGALA", "masmt", "vegel", 6 );
        
      

        activeAllClients();
        activeMessageParsing();

    }

    @Override
    public void live() {

    }

    @Override
    public void end() {

    }

}
