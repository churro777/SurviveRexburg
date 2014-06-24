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
public class MeleeWeapons extends InventoryItems implements Serializable{
    
    //attributes
    private int meleeWeaponStrengthValue;
    
    //getter and setter
    public int getmeleeWeaponStrengthValue() {
        return meleeWeaponStrengthValue;
    }

    public void setmeleeWeaponStrengthValue(int meleeWeaponStrengthValue) {
        this.meleeWeaponStrengthValue = meleeWeaponStrengthValue;
    }
    //otherfunctions
    
    
    //constructor
    public MeleeWeapons() {
    }
    
    //overloader
    public MeleeWeapons(int i, String melee_Weapon, String baseball_Bat) {
    }
    
}
    
    //toString
    @Override
    public String toString() {
        return "MeleeWeapons{" + "meleeWeaponStrengthValue=" + meleeWeaponStrengthValue + '}';
    }
    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.meleeWeaponStrengthValue;
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
        if (this.meleeWeaponStrengthValue != other.meleeWeaponStrengthValue) {
            return false;
        }
        return true;
    }
    
    //other attributes
    
    
    
    
}
