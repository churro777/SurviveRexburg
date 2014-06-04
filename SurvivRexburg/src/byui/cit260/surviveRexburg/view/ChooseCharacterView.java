/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import java.util.Scanner;

/**
 *
 * @author carissa888
 */
public class ChooseCharacterView {
    
    private final String CHOOSECHAR = "\n"
            + "\n-------------CHOOSE YOUR CHARACTER------------"
            + "\n|1 - Bing                                    |"
            + "\n|Strength: 6, Speed: 8, Charisma: 3, Luck: 3 |"
            + "\n----------------------------------------------"
            + "\n|2 - Ben                                     |"
            + "\n|Strength: 10, Speed: 5, Charisma: 1, Luck: 4|"
            + "\n----------------------------------------------"
            + "\n|3 - Megan                                   |"
            + "\n|Stength: 6, Speed: 2, Charisma: 8, Luck: 4  |"
            + "\n----------------------------------------------"
            + "\n|4 - Hayley                                  |"
            + "\n|Stength: 1, Speed: 5, Charisma: 6, Luck: 8  |"
            + "\n----------------------------------------------"
            + "\n"
            + "\nType in the letter to choose your character:";
    
     void displayChooseCharacter() {
        
        char selection = ' ';
        do{
            
            System.out.println(CHOOSECHAR);       // display the main menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0);    //get first charcter of string
            
            this.doAction(selection);       // do action based on selection
        } while (selection != 'E');         // an selection is not "EXIT"
    }

    

    private String getInput() {
       boolean valid = false; //indicates if the name has been retrieved
        String input = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name ahs not been retrieved
            
            //get the name for the keyboard and trim off the blanks
            input = keyboard.nextLine();
            input = input.trim();
            
            
                valid = true; //signal that a valid name was entered
        }
        return input; //return the input
    }
    
    
      private void doAction(char choice) {
          
           switch (choice) {
            case '1': //display "Are you sure?"
                System.out.println("You chose Bing. Are you sure? Y/N");
                switch (choice) {
                    case 'Y':
                        System.out.println("Yes");
                    case 'N':
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.displayChooseCharacter();
                        
                    break;
                }
                break;
            case '2': //save the current equipment display
                System.out.println("You chose Ben. He has no Charisma. Are you sure? Y/N");
                switch (choice) {
                    case 'Y':
                        System.out.println("Yes");
                    case 'N':
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.displayChooseCharacter();
                        
                    break;
                }
                break;
            case '3': //save the current equipment display
                System.out.println("You chose Megan. Are you sure? Y/N");
                switch (choice) {
                    case 'Y':
                        System.out.println("Yes");
                    case 'N':
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.displayChooseCharacter();
                        
                    break;
                }
                break;
            case '4': //exit menu and return to Main Menu
                System.out.println("You chose Hayley. Are you sure? Y/N");
                switch (choice) {
                    case 'Y':
                        System.out.println("Yes");
                    case 'N':
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.displayChooseCharacter();
                        
                    break;
                }
            case 'Q': //exit menu and return to Main Menu
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.displayMenu();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
    
        
    }
    
    
    
    
}
