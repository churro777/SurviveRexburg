/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

/**
 *
 * @author arturoaguila
 */
public interface InventoryItemsInterface {
    
    
    public String getInventoryType();

    public void setInventoryType(String inventoryType);

    public String getItemName();

    public void setItemName(String itemName);

    public String getDescription();

    public void setDescription(String Description);

    public int getQuantityInStock();

    public void setQuantityInStock(int quantityInStock);
    
}
