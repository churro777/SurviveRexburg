/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;

/**
 *
 * @author arturoaguila
 */
public class Zombies implements Serializable{
    
    //class instance variables
    private int numberOfZombies;
    private int strengthValue;

    //consturctor functino
    public Zombies() {
    }
    
    // getter and setter functions
    public int getNumberOfZombies() {
        return numberOfZombies;
    }

    public void setNumberOfZombies(double numberOfZombies) {
        this.numberOfZombies = (int) numberOfZombies;
    }

    public int getStrengthValue() {
        return strengthValue;
    }

    public void setStrengthValue(int strengthValue) {
        this.strengthValue = strengthValue;
    }
    
    
    
    //other functions
    /**
     * this determines if zombie attacks the end user
     * @return = hit or miss 
     */
    public boolean attack(){
        return false || true;
    } 
    
    /**
     * If an end user attacks a zombie and the zombie(s) lose then they die
     * @return die or not
     */
    public boolean die(){
        return false || true;   
    }
    /**
     * If a player tries to run he may become captures by the zombies or escape
     * @return capture player or player escapes
     */
    public boolean capture(){
        return false || true;   
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.numberOfZombies;
        hash = 97 * hash + this.strengthValue;
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
        final Zombies other = (Zombies) obj;
        if (this.numberOfZombies != other.numberOfZombies) {
            return false;
        }
        if (this.strengthValue != other.strengthValue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Zombies{" + "numberOfZombies=" + numberOfZombies + ", strengthValue=" + strengthValue + '}';
    }
    
    
    
    
}