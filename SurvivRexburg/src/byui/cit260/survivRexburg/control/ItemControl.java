/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import byui.cit260.surviveRexburg.model.Backpack;
import byui.cit260.surviveRexburg.model.GameCharacter;

/**
 *
 * @author arturoaguila
 */
public class ItemControl {
    
    
    private static Backpack createBackpack(){
        Backpack backpack = new Backpack();
        backpack.setMaxWeight(10* GameCharacter.charStrengthValue);
        backpack.setLoadedWeight(0);
        return backpack;
    }
    
    
    
    
    
    
    
    
    
    
}
