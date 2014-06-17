/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.surviveRexburg.model.InventoryItems;
import byui.cit260.surviveRexburg.model.Location;
import byui.cit260.surviveRexburg.model.Map;
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
                this.displayMap();
                break;
            case 'I': //show the current equipment display
                this.viewInventory();
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

    private void viewInventory() {
        //Get the sorted list of inventory items for the current game
        InventoryItems[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\nList of Inventory Items");
        System.out.println("Description" + "\t" +
                           "Required" + "\t" +
                           "In Stock");
        
        //for each inventory item
        for (InventoryItems inventoryItem : inventory){
            //DISPLAY the description, the required amount and amount in stock
            System.out.println(inventoryItem.getDescription() + "\t    " +
                               inventoryItem.getRequiredAmount() + "\t    " +
                               inventoryItem.getQuantityInStock());
        }
        
        
    }

    private void displayMap() {
        //BEGIN
            //get the map of locations for the current game
        //    Location[][] locations = Map.getLocations();
            
            //DISPLAY "Game Map"
        //    System.out.println("\n----------Game Map-----------");
        
        
            //DISPLAY a row of column numbers
            

            //FOR every row in the map
                //DISPLAY row divider
                //DISPLAY row number
                //FOR every column in the row
                    //DISPLAY a column divider
                    //location = location[row][column]
                    //IF location has been visited THEN
                        //DISPLAY the location’s map symbol
                    //ELSE
                        //DISPLAY " ?? "
                    //ENDIF
                //ENDFOR
                //DISPLAY ending column divider
            //ENDFOR
        
    }
   
    
    
    
    
}//end of class
