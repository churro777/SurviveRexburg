/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.view.GameMenuView;
import byui.cit260.surviveRexburg.view.MapView;
import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class FortifiedLocation {
    int fortifyValue = SurviveRexburg.getCurrentGame().getFortifyLevel();
    
    private final String FORTIFIED_LOCATION =(  
              "\n================================="
            + "\n Fortified Your Location"
            + "\n"
            + "\n  Fortification Level " + fortifyValue
            + "\n================================="
            + "\n You spent most of your day"
            + "\n fortifying your defenses for"
            + "\n whatever will come your way."
            + "\n"
            + "\n You hear a sound what could"
            + "\n it be?"
            + "\n================================="
            + "\n1 - Look Outside"
            + "\n"
            + "\nM - Open Menu");
    

    public void display() {
        String value;
        do {
            
            System.out.println(FORTIFIED_LOCATION);       // display the main menu
            
            value = this.getInput(); // get the user's selection
            this.doAction(value);       // do action based on selection
        } 
        while (!value.equals("Q"));         // an selection is not "EXIT"
    }

    
    public String getInput() {
        
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        boolean valid = false; //indicates if the name has been retrieved
        String selection = null;
        
        
        while (!valid) { //while a valid name has not been retrieved
            
            //get the name for the keyboard and trim off the blanks
            System.out.println("\t\nEnter your selection below:");
            
            
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() < 1) { // exiting?
                System.out.println("\n*** Invalid selection *** Try again");
                continue;
            }
            
            break;
        }
        return selection; //return the input
    }

    
    
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case '1':
                SurviveRexburg.getScenarioControl().decideFortifyPossibilities();
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
