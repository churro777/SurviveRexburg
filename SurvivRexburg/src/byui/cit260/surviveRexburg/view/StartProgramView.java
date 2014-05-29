/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

/**
 *
 * @author carissa888
 */
public class StartProgramView {
    
    public void startProgram() {
        
        //Display the banner screen
        this.displayBanner();
        
        //Get the players name
        //prompt the player to enter their name Retrieve the name of player
        String playersName = this.getPlayersName();
        if (playersName == null) // user wants to quit
            return; //exits the game
        
        //Create the player object and save it in the ProgramControl class
        Player player = ProgramControl.createPlayer(playersName);
        
        //Display a personalized welcome message
        this.displayWelcomeMessage(player);
        
        //Display the Main Menu
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMenu();
        
        //IF no name was entered THEN
        //  RETURN
        //ENDIF
        
        //Create a new player
        //DISPLAY a customized welcome message
        //DISPLAY the main menu
        
    
    }
    
    
    public void displayBanner() {
        
        System.out.println("\n\n*************************************************************");
                
        System.out.println("*                                                            *"
                       + "\n*  In the game SURVIVE REXBURG you play as one of            *"
                       + "\n* four different characters, Bing, Ben, Megan or Hayley,     *"
                       + "\n* trying to survive for 30 days during the zombie apocalypse *"
                       + "\n* in Rexburg, Idaho. You are on your own trying to defeat    *"
                       + "\n* the odds against zombies, other survivors, and hunger.     *"
                       + "\n* Each different character has different skill levels.       *"
                       + "\n* Each different skill applies to a different                *"
                       + "\n* aspect of the game.                                        *");

        System.out.println("*                                                            *"
                       + "\n* When you start the game, you are at your apartment and     *"
                       + "\n* have three choices to choose from: Explore the Area,       *"
                       + "\n* Fortify your Apartment, or Do Nothing. A complex equation  *"
                       + "\n* will use how far into the 30 days you are and your skill   *"
                       + "\n* levels to help pick a random scenario. That scenario will  *"
                       + "\n* then lead to more choices that will determine if you live  *"
                       + "\n* or die that day.                                           *");
        
        System.out.println("*                                                            *"
                       + "\n* If you survive for 30 days you win the game!               *"
                       + "\n*                                                            *");
        
        System.out.println("**************************************************************");
  
    }
    
}
