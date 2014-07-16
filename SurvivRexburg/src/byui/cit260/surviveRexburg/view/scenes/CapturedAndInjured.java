/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import Survivrexburg.SurviveRexburg;
import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.surviveRexburg.view.GameMenuView;
import byui.cit260.surviveRexburg.view.StartProgramView;
import byui.cit260.surviveRexburg.view.View;
import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class CapturedAndInjured {
    
    int health = SurviveRexburg.getEndUser().getHealth();
    

    private final String CAPTURED_AND_INJURED =
            (     "\n================================="
                + "\n------Captured and Injured-------"
                + "\n Health " + health
                + "\n================================="
                + "\n You tried to run but just werent"
                + "\n fast enough. The survivors caught"
                + "\n you and roughed you up."
                + "\n"
                + "\n At least you survived."
                + "\n================================="
                + "\n1 - End Day"
                + "\n"
                + "\nM - Open Menu");
    

    public void display() {
        String value;
        do {
            
            
            System.out.println(CAPTURED_AND_INJURED);       // display the main menu
            
            value = this.getInput(); // get the user's selection
            this.doAction(value);       // do action based on selection
        } 
        while (!value.equals("Q"));         // an selection is not "EXIT"
    }
    
    public String getInput() {
        
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        boolean valid = false; //indicates if the name has been retrieved
        String selection = null;
        
        
        while (!valid) { //while a valid name has not been retrieved
            
            //get the name for the keyboard and trim off the blanks
            System.out.println("\t\nEnter your selection below:");
            
            
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() < 1) { // exiting?
                System.out.println("\n*** Invalid selection *** Try again");
                continue;
            }
            
            break;
        }
        return selection; //return the input
    }
    
    public void doAction(String value) {
        
        GameControl.decreaseHealth();
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case '1': //Start game - FirstDayView
                DayEndScene dayEndScene = new DayEndScene();
                dayEndScene.display();
                break;
            case 'M': //Open Menu
                GameMenuView gameMenuview = new GameMenuView();
                gameMenuview.display();
            case 'Q': //exit the program
                StartProgramView startProgramView = new StartProgramView();
                startProgramView.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;
            
        }
    }
    
}
