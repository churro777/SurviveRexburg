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
public class Location implements Serializable{
    
    //attributes
    private String name;
    private int row;
    private int column;
    private boolean visited;
    private Scenario scenario;
    private Survivors[] survivors;
    private Zombies[] zombies;

    
    
    
    //getter and setter for attributes
    //Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Row
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    //Column
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    //Scenario
    public Scenario getScenario() {
        return scenario;
    }
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    //Survivors
    public Survivors[] getSurvivors() {
        return survivors;
    }
    public void setSurvivors(Survivors[] survivors) {
        this.survivors = survivors;
    }
    //Zombies
    public Zombies[] getZombies() {
        return zombies;
    }
    public void setZombies(Zombies[] zombies) {
        this.zombies = zombies;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
               
    
    //constructor
    public Location() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.row;
        hash = 89 * hash + this.column;
        hash = 89 * hash + (this.visited ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.scenario);
        hash = 89 * hash + Arrays.deepHashCode(this.survivors);
        hash = 89 * hash + Arrays.deepHashCode(this.zombies);
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (!Objects.equals(this.scenario, other.scenario)) {
            return false;
        }
        if (!Arrays.deepEquals(this.survivors, other.survivors)) {
            return false;
        }
        if (!Arrays.deepEquals(this.zombies, other.zombies)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", row=" + row + ", column=" + column + ", visited=" + visited + ", scenario=" + scenario + ", survivors=" + survivors + ", zombies=" + zombies + '}';
    }
    
    
    
    

    
    
    
    
}
