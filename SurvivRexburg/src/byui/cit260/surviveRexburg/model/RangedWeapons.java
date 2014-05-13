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
public class RangedWeapons implements Serializable{
    
    //attribute
    private int luckValue;
    
    //getter and setter
    public int getLuckValue() {
        return luckValue;
    }

    public void setLuckValue(int luckValue) {
        this.luckValue = luckValue;
    }
    
    //constructor
    public RangedWeapons() {
    }
    
    //toString
    @Override
    public String toString() {
        return "RangedWeapons{" + "luckValue=" + luckValue + '}';
    }
    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.luckValue;
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
        final RangedWeapons other = (RangedWeapons) obj;
        if (this.luckValue != other.luckValue) {
            return false;
        }
        return true;
    }
    
    
}
