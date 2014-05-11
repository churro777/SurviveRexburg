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
public class Survivors implements Serializable{
    
    //attributes
    private int luckValue;
    
    //constuctor
    public Survivors() {
    }
    
    //getter and setter
    public int getLuckValue() {
        return luckValue;
    }

    public void setLuckValue(int luckValue) {
        this.luckValue = luckValue;
    }
    
    //other functions
    private boolean offerHelp(){
        return true || false;
    }
    
    private boolean askForHelp(){
        return true || false;
    }
    
    private boolean attack(){
        return true || false;
    }
    
    private boolean failedCapture(){
        return true || false;
    }
    
    private boolean successfulCapture(){
        return true || false;
    }
    
    private boolean fight(){
        return true || false;
    }
    
    private boolean die(){
        return true || false;
    }
    
    private boolean listen(){
        return true || false;
    }
    
    private boolean dontListen(){
        return true || false;
    }
    
    private boolean acceptOffering(){
        return true || false;
    }
    
    private boolean denyOffering(){
        return true || false;
    }
    
    private boolean robPlayer(){
        return true || false;
    }
    
    private boolean dontRobPlayer(){
        return true || false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.luckValue;
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
        final Survivors other = (Survivors) obj;
        if (this.luckValue != other.luckValue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Survivors{" + "luckValue=" + luckValue + '}';
    }
    
    
    
}
