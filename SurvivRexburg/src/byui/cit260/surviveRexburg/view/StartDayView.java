/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.model.Game;

/**
 *
 * @author arturoaguila
 */
public class StartDayView extends View{
    

    public StartDayView() {
        super(  
                  "\n Now what do you want to do today?"
                + "\n================================="
                + "\n--------Start of a New Day-------"
                + "\n Day " 
                + "\n================================="
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
                MapView mapView = new MapView();
                mapView.display();
                break;
            case '2': //save the current equipment display
                System.out.println("**** Fortify choice ****");
                SurviveRexburg.getScenarioControl().decideFortifyPossibilities();
                break;
            case '3': //save the current equipment display
                System.out.println("**** Scavenge choice ****");
                SurviveRexburg.getScenarioControl().decideScavengePossibility();
                break;
            case '4':
                System.out.println("**** DoNothing choice ****");
                SurviveRexburg.getScenarioControl().decideDoNothingPossibility();
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
