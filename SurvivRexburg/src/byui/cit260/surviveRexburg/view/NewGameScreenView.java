/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import Survivrexburg.SurviveRexburg;
import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.survivRexburg.control.ProgramControl;
import byui.cit260.surviveRexburg.model.EndUser;
import byui.cit260.surviveRexburg.model.Game;
import java.util.Scanner;

/**
 *
 * @author arturoaguila
 * 
 * 
 * 
 * 
 */
public class NewGameScreenView extends View{
   
    public NewGameScreenView(){
    super("\n"
        + "\n----------------NEW GAME------------------"
        + "\n| Enter the name of your game file.      |"
        + "\n------------------------------------------");
    }

    @Override
    public void doAction(String value){
        
        //Create the player object and save it in the ProgramControl class
        EndUser player = ProgramControl.createPlayer(value);
        SurviveRexburg.setEndUser(player);
        
        //Display the Main Menu
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
        
        
        
    }

    
}//end of NewGameScreenView class
