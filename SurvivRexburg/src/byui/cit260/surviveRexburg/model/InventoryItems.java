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
    
    private String name;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //constructor
    public InventoryItems() {
    }
    
    //toString
    @Override
    public String toString() {
        return "InventoryItems{" + "weight=" + weight + ", inventoryType=" + inventoryType + ", name=" + name + '}';
    }
    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.weight;
        hash = 43 * hash + Objects.hashCode(this.inventoryType);
        hash = 43 * hash + Objects.hashCode(this.name);
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}