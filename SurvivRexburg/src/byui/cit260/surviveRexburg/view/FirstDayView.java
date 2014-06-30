/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import Survivrexburg.SurviveRexburg;
import byui.cit260.survivRexburg.control.GameControl;

/**
 *
 * @author arturoaguila
 */
public class FirstDayView extends View{

    public FirstDayView() {
        super    ("\n-------Your Adventure Begins---------"
                + "\n"
                + "\n You're a student at BYU - Idaho when the outbreak "
                + "\nhappened. You didn't think that it would reach Rexburg"
                + "\nbut it did. Now it's time to survive until help arrives."
                + "\n"
                + "\n You hear on the radio that help should be here in"
                + "\nthirty days. So thats how long you need to survive."
                + "\n"
                + "\n Now what do you want to do today?"
                + "\n---------------------------------"
                + "\n------------Choices------------"
                + "\n1 - Explore Rexburg"
                + "\n2 - Fortify your location"
                + "\n3 - Scavenge your location"
                + "\n4 - Sit and wait"
                + "\n"
                + "\nM - Open Menu");
    }



    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case '1': //display the movementdisplay
                
                break;
            case '2': //save the current equipment display
                System.out.println("**** Second choice ****");
                break;
            case '3': //save the current equipment display
                System.out.println("**** Third choice ****");
                break;
            case '4':
                System.out.println("**** DoNothing choice ****");
                GameControl.game.
                break;
            case '5':
                System.out.println("**** Nothing is there****");
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
