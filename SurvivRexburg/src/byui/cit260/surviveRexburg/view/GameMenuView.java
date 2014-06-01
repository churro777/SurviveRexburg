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
class GameMenuView {
        private final String GAMEMENU = "\n"
                + "\n---------------GAME MENU-----------------"
                + "\nM - Open Map"
                + "\nI - Inventory"
                + "\nQ - Quit"
                + "\n-----------------------------------------";
        private final String INVENTORYDISPLAY = "\n"
                + "\n---------------INVENTORY-----------------"
                + "\n stop asking me how to do things"
                + "\n-----------------------------------------";
                
        private final String OPENMAPDISPLAY = "\n"
                + "\n------------------MAP--------------------"
                + "\n Pick what Location to go to"
                + "\n-----------------------------------------";
        
        
        
        
    void displayMenu() {
        char selection = ' ';
        do{
            
            System.out.println(GAMEMENU);       // display the main menu
            
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
            case 'M': //display the movementdisplay
                System.out.println(OPENMAPDISPLAY);
                break;
            case 'I': //save the current equipment display
                System.out.println(INVENTORYDISPLAY);
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
    
}
