/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

/**
 *
 * @author arturoaguila
 */
public class ScenarioControl {
    private int scenarioValue;
    private int randomLuckValue;
    
    public int chooseScenarioValue(int charLuckValue){
        randomLuckValue = (int) ((Math.random() * charLuckValue) + 1);// charLuckValue
        
        scenarioValue = (int) ((Math.random() * 100) + 1); //insert random number equation here
                
        
        if (scenarioValue < 1){ //scenarioValue cant be 0 or negative
		return -1;
        }

        if (scenarioValue > 109){ //scenarioValue cant be over 109
		return -1;
        }
        
	scenarioValue += randomLuckValue; // randomluck = (whole number between 1 and charLuckValue)
		return scenarioValue;

        
        
    }
    
    
    
    
}
