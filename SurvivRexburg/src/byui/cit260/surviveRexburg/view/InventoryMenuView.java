/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.surviveRexburg.model.InventoryItems;

/**
 *
 * @author arturoaguila
 */
public class InventoryMenuView extends View{

    public InventoryMenuView(String promptMessage) {
        super(promptMessage);
    }

    @Override
    public void doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                               inventoryItem.getQuantityInStock());
        }
        
        
    }
    
    
    private final String INVENTORYDISPLAY = "\n"
                + "\n---------------INVENTORY-----------------"
                + "\n stop asking me how to do things"
                + "\n-----------------------------------------";
    
    
}//end of class
