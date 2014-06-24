/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;

/**
 *
 * @author carissa888
 */
public class Food extends InventoryItems implements Serializable{
    
    //attributes
    private int foodHealthValue;
    private int foodHungerValue;

    
    
    //getter and setter
    public int getfoodHealthValue() {
        return foodHealthValue;
    }

    public void setfoodHealthValue(int foodHealthValue) {
        this.foodHealthValue = foodHealthValue;
    }

    public int getfoodHungerValue() {
        return foodHungerValue;
    }

    public void setfoodHungerValue(int foodHungerValue) {
        this.foodHungerValue = foodHungerValue;
    }
    
    //constructor
    public Food() {
    }
    
    //overloader
    public Food(int i, String food, String canned_Tuna) {
    }
    
    
    //toString
    @Override
    public String toString() {
        return "Food{" + "foodHealthValue=" + foodHealthValue + ", foodHungerValue=" + foodHungerValue + '}';
    }
    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.foodHealthValue;
        hash = 29 * hash + this.foodHungerValue;
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
        final Food other = (Food) obj;
        if (this.foodHealthValue != other.foodHealthValue) {
            return false;
        }
        if (this.foodHungerValue != other.foodHungerValue) {
            return false;
        }
        return true;
    }
    
    //other attributes
    
}
