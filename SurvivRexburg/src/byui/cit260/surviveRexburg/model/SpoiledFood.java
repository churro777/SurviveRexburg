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
public class SpoiledFood extends InventoryItems implements Serializable{
   
   //attributes 
   private int spoiledFoodHealthValue;
   private int spoiledFoodHungerValue;
   
    //getter and setter
    public int getspoiledFoodHealthValue() {
        return spoiledFoodHealthValue;
    }

    public void setspoiledFoodHealthValue(int spoiledFoodHealthValue) {
        this.spoiledFoodHealthValue = spoiledFoodHealthValue;
    }

    public int getspoiledFoodHungerValue() {
        return spoiledFoodHungerValue;
    }

    public void setspoiledFoodHungerValue(int spoiledFoodHungerValue) {
        this.spoiledFoodHungerValue = spoiledFoodHungerValue;
    }
   
    //constructor
    public SpoiledFood() {
    }
    
    //overloader
    public SpoiledFood(int i, String food, String canned_Tuna) {
    }
    
    //toString
    @Override
    public String toString() {
        return "SpoiledFood{" + "spoiledFoodHealthValue=" + spoiledFoodHealthValue + ", spoiledFoodHungerValue=" + spoiledFoodHungerValue + '}';
    }
    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.spoiledFoodHealthValue;
        hash = 11 * hash + this.spoiledFoodHungerValue;
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
        final SpoiledFood other = (SpoiledFood) obj;
        if (this.spoiledFoodHealthValue != other.spoiledFoodHealthValue) {
            return false;
        }
        if (this.spoiledFoodHungerValue != other.spoiledFoodHungerValue) {
            return false;
        }
        return true;
    }
    
    
}
