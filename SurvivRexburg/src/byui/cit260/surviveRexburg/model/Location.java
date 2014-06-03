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
public class Location implements Serializable{
    
    //attributes
    private String name;
    private int rowNumber;
    private int columnNumber;
    
    String[] gameLocations = {"Walmart", "Bunkhouse", "Royal Crest", "Hart Building", "Broulim's"};

            
            
    
    //constructor
    public Location() {
    }
    
    //getter and setter for attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + this.rowNumber;
        hash = 17 * hash + this.columnNumber;
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
        if (this.rowNumber != other.rowNumber) {
            return false;
        }
        if (this.columnNumber != other.columnNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", rowNumber=" + rowNumber + ", columnNumber=" + columnNumber + '}';
    }
    
    
    
}
