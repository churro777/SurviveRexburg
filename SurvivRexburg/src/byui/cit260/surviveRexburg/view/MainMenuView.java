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
import java.util.Scanner;

/**
 *
 * @author carissa888
 */
public class MainMenuView extends View{
    
    public MainMenuView() {

     super("\n"
            + "\n---------------MAIN MENU-----------------"
            + "\n|G - Start game                         |"
            + "\n|H - Get Help on how to play the game   |"
            + "\n|S - Save Game                          |"
            + "\n|E - Exit                               |"
            + "\n-----------------------------------------");
    }
               
    private void doAction(char choice) {
        
        switch (choice) {
            case 'G': //display the game menu
                GameControl.createNewGame(SurviveRexburg.getEndUser());
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.displayMenu();
                break;
            case 'H': //display the help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.displayMenu();
                break;
            case 'S': //save the current game to disk
                ProgramControl.saveGame(SurviveRexburg.getCurrentGame());
                break;
            case 'E': //exit the program
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;
            
        }
    }

    
    public static void startNewGame(){
            //creates instance of GameControl and calls function createNewGame which creates the game
            GameControl gameControl = new GameControl();
            GameControl.createNewGame(null);
    }



}//end of class
