/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Survivrexburg;

import byui.cit260.surviveRexburg.model.Game;
import byui.cit260.surviveRexburg.model.GameCharacter;

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
    
        //instance of a GameCharacter - Ben Browning
        GameCharacter ben = new GameCharacter();
        
        ben.setCharacterName("Ben Browning");
        ben.setCharismaValue(1);
        ben.setHealthValue(100);
        ben.setHungerValue(100);
        ben.setLuckValue(4);
        ben.setSpeedValue(5);
        ben.setStrengthValue(10);
        
        String benInfo = ben.toString();
        System.out.println(benInfo);
         
    }
}
