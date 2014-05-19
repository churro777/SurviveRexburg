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
public class MeleeWeapons implements Serializable{
    
    //attributes
    private int strengthValue;
    
    //getter and setter
    public int getStrengthValue() {
        return strengthValue;
    }

    public void setStrengthValue(int strengthValue) {
        this.strengthValue = strengthValue;
    }
    //otherfunctions
    
    
    //constructor
    public MeleeWeapons() {
    }
    
    //toString
    @Override
    public String toString() {
        return "MeleeWeapons{" + "strengthValue=" + strengthValue + '}';
    }
    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.strengthValue;
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
        final MeleeWeapons other = (MeleeWeapons) obj;
        if (this.strengthValue != other.strengthValue) {
            return false;
        }
        return true;
    }
    
    //other attributes
    
    
    
    
}
