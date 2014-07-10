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
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case '1': //display the movementdisplay
                System.out.println("***First choice ****");
                break;
            case '2': //save the current equipment display
                System.out.println("**** Second choice ****");
                break;
            case '3': //save the current equipment display
                System.out.println("**** Third choice ****");
                break;
            case '4':
                System.out.println("**** Fourth choice ****");
                break;
            case 'M': //exit menu and return to Main Menu
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
        
 }
    
}
