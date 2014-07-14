/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import Survivrexburg.SurviveRexburg;
import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.survivRexburg.control.ScenarioControl;
import byui.cit260.surviveRexburg.view.scenes.FortifiedLocation;
import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class FirstDayView {
    int days = SurviveRexburg.getCurrentGame().getDaysPassed();
    int health = SurviveRexburg.getEndUser().getHealth();
    int hunger = SurviveRexburg.getEndUser().getHunger();
    
    private final String FIRST_DAY = (
            "\n-------Your Adventure Begins---------"
            + "\n"
            + "\n You're a student at BYU - Idaho when the outbreak "
            + "\nhappened. You didn't think that it would reach Rexburg"
            + "\nbut it did. Now it's time to survive until help arrives."
            + "\n"
            + "\n You hear on the radio that help should be here in"
            + "\nthirty days. So thats how long you need to survive."
            + "\n"
            + "\n Now what do you want to do today?"
            + "\n================================="
            + "\n--------Start of a New Day-------"
            + "\n Day " + days
            + "\n Health - " + health + " Hunger - " + hunger
            + "\n================================="
            + "\n1 - Explore Rexburg"
            + "\n2 - Fortify your location"
            + "\n3 - Scavenge your location"
            + "\n4 - Sit and wait"
            + "\n"
            + "\nM - Open Menu");
    


    public void display() {
        String value;
        do {
            
            System.out.println(FIRST_DAY);       // display the main menu
            
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
            case '1': //display the movementdisplay
                System.out.println("****Explore Choice****");
                MapView mapView = new MapView();
                mapView.display();
                break;
            case '2': //save the current equipment display
                GameControl.increaseFortifyLevel();
                System.out.println("**** Fortify choice ****");
                FortifiedLocation fortifyLocation = new FortifiedLocation();
                fortifyLocation.display();
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
