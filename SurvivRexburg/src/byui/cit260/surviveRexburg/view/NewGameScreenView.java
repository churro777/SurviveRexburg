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
        
        //Create the EndUser object (named 'player') and save it in the ProgramControl class
        EndUser player = ProgramControl.createPlayer(value);
        SurviveRexburg.setEndUser(player);
        
        System.out.println("\n***EndUser object created***"
                         + "\n***EndUser saved in ProgramControl class***");
        
        //creates instance of GameControl and calls function createNewGame which creates the game
        NewGameScreenView.startNewGame();
        
        System.out.println("****New game created****");
        
        //Display the ChooseCharacterView
        ChooseCharacterView chooseCharacter = new ChooseCharacterView();
        chooseCharacter.display();
            
    }
    
    
    public static void startNewGame(){
            //creates instance of GameControl and calls function createNewGame which creates the game
            GameControl gameControl = new GameControl();
            GameControl.createNewGame(null);
    }

    
}//end of NewGameScreenView class
