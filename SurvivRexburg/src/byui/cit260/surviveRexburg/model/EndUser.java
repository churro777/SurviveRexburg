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
 * @author carissa888
 */
public class EndUser implements Serializable{
    
    //attributes
    private int bestScore;
    private String EndUserName;
    private Backpack backpack;
    private GameCharacter gameCharacter;

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
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
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.bestScore;
        hash = 79 * hash + Objects.hashCode(this.EndUserName);
        hash = 79 * hash + Objects.hashCode(this.backpack);
        hash = 79 * hash + Objects.hashCode(this.gameCharacter);
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
        if (!Objects.equals(this.EndUserName, other.EndUserName)) {
            return false;
        }
        if (!Objects.equals(this.backpack, other.backpack)) {
            return false;
        }
        if (!Objects.equals(this.gameCharacter, other.gameCharacter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EndUser{" + "bestScore=" + bestScore + ", EndUserName=" + EndUserName + ", backpack=" + backpack + ", gameCharacter=" + gameCharacter + '}';
    }
    
  

    
       
}
