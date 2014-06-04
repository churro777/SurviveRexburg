/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;
        
/**
 *
 * @author carissa888
 */
public class EndUser implements Serializable{
    
    //attributes
    private int bestScore;
    private String EndUserName;
    private Backpack backpack;
    private Character character;

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
    

    public String getEndUserName() {
        return EndUserName;
    }

    public void setEndUserName(String EndUserName) {
        this.EndUserName = EndUserName;
    }
    
    //constructor
    public EndUser() {
    }
    
    
    //getter and setter
    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
           
    }
    
    //other funtions
    private boolean doNothing(){
        return true || false;
    }
    
    private boolean fortify(){
        return true || false;
    }
    
    private boolean explore(){
        return true || false;
    }
    
    private boolean fight(){
        return true || false;
    }
    
    private boolean negotiate(){
        return true || false;
    }
    
    private boolean run(){
        return true || false;
    }
    
    private boolean beg(){
        return true || false;
    }
    
    private boolean getCaught(){
        return true || false;
    }
    
    private boolean escape(){
        return true || false;
    }
    
    private boolean getRobbed(){
        return true || false;
    }
    
    private boolean getInjured(){
        return true || false;
    }
    
    private boolean die(){
        return true || false;
    }
    
     private boolean winGame(){
        return true || false;
    }
    
    private boolean starve(){
        return true || false;
    }
    
  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.bestScore;
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
        final EndUser other = (EndUser) obj;
        if (this.bestScore != other.bestScore) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EndUser{" + "bestScore=" + bestScore + '}';
    }
       
}
