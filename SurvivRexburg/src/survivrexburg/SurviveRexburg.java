/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package survivrexburg;

import byui.cit260.surviveRexburg.model.Game;

/**
 *
 * @author arturoaguila
 */
public class SurviveRexburg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        
        game.setDaysPassed(20);
        game.setSavedGameName("Arty");

        String gameInfo = game.toString();
        System.out.println(gameInfo);
    
    }
}
