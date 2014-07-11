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
public class RangedWeapons extends InventoryItems implements Serializable{
    
    //attribute
    public int rangedWeaponLuckValue;
    
    //getter and setter
    public int getRangedWeaponLuckValue() {
        return rangedWeaponLuckValue;
    }

    public void setRangedWeaponLuckValue(int rangedWeaponLuckValue) {
        this.rangedWeaponLuckValue = rangedWeaponLuckValue;
    }
    
    
    
    //constructor
    public RangedWeapons() {
    }
    
    //overloader
    public RangedWeapons(int i, String ranged_Weapon, String shotgun) {
    }
    
    //toString
    @Override
    public String toString() {
        return "RangedWeapons{" + "rangedWeaponLuckValue=" + rangedWeaponLuckValue + '}';
    }
    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.rangedWeaponLuckValue;
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
        if (this.rangedWeaponLuckValue != other.rangedWeaponLuckValue) {
            return false;
        }
        return true;
    }
    
    
}
