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
public class Map implements Serializable{
    
    //attributes
    private int noOfRows;       //amount of rows
    private int noOfColumns;    //amount of columns
    private Location[][] locations;
    
    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
    
    
    //constructor function
    public Map() {
    }
    //overloaded constructor function
    public Map(int noOfRows, int noOfColumns){
        
        if (noOfRows < 1 || noOfColumns < 1){
            System.out.println("The number of rows and columns must be > zero.");
            return;
        }
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        //create 2-D arroy for Location objects
        this.locations = new Location[noOfRows][noOfColumns];
        
        for (int row = 0; row < noOfColumns; row++){
            for(int column = 0; column < noOfColumns; column++){
                
                
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
                
                locations[row][column] = location;
            }
        }
    }
    
    
    
    
    
    
    //getter and setter
    public int getRowCount() {
        return noOfRows;
    }

    public void setRowCount(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getColumnCount() {
        return noOfColumns;
    }

    public void setColumnCount(int noOfColumns) {
        this.noOfColumns = noOfColumns;
    }
    
    //other fucntions
    public int chooseLocation(){
        return 0;    
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.noOfRows;
        hash = 67 * hash + this.noOfColumns;
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
        final Map other = (Map) obj;
        if (this.noOfRows != other.noOfRows) {
            return false;
        }
        return this.noOfColumns == other.noOfColumns;
    }

    @Override
    public String toString() {
        return "Map{" + "noOfRows=" + noOfRows + ", noOfColumns=" + noOfColumns + '}';
    }
    
    
    
    
    
}
    