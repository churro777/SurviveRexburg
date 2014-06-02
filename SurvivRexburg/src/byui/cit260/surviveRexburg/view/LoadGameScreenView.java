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
public class LoadGameScreenView {
    private final String LOADGAME = "\n"
            + "\n --------------LOAD GAME----------------"
            + "\n|      Pick a Saved Game to Load        |"
            + "\n| *** Display SavedGames ***            |"
            + "\n| 1 - Game 1                            |"
            + "\n| 2 - Game 2                            |"
            + "\n| 3 - Game 3                            |"
            + "\n| Q - Quit back to Start Menu           |"
            + "\n ----------------------------------------";
    
    public static void getSavedGame(){
        System.out.println("\n **** getSavedGame function happens ****");
        
    }

    
    void displayMenu() {
        char selection = ' ';
        do{
            
            System.out.println(LOADGAME);       // display the main menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0);    //get first charcter of string
            
            this.doAction(selection);       // do action based on selection
        } 
        while (selection != 'Q');         // an selection is not "EXIT"
    }

    private String getInput() {
        boolean valid = false; //indicates if the name has been retrieved
        String input = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name ahs not been retrieved
            
            //get the name for the keyboard and trim off the blanks
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.toUpperCase().equals("Q")) { // exiting?
                return null;
            }
            
                valid = true; //signal that a valid name was entered
        }
        return input; //return the input
    }

    private void doAction(char choice) {
        
        switch (choice) {
            case '1': //display the movementdisplay
                System.out.println("**** Load first saved game ****");
                break;
            case '2': //save the current equipment display
                System.out.println("**** Load second saved game ****");
                break;
            case '3': //save the current equipment display
                System.out.println("**** Load third saved game ****");
                break;
            case 'Q': //exit menu and return to Main Menu
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.displayMenu();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
    }
    
    
    
    
}//end class
