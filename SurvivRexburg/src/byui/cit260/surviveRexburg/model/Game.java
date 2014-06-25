/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import byui.cit260.survivRexburg.control.GameControl;
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
    private RandomItems[] randomItemsList;
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

    public Food[] getFoodList() {
        return foodList;
    }

    public void setFoodList(Food[] foodList) {
        this.foodList = foodList;
    }

    public SpoiledFood[] getSpoiledFoodList() {
        return spoiledFoodList;
    }

    public void setSpoiledFoodList(SpoiledFood[] spoiledFoodList) {
        this.spoiledFoodList = spoiledFoodList;
    }

    public MeleeWeapons[] getMeleeWeaponsList() {
        return meleeWeaponsList;
    }

    public void setMeleeWeaponsList(MeleeWeapons[] meleeWeaponsList) {
        this.meleeWeaponsList = meleeWeaponsList;
    }

    public RangedWeapons[] getRangedWeaponsList() {
        return rangedWeaponsList;
    }

    public void setRangedWeaponsList(RangedWeapons[] rangedWeaponsList) {
        this.rangedWeaponsList = rangedWeaponsList;
    }

    public RandomItems[] getRandomItemsList() {
        return randomItemsList;
    }

    public void setRandomItemsList(RandomItems[] randomItemsList) {
        this.randomItemsList = randomItemsList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.daysPassed;
        hash = 47 * hash + Objects.hashCode(this.savedGameName);
        hash = 47 * hash + Objects.hashCode(this.map);
        hash = 47 * hash + Objects.hashCode(this.endUser);
        hash = 47 * hash + Arrays.deepHashCode(this.foodList);
        hash = 47 * hash + Arrays.deepHashCode(this.spoiledFoodList);
        hash = 47 * hash + Arrays.deepHashCode(this.meleeWeaponsList);
        hash = 47 * hash + Arrays.deepHashCode(this.rangedWeaponsList);
        hash = 47 * hash + Arrays.deepHashCode(this.randomItemsList);
        hash = 47 * hash + Arrays.deepHashCode(this.gameCharacters);
        hash = 47 * hash + Arrays.deepHashCode(this.scenarios);
        hash = 47 * hash + Objects.hashCode(this.backpack);
        hash = 47 * hash + Arrays.deepHashCode(this.locations);
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
        if (!Arrays.deepEquals(this.foodList, other.foodList)) {
            return false;
        }
        if (!Arrays.deepEquals(this.spoiledFoodList, other.spoiledFoodList)) {
            return false;
        }
        if (!Arrays.deepEquals(this.meleeWeaponsList, other.meleeWeaponsList)) {
            return false;
        }
        if (!Arrays.deepEquals(this.rangedWeaponsList, other.rangedWeaponsList)) {
            return false;
        }
        if (!Arrays.deepEquals(this.randomItemsList, other.randomItemsList)) {
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
    
    
    
    
    
    
    public Game() {
        this.daysPassed = 0;
    }

    public void setRandomItemsList(GameControl.RandomItems[] randomItemsList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    

    



}
