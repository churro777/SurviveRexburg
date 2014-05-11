/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Survivrexburg;

import byui.cit260.surviveRexburg.model.Game;
import byui.cit260.surviveRexburg.model.GameCharacter;
import byui.cit260.surviveRexburg.model.Location;
import byui.cit260.surviveRexburg.model.Map;
import byui.cit260.surviveRexburg.model.Zombies;


/**
 *
 * @author arturoaguila
 */
public class SurviveRexburg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instance of a game
        Game game = new Game();
        
        game.setDaysPassed(20);
        game.setSavedGameName("Arty");

        String gameInfo = game.toString();
        System.out.println(gameInfo);
    
        //instance of a GameCharacter - Ben Brown
        GameCharacter ben = new GameCharacter();
        
        ben.setCharacterName("Ben Brown");
        ben.setCharismaValue(1);
        ben.setHealthValue(100);
        ben.setHungerValue(100);
        ben.setLuckValue(4);
        ben.setSpeedValue(5);
        ben.setStrengthValue(10);
        
        String benInfo = ben.toString();
        System.out.println(benInfo);
         
        //instance of Zombie - nathan
        Zombies nathan = new Zombies();
        
        nathan.setNumberOfZombies(1);
        nathan.setStrengthValue(10);
        
        String nathanInfo = nathan.toString();
        System.out.println(nathanInfo);
        
        //instance of Location - Walmart
        Location walmart = new Location();
        
        walmart.setName("Walmart");
        walmart.setColumnNumber(1);
        walmart.setRowNumber(7);
        
        String walmartInfo = walmart.toString();
        System.out.println(walmartInfo);
        
        //instance of Map
        Map rexburg = new Map();
        
        rexburg.setColumnCount(15);
        rexburg.setRowCount(15);
        
        String rexburgInfo = rexburg.toString();
        System.out.println(rexburgInfo);
    }
}


