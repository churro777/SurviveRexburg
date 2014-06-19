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
public class StartProgramView extends View{
    
    public StartProgramView(){
        super("\n"
            + "\n**************************************************************"            
            + "\n*                                                            *"
            + "\n*  In the game SURVIVE REXBURG you play as one of            *"
            + "\n* four different characters, Bing, Ben, Megan or Hayley,     *"
            + "\n* trying to survive for 30 days during the zombie apocalypse *"
            + "\n* in Rexburg, Idaho. You are on your own trying to defeat    *"
            + "\n* the odds against zombies, other survivors, and hunger.     *"
            + "\n* Each different character has different skill levels.       *"
            + "\n* Each different skill applies to a different                *"
            + "\n* aspect of the game.                                        *"
            + "\n*                                                            *"
            + "\n* When you start the game, you are at your apartment and     *"
            + "\n* have three choices to choose from: Explore the Area,       *"
            + "\n* Fortify your Apartment, or Do Nothing. A complex equation  *"
            + "\n* will use how far into the 30 days you are and your skill   *"
            + "\n* levels to help pick a random scenario. That scenario will  *"
            + "\n* then lead to more choices that will determine if you live  *"
            + "\n* or die that day.                                           *"
            + "\n*                                                            *"
            + "\n* If you survive for 30 days you win the game!               *"
            + "\n*                                                            *"
            + "\n**************************************************************"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n========================================================="
            + "\tWelcome to SURVIVE REXBURG "
            + "\tWe hope you have a lot of fun trying to survive!"
            + "\n========================================================="
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n**************************"
            + "\n| 1 - New Game           |"
            + "\n| 2 - Load Game          |"
            + "\n**************************");
    }
    
   
    
    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case '1': //display the NewGame display
                NewGameScreenView newGame = new NewGameScreenView();
                newGame.NewGameScreen();
                break;
            case '2': //save the LoadGame display
                LoadGameScreenView loadGame = new LoadGameScreenView();
                loadGame.display();
                break;
            case 'Q': //exit menu and return to Main Menu
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
    }

   
    
    
}//end class
