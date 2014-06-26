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
    private GameCharacter[] gameCharacters;
    private Backpack backpack;
    private Location[][] locations;
    
    private Scenario[] mainScenarios;
    
    private Scenario[] chooseDoNothingPossibilities;
    private Scenario[] chooseFortifyPossibilities;
    private Scenario[] chooseExplorePossibilities;
    private Scenario[] chooseScavengePossbilities;
    
    private Scenario[] chooseAcceptHelpPossiblities;
    private Scenario[] chooseRunAwayPossibilities;
    private Scenario[] chooseNegotiatePossibilities;
    private Scenario[] chooseOfferingPossibilities;
    private Scenario[] chooseFightPossibilities;

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

    public Location[][] getLocations() {
        return locations;
    }

    /*public void setLocations(Location[][] locations) {
        this.locations = locations;
    }*/

    public void setLocations(Location[] locations) {
    
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

    public Scenario[] getChooseDoNothingPossibilities() {
        return chooseDoNothingPossibilities;
    }

    public void setChooseDoNothingPossibilities(Scenario[] chooseDoNothingPossibilities) {
        this.chooseDoNothingPossibilities = chooseDoNothingPossibilities;
    }

    public Scenario[] getChooseFortifyPossibilities() {
        return chooseFortifyPossibilities;
    }

    public void setChooseFortifyPossibilities(Scenario[] chooseFortifyPossibilities) {
        this.chooseFortifyPossibilities = chooseFortifyPossibilities;
    }

    public Scenario[] getChooseExplorePossibilities() {
        return chooseExplorePossibilities;
    }

    public void setChooseExplorePossibilities(Scenario[] chooseExplorePossibilities) {
        this.chooseExplorePossibilities = chooseExplorePossibilities;
    }

    public Scenario[] getChooseScavengePossbilities() {
        return chooseScavengePossbilities;
    }

    public void setChooseScavengePossbilities(Scenario[] chooseScavengePossbilities) {
        this.chooseScavengePossbilities = chooseScavengePossbilities;
    }

    public Scenario[] getChooseAcceptHelpPossiblities() {
        return chooseAcceptHelpPossiblities;
    }

    public void setChooseAcceptHelpPossiblities(Scenario[] chooseAcceptHelpPossiblities) {
        this.chooseAcceptHelpPossiblities = chooseAcceptHelpPossiblities;
    }

    public Scenario[] getChooseRunAwayPossibilities() {
        return chooseRunAwayPossibilities;
    }

    public void setChooseRunAwayPossibilities(Scenario[] chooseRunAwayPossibilities) {
        this.chooseRunAwayPossibilities = chooseRunAwayPossibilities;
    }

    public Scenario[] getChooseNegotiatePossibilities() {
        return chooseNegotiatePossibilities;
    }

    public void setChooseNegotiatePossibilities(Scenario[] chooseNegotiatePossibilities) {
        this.chooseNegotiatePossibilities = chooseNegotiatePossibilities;
    }

    public Scenario[] getChooseOfferingPossibilities() {
        return chooseOfferingPossibilities;
    }

    public void setChooseOfferingPossibilities(Scenario[] chooseOfferingPossibilities) {
        this.chooseOfferingPossibilities = chooseOfferingPossibilities;
    }

    public Scenario[] getChooseFightPossibilities() {
        return chooseFightPossibilities;
    }

    public void setChooseFightPossibilities(Scenario[] chooseFightPossibilities) {
        this.chooseFightPossibilities = chooseFightPossibilities;
    }

    public Scenario[] getMainScenarios() {
        return mainScenarios;
    }

    public void setMainScenarios(Scenario[] mainScenarios) {
        this.mainScenarios = mainScenarios;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.daysPassed;
        hash = 79 * hash + Objects.hashCode(this.savedGameName);
        hash = 79 * hash + Objects.hashCode(this.map);
        hash = 79 * hash + Objects.hashCode(this.endUser);
        hash = 79 * hash + Arrays.deepHashCode(this.foodList);
        hash = 79 * hash + Arrays.deepHashCode(this.spoiledFoodList);
        hash = 79 * hash + Arrays.deepHashCode(this.meleeWeaponsList);
        hash = 79 * hash + Arrays.deepHashCode(this.rangedWeaponsList);
        hash = 79 * hash + Arrays.deepHashCode(this.gameCharacters);
        hash = 79 * hash + Objects.hashCode(this.backpack);
        hash = 79 * hash + Arrays.deepHashCode(this.locations);
        hash = 79 * hash + Arrays.deepHashCode(this.mainScenarios);
        hash = 79 * hash + Arrays.deepHashCode(this.chooseDoNothingPossibilities);
        hash = 79 * hash + Arrays.deepHashCode(this.chooseFortifyPossibilities);
        hash = 79 * hash + Arrays.deepHashCode(this.chooseExplorePossibilities);
        hash = 79 * hash + Arrays.deepHashCode(this.chooseScavengePossbilities);
        hash = 79 * hash + Arrays.deepHashCode(this.chooseAcceptHelpPossiblities);
        hash = 79 * hash + Arrays.deepHashCode(this.chooseRunAwayPossibilities);
        hash = 79 * hash + Arrays.deepHashCode(this.chooseNegotiatePossibilities);
        hash = 79 * hash + Arrays.deepHashCode(this.chooseOfferingPossibilities);
        hash = 79 * hash + Arrays.deepHashCode(this.chooseFightPossibilities);
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
        if (!Arrays.deepEquals(this.gameCharacters, other.gameCharacters)) {
            return false;
        }
        if (!Objects.equals(this.backpack, other.backpack)) {
            return false;
        }
        if (!Arrays.deepEquals(this.locations, other.locations)) {
            return false;
        }
        if (!Arrays.deepEquals(this.mainScenarios, other.mainScenarios)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseDoNothingPossibilities, other.chooseDoNothingPossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseFortifyPossibilities, other.chooseFortifyPossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseExplorePossibilities, other.chooseExplorePossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseScavengePossbilities, other.chooseScavengePossbilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseAcceptHelpPossiblities, other.chooseAcceptHelpPossiblities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseRunAwayPossibilities, other.chooseRunAwayPossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseNegotiatePossibilities, other.chooseNegotiatePossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseOfferingPossibilities, other.chooseOfferingPossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseFightPossibilities, other.chooseFightPossibilities)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "daysPassed=" + daysPassed + ", savedGameName=" + savedGameName + ", map=" + map + ", endUser=" + endUser + ", foodList=" + foodList + ", spoiledFoodList=" + spoiledFoodList + ", meleeWeaponsList=" + meleeWeaponsList + ", rangedWeaponsList=" + rangedWeaponsList + ", gameCharacters=" + gameCharacters + ", backpack=" + backpack + ", locations=" + locations + ", mainScenarios=" + mainScenarios + ", chooseDoNothingPossibilities=" + chooseDoNothingPossibilities + ", chooseFortifyPossibilities=" + chooseFortifyPossibilities + ", chooseExplorePossibilities=" + chooseExplorePossibilities + ", chooseScavengePossbilities=" + chooseScavengePossbilities + ", chooseAcceptHelpPossiblities=" + chooseAcceptHelpPossiblities + ", chooseRunAwayPossibilities=" + chooseRunAwayPossibilities + ", chooseNegotiatePossibilities=" + chooseNegotiatePossibilities + ", chooseOfferingPossibilities=" + chooseOfferingPossibilities + ", chooseFightPossibilities=" + chooseFightPossibilities + '}';
    }
    

    
    
    

    
    
    public Game() {
        this.daysPassed = 0;
    }

    

    


}
