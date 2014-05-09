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
    private int strengthValue;
    private int speedValue;
    private int charismaValue;
    private int luckValue;
    private int hungerValue;
    private int healthValue;
    private String characterName;
    
    //constructor function
    public GameCharacter() {
    }
    
    
    //getter and setter functions
    public double getStrengthValue() {
        return strengthValue;
    }

    public void setStrengthValue(double strengthValue) {
        this.strengthValue = (int) strengthValue;
    }

    public double getSpeedValue() {
        return speedValue;
    }

    public void setSpeedValue(double speedValue) {
        this.speedValue = (int) speedValue;
    }

    public double getCharismaValue() {
        return charismaValue;
    }

    public void setCharismaValue(double charismaValue) {
        this.charismaValue = (int) charismaValue;
    }

    public double getLuckValue() {
        return luckValue;
    }

    public void setLuckValue(double luckValue) {
        this.luckValue = (int) luckValue;
    }

    public double getHungerValue() {
        return hungerValue;
    }

    public void setHungerValue(double hungerValue) {
        this.hungerValue = (int) hungerValue;
    }

    public double getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(double healthValue) {
        this.healthValue = (int) healthValue;
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
