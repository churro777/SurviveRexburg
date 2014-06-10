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
    private int charStrengthValue;
    private int charSpeedValue;
    private int charCharismaValue;
    private int charLuckValue;
    private int charHungerValue;
    private int charHealthValue;
    private String characterName;
    
    //constructor function
    public GameCharacter() {
    }

    public GameCharacter(int charStrengthValue, int charSpeedValue, int charCharismaValue, int charLuckValue, String characterName) {
        this.charStrengthValue = charStrengthValue;
        this.charSpeedValue = charSpeedValue;
        this.charCharismaValue = charCharismaValue;
        this.charLuckValue = charLuckValue;
        this.charHungerValue = 100;
        this.charHealthValue = 100;
        this.characterName = characterName;
    }

    
    
    
    //getter and setter functions
    public double getcharStrengthValue() {
        return charStrengthValue;
    }

    public void setcharStrengthValue(double charStrengthValue) {
        this.charStrengthValue = (int) charStrengthValue;
    }

    public double getcharSpeedValue() {
        return charSpeedValue;
    }

    public void setcharSpeedValue(double charSpeedValue) {
        this.charSpeedValue = (int) charSpeedValue;
    }

    public double getcharCharismaValue() {
        return charCharismaValue;
    }

    public void setcharCharismaValue(double charCharismaValue) {
        this.charCharismaValue = (int) charCharismaValue;
    }

    public double getcharLuckValue() {
        return charLuckValue;
    }

    public void setcharLuckValue(double charLuckValue) {
        this.charLuckValue = (int) charLuckValue;
    }

    public double getcharHungerValue() {
        return charHungerValue;
    }

    public void setcharHungerValue(double charHungerValue) {
        this.charHungerValue = (int) charHungerValue;
    }

    public double getcharHealthValue() {
        return charHealthValue;
    }

    public void setcharHealthValue(double charHealthValue) {
        this.charHealthValue = (int) charHealthValue;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    //other functions
    /**
     * 
     * @return true or false
     */
    public boolean doNothing(){
        return false || true;
    }
    
    /**
     * if end user decides to attack then a random scenario will happen
     * @return true or false
     */
    public boolean attack(){
        return false || true;
    }
    
    /**
     * if end user decides to "explore" then a random scenario will happen
     * @return 
     */
    public boolean explore(){
        return false || true;
    }
    
    /**
     * if end user decides to "fortify" then a random scenario will happen
     * @return 
     */
    public boolean fortify(){
        return false || true;
    }
    
    @Override
    public String toString() {
        return "GameCharacter{" + "charStrengthValue=" + charStrengthValue + ", charSpeedValue=" + charSpeedValue + ", charCharismaValue=" + charCharismaValue + ", charLuckValue=" + charLuckValue + ", charHungerValue=" + charHungerValue + ", charHealthValue=" + charHealthValue + ", characterName=" + characterName + '}';
    }

    public void getCharacterName(String ben) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
