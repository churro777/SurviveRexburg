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
class HelpMenuView {
    private final String HELPMENU = "\n"
            + "\n------------------HELP MENU--------------------"
            + "\n|G - What is the goal of the game?            |"
            + "\n|M - How to move                              |"
            + "\n|E - How to Equip an Item                     |"
            + "\n|Q - Quit to Main Menu                        |"
            + "\n-----------------------------------------------";

    //attributes of the displayStuff functions
    private final String GOALDISPLAY  ="\n"
            + "\n-----------------------------------------------"
            + "\n| The goal of SURVIVE REXBURG is to survive   |"
            + "\n| for 30 days. You will need to fend of       |"
            + "\n| both the living and the dead. But your worst|"
            + "\n| enemy will be starvation. Do your best to   |"
            + "\n| find food wherever you can and make sure to |"
            + "\n| eat it wisely.                              |"
            + "\n-----------------------------------------------";
    private final String MOVEMENTDISPLAY ="\n"
            + "\n-----------------------------------------------"
            + "\n| WE'RE NOT SURE YET. Ask again later. Arrows |"
            + "\n| or something.                               |" 
            + "\n-----------------------------------------------";
            
    private final String EQUIPMENTDISPLAY ="\n"
            + "\n-----------------------------------------------"
            + "\n| IDK man. Ask me later                       |"
            + "\n-----------------------------------------------";
    
    public void displayMenu() {
        char selection = ' ';
        do{
            
            System.out.println(HELPMENU);       // display the main menu
            
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
            case 'G': //display the goal display
                System.out.println(GOALDISPLAY);
                break;
            case 'M': //display the movementdisplay
                System.out.println(MOVEMENTDISPLAY);
                break;
            case 'E': //save the current equipment display
                System.out.println(EQUIPMENTDISPLAY);
                break;
            case 'Q': //exit menu and return to Main Menu
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.displayMenu();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
    //end doAction function    
    }
    
}
