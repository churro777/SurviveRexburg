/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import Survivrexburg.SurviveRexburg;
import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.surviveRexburg.model.InventoryItems;
import byui.cit260.surviveRexburg.model.Location;
import byui.cit260.surviveRexburg.model.Map;
import byui.cit260.surviveRexburg.model.Scenario;
import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class GameMenuView extends View{
    
    public GameMenuView(){
    super("\n"
    + "\n---------------GAME MENU-----------------"
    + "\nM - Open Map"
    + "\nI - Inventory"
    + "\nS - Scenarios"
    + "\nQ - Quit"
    + "\n-----------------------------------------");
    }
        
        
                
        
    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case 'M': //display the movementdisplay
                MapView mapView = new MapView();
                mapView.display();
                break;
            case 'I': //show the current equipment display
                
                break;
            case 'S':
                
                break;
            case 'Q': //exit menu and return to Main Menu
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
    }

    
    /*
    private void displayScenarios() {
        //Display scenes
        //get sorted scenes list
        Scenario[] scenarios = GameControl.getSortedScenarioList();
        
        System.out.println("\nScenario List");
        
        //for every scenario
        for (Scenario scenario : scenarios) {
            System.out.println(scenario.getScenarioName());
            System.out.println(scenario.getScenarioDescription());
            
        }
                //display the scenario
    }
    */


   
    
    
    
    
}//end of class
