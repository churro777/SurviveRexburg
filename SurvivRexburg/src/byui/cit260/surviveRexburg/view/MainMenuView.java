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
            + "\n+--------------MAIN MENU----------------+"
            + "\n|G - Start game                         |"
            + "\n|H - Get Help on how to play the game   |"
            + "\n|S - Save Game                          |"
            + "\n|Q - Quit Game                          |"
            + "\n+---------------------------------------+");
    }
    @Override           
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case 'G': //display the game menu
                GameControl.createNewGame(SurviveRexburg.getEndUser());
                GameScenario gameScenario = new GameScenario();
                gameScenario.display();
                break;
            case 'H': //display the help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.display();
                break;
            case 'S': //save the current game to disk
                ProgramControl.saveGame(SurviveRexburg.getCurrentGame());
                break;
            case 'Q': //exit the program
                StartProgramView startProgramView = new StartProgramView();
                startProgramView.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;
            
        }
    }

    
    




}//end of class
