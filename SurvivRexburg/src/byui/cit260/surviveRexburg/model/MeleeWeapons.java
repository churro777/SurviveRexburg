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
    public int meleeWeaponStrengthValue;
    
    //otherfunctions
    //getter and setter
    public int getMeleeWeaponStrengthValue() {
        return meleeWeaponStrengthValue;
    }

    public void setMeleeWeaponStrengthValue(int meleeWeaponStrengthValue) {
        this.meleeWeaponStrengthValue = meleeWeaponStrengthValue;
    }
    
    
    
    //constructor
    public MeleeWeapons() {
    }
    
    //overloader
    public MeleeWeapons(int i, String melee_Weapon, String baseball_Bat) {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.meleeWeaponStrengthValue;
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

    @Override
    public String toString() {
        return "MeleeWeapons{" + "meleeWeaponStrengthValue=" + meleeWeaponStrengthValue + '}';
    }
    
    
    
    
}
    
    
    
    
