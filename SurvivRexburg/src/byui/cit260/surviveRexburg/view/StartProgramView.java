/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;




import byui.cit260.survivRexburg.control.ProgramControl;
import byui.cit260.surviveRexburg.model.EndUser;
import java.util.Scanner;
/**
 *
 * @author carissa888
 */
public class StartProgramView {
    
    
    private final String START = "\n"
            + "\n**************************"
            + "\n| 1 - New Game           |"
            + "\n| 2 - Load Game          |"
            + "\n**************************";
    
    
    
    public void startProgram() {
        
        //Display the banner screen
        this.displayBanner();
        
        //Display a personalized welcome message
        this.displayWelcomeMessage();
        
        this.displayStartMenu();

    }

    public void displayWelcomeMessage() {
        System.out.println("\n\n=========================================================");
        System.out.println("\tWelcome to SURVIVE REXBURG ");
        System.out.println("\tWe hope you have a lot of fun trying to survive!");
        System.out.println("=========================================================");
                
        
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
    
    void displayStartMenu() {
        char selection = ' ';
        do{
            
            System.out.println(START);       // display the main menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0);    //get first charcter of string
            
            this.doAction(selection);       // do action based on selection
        } 
        while (selection != 'Q');         // an selection is not "EXIT"
    }
    
    private String getInput() {
        boolean valid = false; //indicates if the name has been retrieved
        String input = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name ahs not been retrieved
            
            //get the name for the keyboard and trim off the blanks
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.toUpperCase().equals("Q")) { // exiting?
                return null;
            }
            
                valid = true; //signal that a valid name was entered
        }
        return input; //return the input
    }
    
    private void doAction(char choice) {
        
        switch (choice) {
            case '1': //display the movementdisplay
                NewGameScreenView newGame = new NewGameScreenView();
                newGame.NewGameScreen();
                break;
            case '2': //save the current equipment display
                LoadGameScreenView loadGame = new LoadGameScreenView();
                loadGame.displayMenu();
                break;
            case 'Q': //exit menu and return to Main Menu
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
    }
    
    
}//end class
