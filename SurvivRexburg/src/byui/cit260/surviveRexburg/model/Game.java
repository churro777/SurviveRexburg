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
 * @author arturoaguila
 */
public class Game implements Serializable{
    
    // class instance variables
    private int daysPassed;
    private String savedGameName;
    private Map map;
    private EndUser endUser;
    private InventoryItems[] inventoryItems;
    private GameCharacter[] gameCharacters;
    private Backpack backpack;


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
    
    public Game() {
        this.daysPassed = 0;
    }


    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.daysPassed) ^ (Double.doubleToLongBits(this.daysPassed) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.savedGameName);
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
        if (Double.doubleToLongBits(this.daysPassed) != Double.doubleToLongBits(other.daysPassed)) {
            return false;
        }
        if (!Objects.equals(this.savedGameName, other.savedGameName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "daysPassed=" + daysPassed + ", savedGameName=" + savedGameName + '}';
    }



}
