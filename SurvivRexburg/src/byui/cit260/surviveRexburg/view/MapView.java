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
            
        super    ("\n----------Game Map-----------"
                + "\n|-1-|-2-|-3-|-4-|-5-|-6-|-7-|");

            //FOR every row in the map
            int k = 0;
            for (int i = 0; i < 6; i++){
                //DISPLAY row divider
                System.out.println("\n+---+---+---+---+---+---+---+");
                //DISPLAY row number
                System.out.println(" " + i +" ");
                //FOR every column in the row
                for (int j = 0; j < 7; j++){
                    k++;
                    //DISPLAY a column divider
                    System.out.println("| " + k + " ");
                    
                } //ENDFOR
                //DISPLAY ending column divider
            }//ENDFOR

            System.out.println("\nQ - Quit to Game Menu");
        
    }//end of MapView

    public void doAction(String value) {
         System.out.println("\n"
                 + "\n **** Open GameplayScreen *****");
    }
 
    private final String OPENMAPDISPLAY = "\n"
                + "\n------------------MAP--------------------"
                + "\n Pick what Location to go to"
                + "\n-----------------------------------------";
    
    
    
    
}
