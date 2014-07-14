/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;
import java.util.Objects;
        
/**
 *
 * @author carissa888
 */
public class EndUser implements Serializable{
    
    //attributes
    private int health;
    private int hunger;
    private String EndUserName;
    private Backpack backpack;
    private GameCharacter gameCharacter;
    private MeleeWeapons meleeWeapon;
    private RangedWeapons rangedWeapon;

    public EndUser() {
    }
    
    
    public EndUser(int health, int hunger, String EndUserName, Backpack backpack, GameCharacter gameCharacter, MeleeWeapons meleeWeapon, RangedWeapons rangedWeapon) {
        this.health = health;
        this.hunger = hunger;
        this.EndUserName = EndUserName;
        this.backpack = backpack;
        this.gameCharacter = gameCharacter;
        this.meleeWeapon = meleeWeapon;
        this.rangedWeapon = rangedWeapon;
    }

    

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public String getEndUserName() {
        return EndUserName;
    }

    public void setEndUserName(String EndUserName) {
        this.EndUserName = EndUserName;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public MeleeWeapons getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(MeleeWeapons meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public RangedWeapons getRangedWeapon() {
        return rangedWeapon;
    }

    public void setRangedWeapon(RangedWeapons rangedWeapon) {
        this.rangedWeapon = rangedWeapon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.health;
        hash = 89 * hash + this.hunger;
        hash = 89 * hash + Objects.hashCode(this.EndUserName);
        hash = 89 * hash + Objects.hashCode(this.backpack);
        hash = 89 * hash + Objects.hashCode(this.gameCharacter);
        hash = 89 * hash + Objects.hashCode(this.meleeWeapon);
        hash = 89 * hash + Objects.hashCode(this.rangedWeapon);
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
        final EndUser other = (EndUser) obj;
        if (this.health != other.health) {
            return false;
        }
        if (this.hunger != other.hunger) {
            return false;
        }
        if (!Objects.equals(this.EndUserName, other.EndUserName)) {
            return false;
        }
        if (!Objects.equals(this.backpack, other.backpack)) {
            return false;
        }
        if (!Objects.equals(this.gameCharacter, other.gameCharacter)) {
            return false;
        }
        if (!Objects.equals(this.meleeWeapon, other.meleeWeapon)) {
            return false;
        }
        if (!Objects.equals(this.rangedWeapon, other.rangedWeapon)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EndUser{" + "health=" + health + ", hunger=" + hunger + ", EndUserName=" + EndUserName + ", backpack=" + backpack + ", gameCharacter=" + gameCharacter + ", meleeWeapon=" + meleeWeapon + ", rangedWeapon=" + rangedWeapon + '}';
    }

    
   
}
