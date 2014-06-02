/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import Survivrexburg.SurviveRexburg;
import byui.cit260.survivRexburg.control.ProgramControl;
import java.util.Scanner;

/**
 *
 * @author carissa888
 */
public class MainMenuView {

    private final String MENU = "\n"
            + "\n---------------MAIN MENU-----------------"
            + "\n|G - Start game                         |"
            + "\n|H - Get Help on how to play the game   |"
            + "\n|S - Save Game                          |"
            + "\n|E - Exit                               |"
            + "\n-----------------------------------------";
                
    void displayMenu() {
        
        char selection = ' ';
        do{
            
            System.out.println(MENU);       // display the main menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0);    //get first charcter of string
            
            this.doAction(selection);       // do action based on selection
        } while (selection != 'E');         // an selection is not "EXIT"
    }

    private String getInput() {
        boolean valid = false; //indicates if the name has been retrieved
        String input = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name ahs not been retrieved
            
            //get the name for the keyboard and trim off the blanks
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.toUpperCase().equals("E")) { // exiting?
                return null;
            }
            
                valid = true; //signal that a valid name was entered
        }
        return input; //return the input
    } 

    private void doAction(char choice) {
        
        switch (choice) {
            case 'G': //display the game menu
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.displayMenu();
                break;
            case 'H': //display the help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.displayMenu();
                break;
            case 'S': //save the current game to disk
                ProgramControl.saveGame(SurviveRexburg.getCurrentGame());
                break;
            case 'E': //exit the program
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;
            
        }
    }
    


//class ends
}
