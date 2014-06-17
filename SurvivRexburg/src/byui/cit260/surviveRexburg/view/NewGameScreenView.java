/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.survivRexburg.control.ProgramControl;
import byui.cit260.surviveRexburg.model.EndUser;
import byui.cit260.surviveRexburg.model.Game;
import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class NewGameScreenView {
    
    public void NewGameScreen() {
        
        System.out.println(NEWGAME);
        
        //prompt the player to enter their name Retrieve the name of player
        String playersName = this.getPlayersName();
        
        //Create the player object and save it in the ProgramControl class
        EndUser player = ProgramControl.createPlayer(playersName);
        
/*<<<<<<< HEAD
=======
        

        
>>>>>>> origin/master */
        //Display the Main Menu
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMenu();

    }
    
    private final String NEWGAME = "\n"
            + "\n----------------NEW GAME------------------"
            + "\n| Enter the name of your game file.      |"
            + "\n------------------------------------------";
    
    
    private String getPlayersName() {
        boolean valid = false; //indicates if the name has been retrieved
        String playersName = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name ahs not been retrieved
            
            //get the name for the keyboard and trim off the blanks
            playersName = keyboard.nextLine();
            playersName = playersName.trim();
            
            if (playersName.toUpperCase().equals("Q")) { // Quiting?
                return null;
            } 
            
            //if the name is invalid (non-blank and < two characters)
            if (playersName.length() < 2) {
                //display and error
                System.out.println("Invalid name - the name must be non blank "
                                    + "greater than the one character in length");
            }
            else {
                valid = true; //signal that a valid name was entered
            }
           
        }
        
        return playersName; //return the name
    } 
  
 
    
}//end of NewGameScreenView class
