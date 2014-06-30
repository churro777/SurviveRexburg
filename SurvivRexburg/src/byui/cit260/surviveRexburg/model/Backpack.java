/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

/**
 *
 * @author carissa888
 */
public class Backpack implements Serializable {
    
    //Flexible Array (?)

    
    //class instance variables
    private int maxWeight;
    private int loadedWeight;

    //getter and setter
    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
   
    public int getLoadedWeight() {
        return loadedWeight;
    }

    public void setLoadedWeight(int loadedWeight) {
        this.loadedWeight = loadedWeight;
    }
      //constructor
    public Backpack() {
    }
 
    
    //toString
    @Override
    public String toString() {
        return "Backpack{" + "maxWeight=" + maxWeight + '}';
    }
    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.maxWeight);
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
        final Backpack other = (Backpack) obj;
        if (!Objects.equals(this.maxWeight, other.maxWeight)) {
            return false;
        }
        return true;
    }
    
    
  
}
