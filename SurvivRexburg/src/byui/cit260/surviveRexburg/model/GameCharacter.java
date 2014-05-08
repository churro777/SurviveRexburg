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
public class GameCharacter implements Serializable{
    
    //class instance variables
    private double strengthValue;
    private double speedValue;
    private double charismaValue;
    private double luckValue;
    private double hungerValue;
    private double healthValue;
    private String characterName;
    
    //constructor function
    public GameCharacter() {
    }
    
    
    //getter and setter functions
    public double getStrengthValue() {
        return strengthValue;
    }

    public void setStrengthValue(double strengthValue) {
        this.strengthValue = strengthValue;
    }

    public double getSpeedValue() {
        return speedValue;
    }

    public void setSpeedValue(double speedValue) {
        this.speedValue = speedValue;
    }

    public double getCharismaValue() {
        return charismaValue;
    }

    public void setCharismaValue(double charismaValue) {
        this.charismaValue = charismaValue;
    }

    public double getLuckValue() {
        return luckValue;
    }

    public void setLuckValue(double luckValue) {
        this.luckValue = luckValue;
    }

    public double getHungerValue() {
        return hungerValue;
    }

    public void setHungerValue(double hungerValue) {
        this.hungerValue = hungerValue;
    }

    public double getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(double healthValue) {
        this.healthValue = healthValue;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    @Override
    public String toString() {
        return "GameCharacter{" + "strengthValue=" + strengthValue + ", speedValue=" + speedValue + ", charismaValue=" + charismaValue + ", luckValue=" + luckValue + ", hungerValue=" + hungerValue + ", healthValue=" + healthValue + ", characterName=" + characterName + '}';
    }

    public void getCharacterName(String ben) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
