/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class MapView extends View{
    
    public MapView() {
            
        super("\n"
            + "\n------MAP-------"
            + "\n****************"
            + "\n|      |       |"
            + "\n|  01  |  02   |"
            + "\n|      |       |"
            + "\n****************"
            + "\n|      |       |"
            + "\n|  03  |  04   |"
            + "\n|      |       |"
            + "\n****************"
            + ""
            + "Q - Quit to Game Menu");
        
    }    

    public void doAction(String value) {
         System.out.println("\n"
                 + "\n **** Open GameplayScreen *****");
    }
    
}
