/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

/**
 *
 * @author carissa888
 */
public class Backpack implements Serializable {

    /*public static String size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void add(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void remove(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    

    
    //class instance variables
    private int maxWeight;
    private int loadedWeight;
    private Food[] backpackFood;

    public Backpack() {
    }
    
    
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

    public Food[] getBackpackFood() {
        return backpackFood;
    }

    public void setBackpackFood(Food[] backpackFood) {
        this.backpackFood = backpackFood;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.maxWeight;
        hash = 67 * hash + this.loadedWeight;
        hash = 67 * hash + Arrays.deepHashCode(this.backpackFood);
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
        if (this.maxWeight != other.maxWeight) {
            return false;
        }
        if (this.loadedWeight != other.loadedWeight) {
            return false;
        }
        if (!Arrays.deepEquals(this.backpackFood, other.backpackFood)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Backpack{" + "maxWeight=" + maxWeight + ", loadedWeight=" + loadedWeight + ", backpackFood=" + backpackFood + '}';
    }
    
    
    
}
