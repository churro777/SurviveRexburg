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
public class Food implements Serializable{
    
    //attributes
    private int healthValue;
    private int hungerValue;
    
    //getter and setter
    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    public int getHungerValue() {
        return hungerValue;
    }

    public void setHungerValue(int hungerValue) {
        this.hungerValue = hungerValue;
    }
    
    //constructor
    public Food() {
    }
    
    //toString
    @Override
    public String toString() {
        return "Food{" + "healthValue=" + healthValue + ", hungerValue=" + hungerValue + '}';
    }
    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.healthValue;
        hash = 29 * hash + this.hungerValue;
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
        if (this.healthValue != other.healthValue) {
            return false;
        }
        if (this.hungerValue != other.hungerValue) {
            return false;
        }
        return true;
    }
    
    //other attributes
    
}
