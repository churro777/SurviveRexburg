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
public class MapView {
    private final String MAP = "\n"
            + "\n------MAP-------"
            + "\n****************"
            + "\n|      |       |"
            + "\n|  01  |  02   |"
            + "\n|      |       |"
            + "\n****************"
            + "\n|      |       |"
            + "\n|  03  |  04   |"
            + "\n|      |       |"
            + "\n****************"
            + ""
            + "Q - Quit to Game Menu";
    
    void displayMenu() {
        char selection = ' ';
        do{
            
            System.out.println(MAP);       // display the main menu
            
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

    private void doAction(char selection) {
         System.out.println("\n"
                 + "\n **** Open GameplayScreen *****");
    }
    
}
