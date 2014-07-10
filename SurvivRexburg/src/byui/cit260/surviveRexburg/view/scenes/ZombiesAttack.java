/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import byui.cit260.surviveRexburg.view.View;

/**
 *
 * @author arturoaguila
 */
public class ZombiesAttack extends View{

    public ZombiesAttack() {
        super("\n================================="
                + "\n-----------Day Over-------------"
                + "\n---------------------------------"
                + "\n The day is done."
                + "\n================================="
                + "\n1 - Sleep"
                + "\n"
                + "\nM - Open Menu");
    }

    @Override
    public void doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
