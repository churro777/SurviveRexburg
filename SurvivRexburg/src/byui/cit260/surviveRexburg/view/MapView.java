/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.model.Location;
import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class MapView extends View{
    
    public MapView() {
            
            super("\n----------Game Map-----------"
                + "\n| - |-1-|-2-|-3-|-4-|-5-|-6-|-7-|"
                + "\n+---+---+---+---+---+---+---+---+"
                + "\n| 1 | 2 | 1 | 1 | 1 | 1 | 1 |"
                
                + "\nQ - Quit to Game Menu");
        
    }

    @Override
    public void doAction(String value) {
         System.out.println("\n"
                 + "\n **** Open GameplayScreen *****");
    }
 
    private final String OPENMAPDISPLAY = "\n"
                + "\n------------------MAP--------------------"
                + "\n Pick what Location to go to"
                + "\n-----------------------------------------";
    
    
    
    
}
