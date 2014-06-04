/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Survivrexburg;

import byui.cit260.surviveRexburg.model.Backpack;
import byui.cit260.surviveRexburg.model.EndUser;
import byui.cit260.surviveRexburg.model.Food;
import byui.cit260.surviveRexburg.model.Game;
import byui.cit260.surviveRexburg.model.GameCharacter;
import byui.cit260.surviveRexburg.model.InventoryItems;
import byui.cit260.surviveRexburg.model.Location;
import byui.cit260.surviveRexburg.model.Map;
import byui.cit260.surviveRexburg.model.MeleeWeapons;
import byui.cit260.surviveRexburg.model.RangedWeapons;
import byui.cit260.surviveRexburg.model.Scenario;
import byui.cit260.surviveRexburg.model.ScenarioLocation;
import byui.cit260.surviveRexburg.model.SpoiledFood;
import byui.cit260.surviveRexburg.model.Survivors;
import byui.cit260.surviveRexburg.model.Zombies;
import byui.cit260.surviveRexburg.view.StartProgramView;


/**
 *
 * @author arturoaguila
 */
public class SurviveRexburg {

    private static Game currentGame = null;
    private static EndUser player = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        SurviveRexburg.currentGame = currentGame;
    }

    public static EndUser getEndUser() {
        return player;
    }

    public static void setEndUser(EndUser player) {
        SurviveRexburg.player = player;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create StartProgramView and start the program
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.startProgram();
    }
    
}//end of class


