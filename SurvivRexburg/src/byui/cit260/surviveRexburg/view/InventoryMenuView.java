/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import Survivrexburg.SurviveRexburg;
import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.survivRexburg.control.ProgramControl;
import byui.cit260.surviveRexburg.model.InventoryItems;

/**
 *
 * @author arturoaguila
 */
public class InventoryMenuView {

    public InventoryMenuView(String promptMessage) {
      
    }


    public void doAction(String value) {
        
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case 'G': //Start game - FirstDayView
                FirstDayView firstDayView = new FirstDayView();
                firstDayView.display();
                break;
            case 'H': //display the help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.display();
                break;
            case 'S': //save the current game to disk
                ProgramControl.saveGame(SurviveRexburg.getCurrentGame());
                break;
            case 'Q': //exit the program
                StartProgramView startProgramView = new StartProgramView();
                startProgramView.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;
            
        }
    }
    
    
    
    /*private void viewInventory() {
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
                               inventoryItem.getQuantityInStock());
        }
        
        
    }
    */
    
    private final String INVENTORYDISPLAY = "\n"
                + "\n---------------INVENTORY-----------------"
                + "\n stop asking me how to do things"
                + "\n-----------------------------------------";
    
    
}//end of class
