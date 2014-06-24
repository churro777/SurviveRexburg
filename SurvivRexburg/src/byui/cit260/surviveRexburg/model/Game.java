/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author arturoaguila
 */
public class Game implements Serializable{
    
    // class instance variables
    private int daysPassed;
    private String savedGameName;
    private Map map;
    private EndUser endUser;
    private Food[] foodList;
    private SpoiledFood[] spoiledFoodList;
    private MeleeWeapons[] meleeWeaponsList;
    private RangedWeapons[] rangedWeaponsList;
    private RandomItems[] randomItemList;
    private GameCharacter[] gameCharacters;
    private Scenario[] scenarios;
    private Backpack backpack;
    private Location[][] locations;


    //getter and setter functions
    //GameCharacter getter and setter
    public GameCharacter[] getGameCharacters() {
        return gameCharacters;
    }

    public void setGameCharacters(GameCharacter[] gameCharacters) {
        this.gameCharacters = gameCharacters;
    }
    
    
    
    //inventoryItem getter and setter
    public InventoryItems[] getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(InventoryItems[] inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
    //Map getter and setter
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    //EndUser getter and setter
    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
    
    //backpack getter and setter
        public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }


    public double getDaysPassed() {
        return daysPassed;
    }

    public void setDaysPassed(int daysPassed) {
        this.daysPassed = daysPassed;
    }

    public String getSavedGameName() {
        return savedGameName;
    }

    public void setSavedGameName(String savedGameName) {
        this.savedGameName = savedGameName;
    }

    public Scenario[] getScenarios() {
        return scenarios;
    }

    public void setScenarios(Scenario[] scenarios) {
        this.scenarios = scenarios;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
    
    
    
    
    
    
    public Game() {
        this.daysPassed = 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.daysPassed;
        hash = 97 * hash + Objects.hashCode(this.savedGameName);
        hash = 97 * hash + Objects.hashCode(this.map);
        hash = 97 * hash + Objects.hashCode(this.endUser);
        hash = 97 * hash + Arrays.deepHashCode(this.inventoryItems);
        hash = 97 * hash + Arrays.deepHashCode(this.gameCharacters);
        hash = 97 * hash + Arrays.deepHashCode(this.scenarios);
        hash = 97 * hash + Objects.hashCode(this.backpack);
        hash = 97 * hash + Arrays.deepHashCode(this.locations);
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
        final Game other = (Game) obj;
        if (this.daysPassed != other.daysPassed) {
            return false;
        }
        if (!Objects.equals(this.savedGameName, other.savedGameName)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.endUser, other.endUser)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventoryItems, other.inventoryItems)) {
            return false;
        }
        if (!Arrays.deepEquals(this.gameCharacters, other.gameCharacters)) {
            return false;
        }
        if (!Arrays.deepEquals(this.scenarios, other.scenarios)) {
            return false;
        }
        if (!Objects.equals(this.backpack, other.backpack)) {
            return false;
        }
        if (!Arrays.deepEquals(this.locations, other.locations)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "daysPassed=" + daysPassed + ", savedGameName=" + savedGameName + ", map=" + map + ", endUser=" + endUser + ", inventoryItems=" + inventoryItems + ", gameCharacters=" + gameCharacters + ", scenarios=" + scenarios + ", backpack=" + backpack + ", locations=" + locations + '}';
    }

    

    
    
    
    

    



}
