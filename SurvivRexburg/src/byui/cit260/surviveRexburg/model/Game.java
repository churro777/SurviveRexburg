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
    private Location[] locations;
    
    private Scenario[] oneWayScenarios;
    
    private Scenario[] chooseDoNothingPossibilities;
    private Scenario[] chooseFortifyPossibilities;
    private Scenario[] chooseExplorePossibilities;
    private Scenario[] chooseScavengePossbilities;
    
    private Scenario[] chooseAcceptHelpPossiblities;
    private Scenario[] chooseRunAwayFromSurvivorsPossibilities;
    private Scenario[] chooseNegotiatePossibilities;
    private Scenario[] chooseOfferingPossibilities;
    private Scenario[] chooseFightSurvivorsPossibilities;
    
    private Scenario[] chooseRunAwayFromZombiesPossibilities;
    private Scenario[] chooseFightZombiesPossibilities;

    
    //Constructor
    public Game() {
        this.daysPassed = 0;
    }

    public int getDaysPassed() {
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
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

    public GameCharacter[] getGameCharacters() {
        return gameCharacters;
    }

    public void setGameCharacters(GameCharacter[] gameCharacters) {
        this.gameCharacters = gameCharacters;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    public Scenario[] getOneWayScenarios() {
        return oneWayScenarios;
    }

    public void setOneWayScenarios(Scenario[] oneWayScenarios) {
        this.oneWayScenarios = oneWayScenarios;
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

    public Scenario[] getChooseRunAwayFromSurvivorsPossibilities() {
        return chooseRunAwayFromSurvivorsPossibilities;
    }

    public void setChooseRunAwayFromSurvivorsPossibilities(Scenario[] chooseRunAwayFromSurvivorsPossibilities) {
        this.chooseRunAwayFromSurvivorsPossibilities = chooseRunAwayFromSurvivorsPossibilities;
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

    public Scenario[] getChooseFightSurvivorsPossibilities() {
        return chooseFightSurvivorsPossibilities;
    }

    public void setChooseFightSurvivorsPossibilities(Scenario[] chooseFightSurvivorsPossibilities) {
        this.chooseFightSurvivorsPossibilities = chooseFightSurvivorsPossibilities;
    }

    public Scenario[] getChooseRunAwayFromZombiesPossibilities() {
        return chooseRunAwayFromZombiesPossibilities;
    }

    public void setChooseRunAwayFromZombiesPossibilities(Scenario[] chooseRunAwayFromZombiesPossibilities) {
        this.chooseRunAwayFromZombiesPossibilities = chooseRunAwayFromZombiesPossibilities;
    }

    public Scenario[] getChooseFightZombiesPossibilities() {
        return chooseFightZombiesPossibilities;
    }

    public void setChooseFightZombiesPossibilities(Scenario[] chooseFightZombiesPossibilities) {
        this.chooseFightZombiesPossibilities = chooseFightZombiesPossibilities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.daysPassed;
        hash = 31 * hash + Objects.hashCode(this.savedGameName);
        hash = 31 * hash + Objects.hashCode(this.map);
        hash = 31 * hash + Objects.hashCode(this.endUser);
        hash = 31 * hash + Arrays.deepHashCode(this.foodList);
        hash = 31 * hash + Arrays.deepHashCode(this.spoiledFoodList);
        hash = 31 * hash + Arrays.deepHashCode(this.meleeWeaponsList);
        hash = 31 * hash + Arrays.deepHashCode(this.rangedWeaponsList);
        hash = 31 * hash + Arrays.deepHashCode(this.gameCharacters);
        hash = 31 * hash + Objects.hashCode(this.backpack);
        hash = 31 * hash + Arrays.deepHashCode(this.locations);
        hash = 31 * hash + Arrays.deepHashCode(this.oneWayScenarios);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseDoNothingPossibilities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseFortifyPossibilities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseExplorePossibilities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseScavengePossbilities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseAcceptHelpPossiblities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseRunAwayFromSurvivorsPossibilities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseNegotiatePossibilities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseOfferingPossibilities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseFightSurvivorsPossibilities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseRunAwayFromZombiesPossibilities);
        hash = 31 * hash + Arrays.deepHashCode(this.chooseFightZombiesPossibilities);
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
        if (!Arrays.deepEquals(this.oneWayScenarios, other.oneWayScenarios)) {
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
        if (!Arrays.deepEquals(this.chooseRunAwayFromSurvivorsPossibilities, other.chooseRunAwayFromSurvivorsPossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseNegotiatePossibilities, other.chooseNegotiatePossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseOfferingPossibilities, other.chooseOfferingPossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseFightSurvivorsPossibilities, other.chooseFightSurvivorsPossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseRunAwayFromZombiesPossibilities, other.chooseRunAwayFromZombiesPossibilities)) {
            return false;
        }
        if (!Arrays.deepEquals(this.chooseFightZombiesPossibilities, other.chooseFightZombiesPossibilities)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "daysPassed=" + daysPassed + ", savedGameName=" + savedGameName + ", map=" + map + ", endUser=" + endUser + ", foodList=" + foodList + ", spoiledFoodList=" + spoiledFoodList + ", meleeWeaponsList=" + meleeWeaponsList + ", rangedWeaponsList=" + rangedWeaponsList + ", gameCharacters=" + gameCharacters + ", backpack=" + backpack + ", locations=" + locations + ", oneWayScenarios=" + oneWayScenarios + ", chooseDoNothingPossibilities=" + chooseDoNothingPossibilities + ", chooseFortifyPossibilities=" + chooseFortifyPossibilities + ", chooseExplorePossibilities=" + chooseExplorePossibilities + ", chooseScavengePossbilities=" + chooseScavengePossbilities + ", chooseAcceptHelpPossiblities=" + chooseAcceptHelpPossiblities + ", chooseRunAwayFromSurvivorsPossibilities=" + chooseRunAwayFromSurvivorsPossibilities + ", chooseNegotiatePossibilities=" + chooseNegotiatePossibilities + ", chooseOfferingPossibilities=" + chooseOfferingPossibilities + ", chooseFightSurvivorsPossibilities=" + chooseFightSurvivorsPossibilities + ", chooseRunAwayFromZombiesPossibilities=" + chooseRunAwayFromZombiesPossibilities + ", chooseFightZombiesPossibilities=" + chooseFightZombiesPossibilities + '}';
    }

    


    

    
    
    

    

    


}
