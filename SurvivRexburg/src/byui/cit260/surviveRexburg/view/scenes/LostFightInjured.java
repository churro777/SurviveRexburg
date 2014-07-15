/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import Survivrexburg.SurviveRexburg;
import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.surviveRexburg.view.GameMenuView;
import byui.cit260.surviveRexburg.view.StartProgramView;
import byui.cit260.surviveRexburg.view.View;
import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class LostFightInjured {
    
    int health = SurviveRexburg.getEndUser().getHealth();

    private final String INJURED_BUT_SURVIVED =
        (    "\n================================="
            + "\n------Injured But Survived-------"
            + "\n Health " + health
            + "\n================================="
            + "\n Turns out you're not as good of"
            + "\n a fighter as you thought. On the "
            + "\n plus side you're a survivor. You "
            + "\n made out alive with a few injuries "
            + "\n but at least you made it out alive."
            + "\n================================="
            + "\n"
            + "\n1 - End Day"
            + "\n"
            + "\nM - Open Menu");
    

    public void display() {
        String value;
        do {
            GameControl.decreaseHealth();
            
            System.out.println(INJURED_BUT_SURVIVED);       // display the main menu
            
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
            case '1': // end day screen
                DayEndScene dayEndScene = new DayEndScene();
                dayEndScene.display();
            case 'M':
                GameMenuView gameMenuView = new GameMenuView();
                gameMenuView.display();
            case 'Q': //quit game
                StartProgramView startProgramView = new StartProgramView();
                startProgramView.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;
            
        }
    }
    
}
