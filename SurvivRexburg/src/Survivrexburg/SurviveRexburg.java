/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Survivrexburg;

import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.survivRexburg.control.ScenarioControl;
import byui.cit260.surviveRexburg.frames.StartProgramFrame1;
import byui.cit260.surviveRexburg.model.EndUser;
import byui.cit260.surviveRexburg.model.Game;
import byui.cit260.surviveRexburg.view.StartProgramView;


/**
 *
 * @author arturoaguila
 */
public class SurviveRexburg {

    private static Game currentGame = null;
    private static EndUser endUser = null;
    private static ScenarioControl scenarioControl = null;
    private static GameControl gameControl = null;

    
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        SurviveRexburg.currentGame = currentGame;
    }

    public static EndUser getEndUser() {
        return endUser;
    }

    public static void setEndUser(EndUser endUser) {
        SurviveRexburg.endUser = endUser;
    }

    public static ScenarioControl getScenarioControl() {
        return scenarioControl;
    }

    public static void setScenarioControl(ScenarioControl scenarioControl) {
        SurviveRexburg.scenarioControl = scenarioControl;
    }

    public static GameControl getGameControl() {
        return gameControl;
    }

    public static void setGameControl(GameControl gameControl) {
        SurviveRexburg.gameControl = gameControl;
    }

   
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create StartProgramView and start the program
        //StartProgramView startProgramView = new StartProgramView();
        //startProgramView.display();
        
        java.awt.EventQueue.invokeLater(
                new Runnable(){
                    public void run() {
                        StartProgramFrame1 startProgramFrame = new StartProgramFrame1();
                        startProgramFrame.setVisible(true);
                    }
                }
        );
        
    }
    
}//end of class


