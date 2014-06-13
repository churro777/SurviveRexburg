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
public class Scenario implements Serializable{
    //attributes
    public static boolean active;
    public static int scenarioValue;  //or range
    private static String scenarioName;
    private static String scenarioDescription;
    private static String choiceOne;
    private static String choiceTwo;
    private static String choiceThree;
    private static String choiceFour;
    private static String choiceFive;

    //constructor
    public Scenario(){
    }

    public Scenario(boolean active, int scenarioValue, String scenarioName, String scenarioDescription, String choiceOne, String choiceTwo, String choiceThree, String choiceFour, String choiceFive) {
        Scenario.active = active;
        Scenario.scenarioValue = scenarioValue;
        Scenario.scenarioName = scenarioName;
        Scenario.scenarioDescription = scenarioDescription;
        Scenario.choiceOne = choiceOne;
        Scenario.choiceTwo = choiceTwo;
        Scenario.choiceThree = choiceThree;
        Scenario.choiceFour = choiceFour;
        Scenario.choiceFive = choiceFive;
        
        
    }
    
    //getter and setter
    public int getScenarioValue() {
        return scenarioValue;
    }

    public void setScenarioValue(int scenarioValue) {
        this.scenarioValue = scenarioValue;
    }
    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }
    
    //other functions
    public int randomScenario(){
        return 0;   
    }
    
    public int addCharLuckValue(){
        return 0;
    }
    
    public boolean dayEnd(){
        return false || true;
    }
    
    public boolean nothingHappens(){
        return false || true;
    }
    
    public boolean survivorsHelp(){
        return false || true;
    }
    
    public boolean survivorsAskHelp(){
        return false || true;
    }
    
    public boolean findSurvivorsHome(){
        return false || true;
    }
    
    public boolean findItems(){
        return false || true;
    }
    
    public boolean findZombies(){
        return false || true;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getScenarioDescription() {
        return scenarioDescription;
    }

    public void setScenarioDescription(String scenarioDescription) {
        this.scenarioDescription = scenarioDescription;
    }

    public String getChoiceOne() {
        return choiceOne;
    }

    public void setChoiceOne(String choiceOne) {
        this.choiceOne = choiceOne;
    }

    public String getChoiceTwo() {
        return choiceTwo;
    }

    public void setChoiceTwo(String choiceTwo) {
        this.choiceTwo = choiceTwo;
    }

    public String getChoiceThree() {
        return choiceThree;
    }

    public void setChoiceThree(String choiceThree) {
        this.choiceThree = choiceThree;
    }

    public String getChoiceFour() {
        return choiceFour;
    }

    public void setChoiceFour(String choiceFour) {
        this.choiceFour = choiceFour;
    }

    public String getChoiceFive() {
        return choiceFive;
    }

    public void setChoiceFive(String choiceFive) {
        this.choiceFive = choiceFive;
    }

    @Override
    public String toString() {
        return "Scenario{" + "active=" + active + ", scenarioValue=" + scenarioValue + ", scenarioName=" + scenarioName + ", scenarioDescription=" + scenarioDescription + ", choiceOne=" + choiceOne + ", choiceTwo=" + choiceTwo + ", choiceThree=" + choiceThree + ", choiceFour=" + choiceFour + ", choiceFive=" + choiceFive + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.active ? 1 : 0);
        hash = 97 * hash + this.scenarioValue;
        hash = 97 * hash + Objects.hashCode(this.scenarioName);
        hash = 97 * hash + Objects.hashCode(this.scenarioDescription);
        hash = 97 * hash + Objects.hashCode(this.choiceOne);
        hash = 97 * hash + Objects.hashCode(this.choiceTwo);
        hash = 97 * hash + Objects.hashCode(this.choiceThree);
        hash = 97 * hash + Objects.hashCode(this.choiceFour);
        hash = 97 * hash + Objects.hashCode(this.choiceFive);
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
        final Scenario other = (Scenario) obj;
        if (this.active != other.active) {
            return false;
        }
        if (this.scenarioValue != other.scenarioValue) {
            return false;
        }
        if (!Objects.equals(this.scenarioName, other.scenarioName)) {
            return false;
        }
        if (!Objects.equals(this.scenarioDescription, other.scenarioDescription)) {
            return false;
        }
        if (!Objects.equals(this.choiceOne, other.choiceOne)) {
            return false;
        }
        if (!Objects.equals(this.choiceTwo, other.choiceTwo)) {
            return false;
        }
        if (!Objects.equals(this.choiceThree, other.choiceThree)) {
            return false;
        }
        if (!Objects.equals(this.choiceFour, other.choiceFour)) {
            return false;
        }
        if (!Objects.equals(this.choiceFive, other.choiceFive)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
