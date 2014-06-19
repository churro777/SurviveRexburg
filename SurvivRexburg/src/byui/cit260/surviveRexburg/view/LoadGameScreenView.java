/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class LoadGameScreenView {
    
    public LoadGameScreenView() {
    
    super("\n"
            + "\n --------------LOAD GAME----------------"
            + "\n|      Pick a Saved Game to Load        |"
            + "\n| *** Display SavedGames ***            |"
            + "\n| 1 - **Game Name 1                     |"
            + "\n| 2 - **Game Name 2                     |"
            + "\n| 3 - **Game Name 3                     |"
            + "\n| Q - Quit back to Start Menu           |"
            + "\n ----------------------------------------");
    
    }
    
    public static void getSavedGame(){
        System.out.println("\n **** getSavedGame function happens ****");
        
    }


    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case '1': //display the movementdisplay
                System.out.println("**** Load first saved game ****");
                break;
            case '2': //save the current equipment display
                System.out.println("**** Load second saved game ****");
                break;
            case '3': //save the current equipment display
                System.out.println("**** Load third saved game ****");
                break;
            case 'Q': //exit menu and return to Main Menu
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
    }
    
    
    
    
}//end class
