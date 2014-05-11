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
    private int rowCount;       //amount of rows
    private int columnCount;    //amount of columns
    
    //constructor function
    public Map() {
    }
    
    //getter and setter
    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
    
    //other fucntions
    public void startMap(){
        
    }
    public void displayMap(){
        
    }
    public int chooseLocation(){
        return 0;    
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.rowCount;
        hash = 67 * hash + this.columnCount;
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
        if (this.rowCount != other.rowCount) {
            return false;
        }
        return this.columnCount == other.columnCount;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + '}';
    }
    
    
}
    