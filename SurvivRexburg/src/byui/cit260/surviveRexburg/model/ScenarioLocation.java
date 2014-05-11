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
public class ScenarioLocation implements Serializable{
    //attributes
    private int zombieKillRecord;
    private boolean visited;
    private boolean notVisited;
    private int survivorKillRecord;
    private int survivorHelpRecord;
    private double effectsToCharacter;
    
    //constructor
    public ScenarioLocation() {
    }
    
    //getter and setter
    public int getZombieKillRecord() {
        return zombieKillRecord;
    }

    public void setZombieKillRecord(int zombieKillRecord) {
        this.zombieKillRecord = zombieKillRecord;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isNotVisited() {
        return notVisited;
    }

    public void setNotVisited(boolean notVisited) {
        this.notVisited = notVisited;
    }

    public int getSurvivorKillRecord() {
        return survivorKillRecord;
    }

    public void setSurvivorKillRecord(int survivorKillRecord) {
        this.survivorKillRecord = survivorKillRecord;
    }

    public int getSurvivorHelpRecord() {
        return survivorHelpRecord;
    }

    public void setSurvivorHelpRecord(int survivorHelpRecord) {
        this.survivorHelpRecord = survivorHelpRecord;
    }

    public double getEffectsToCharacter() {
        return effectsToCharacter;
    }

    public void setEffectsToCharacter(double effectsToCharacter) {
        this.effectsToCharacter = effectsToCharacter;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.zombieKillRecord;
        hash = 97 * hash + (this.visited ? 1 : 0);
        hash = 97 * hash + (this.notVisited ? 1 : 0);
        hash = 97 * hash + this.survivorKillRecord;
        hash = 97 * hash + this.survivorHelpRecord;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.effectsToCharacter) ^ (Double.doubleToLongBits(this.effectsToCharacter) >>> 32));
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
        final ScenarioLocation other = (ScenarioLocation) obj;
        if (this.zombieKillRecord != other.zombieKillRecord) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (this.notVisited != other.notVisited) {
            return false;
        }
        if (this.survivorKillRecord != other.survivorKillRecord) {
            return false;
        }
        if (this.survivorHelpRecord != other.survivorHelpRecord) {
            return false;
        }
        if (Double.doubleToLongBits(this.effectsToCharacter) != Double.doubleToLongBits(other.effectsToCharacter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ScenarioLocation{" + "zombieKillRecord=" + zombieKillRecord + ", visited=" + visited + ", notVisited=" + notVisited + ", survivorKillRecord=" + survivorKillRecord + ", survivorHelpRecord=" + survivorHelpRecord + ", effectsToCharacter=" + effectsToCharacter + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
