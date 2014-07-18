/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author carissa888
 */
public abstract class InventoryItems implements InventoryItemsInterface{
    
    //attributes
    private String inventoryType;
    private String itemName;
    private String Description;
    private int quantityInStock;

    public InventoryItems() {
    }

    public InventoryItems(String inventoryType, String itemName, int quantityInStock) {
        this.inventoryType = inventoryType;
        this.itemName = itemName;
        this.quantityInStock = quantityInStock;
    }
    
    

    @Override
    public String getInventoryType() {
        return inventoryType;
    }

    @Override
    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public int getQuantityInStock() {
        return quantityInStock;
    }

    @Override
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.inventoryType);
        hash = 71 * hash + Objects.hashCode(this.itemName);
        hash = 71 * hash + Objects.hashCode(this.Description);
        hash = 71 * hash + this.quantityInStock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InventoryItems other = (InventoryItems) obj;
        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (this.quantityInStock != other.quantityInStock) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InventoryItems{" + "inventoryType=" + inventoryType + ", itemName=" + itemName + ", Description=" + Description + ", quantityInStock=" + quantityInStock + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
    
}
