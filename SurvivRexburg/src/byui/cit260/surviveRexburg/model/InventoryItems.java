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
public class InventoryItems implements Serializable{
    
    //attributes
    private int weight;
    private String inventoryType;
    private String itemName;
    private String Description;
    private int quantityInStock;

    public InventoryItems(int i, String inventoryType, String itemName) {
        this.weight = weight;
        this.inventoryType = inventoryType;
        this.itemName = itemName;
    }
    
    //getter and setter
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    
    
    //constructor
    public InventoryItems() {
    }
    
  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.weight;
        hash = 13 * hash + Objects.hashCode(this.inventoryType);
        hash = 13 * hash + Objects.hashCode(this.itemName);
        hash = 13 * hash + Objects.hashCode(this.Description);
        hash = 13 * hash + this.quantityInStock;
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
        if (this.weight != other.weight) {
            return false;
        }
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
        return "InventoryItems{" + "weight=" + weight + ", inventoryType=" + inventoryType + ", itemName=" + itemName + ", Description=" + Description + ", quantityInStock=" + quantityInStock + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
