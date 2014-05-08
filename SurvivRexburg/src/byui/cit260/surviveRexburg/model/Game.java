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
public class Game implements Serializable{
    
    // class instance variables
    private double daysPassed;
    private String savedGameName;

    public Game() {
    }


    
    
    public double getDaysPassed() {
        return daysPassed;
    }

    public void setDaysPassed(double daysPassed) {
        this.daysPassed = daysPassed;
    }

    public String getSavedGameName() {
        return savedGameName;
    }

    public void setSavedGameName(String savedGameName) {
        this.savedGameName = savedGameName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.daysPassed) ^ (Double.doubleToLongBits(this.daysPassed) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.savedGameName);
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
        if (Double.doubleToLongBits(this.daysPassed) != Double.doubleToLongBits(other.daysPassed)) {
            return false;
        }
        if (!Objects.equals(this.savedGameName, other.savedGameName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "daysPassed=" + daysPassed + ", savedGameName=" + savedGameName + '}';
    }



}
