/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.model.EndUser;
import byui.cit260.surviveRexburg.model.Game;
import byui.cit260.surviveRexburg.model.Location;
import byui.cit260.surviveRexburg.model.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author arturoaguila
 */
public class GameControl {
    private static Game game;
    private int gameHungerValue;
    
    /*
    private listLocations(){
        
        for (var i=0, i<maxValue; i++){
            
        }
    }*/
    
    public static void startNewGame(){
        
        // create new game
        GameControl.game = new Game();
        
        // save as current game
        SurviveRexburg.setCurrentGame(game);
        
        //set player in game object
        GameControl.game.setEndUser(SurviveRexburg.getEndUser());
        
        GameControl.createMap();    //creates game
        GameControl.createEndUser();//creates game
        
    }
    
    public int increaseDailyDifficulty(int scenarioValue, int daysPassed) {
        
        if (scenarioValue < 1 || scenarioValue > 100){
            return -1;
        }
        
        if (daysPassed < 1 || daysPassed > 30){
            return -1;
        }

        scenarioValue -= daysPassed;

        return scenarioValue;    
    }
    
    
    public int decreaseCharHunger(int charHungerValue){
        
        
        if (charHungerValue < 1 || charHungerValue > 100){
                return -1;
        }

        gameHungerValue =  (int) ((Math.random() * 10) + 1);
        
        charHungerValue -= gameHungerValue;

        return charHungerValue;
    }
    
    private static void createMap() {
        Map map = new Map(20,20);
        
        System.out.println("***Choose Scenario function runs ***");
    }

    private static void createEndUser() {
        System.out.println("***createEndUser function runs***");
    }
    
    
   
}//end of class
