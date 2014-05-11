/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;

/**
 *
 * @author arturoaguila
 */
public class Scenario implements Serializable{
    //attributes
    private int scenarioValue;
    
    //constructor
    public Scenario() {
    }
    
    //getter and setter
    public int getScenarioValue() {
        return scenarioValue;
    }

    public void setScenarioValue(int scenarioValue) {
        this.scenarioValue = scenarioValue;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.scenarioValue;
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
        if (this.scenarioValue != other.scenarioValue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Scenario{" + "scenarioValue=" + scenarioValue + '}';
    }
    
    
    
}
