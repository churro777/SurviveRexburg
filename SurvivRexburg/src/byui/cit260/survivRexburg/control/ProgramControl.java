/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.model.EndUser;
import byui.cit260.surviveRexburg.model.Game;

/**
 *
 * @author arturoaguila
 */
public class ProgramControl {

    public static EndUser createPlayer(String playersName) {
        System.out.println("\n**** createPlayer function called ****");
        EndUser player = new EndUser();
        player.setEndUserName(playersName);
        
        SurviveRexburg.setPlayer(player);
        
        return player;
    
    }

    public static void saveGame(Game currentGame) {
        System.out.println("\n**** saveGame stub function called ****");
    }
//end of class
}
