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
public class ChooseCharacterView extends View{
    
    public ChooseCharacterView(){
    super("\n"
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
            + "\nType in the letter to choose your character:");
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
                        chooseChar.display();
                        
                    break;
                }
                break;
            case '2': //choosing ben - he's got not charisma
                System.out.println("You chose Ben. He has no Charisma. Are you sure? Y/N");
                switch (choice) {
                    case 'Y':
                        System.out.println("Yes");
                    case 'N':
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.display();
                        
                    break;
                }
                break;
            case '3': //choosing megan
                System.out.println("You chose Megan. Are you sure? Y/N");
                switch (choice) {
                    case 'Y':
                        System.out.println("Yes");
                    case 'N':
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.display();
                        
                    break;
                }
                break;
            case '4': //choosing hayley
                System.out.println("You chose Hayley. Are you sure? Y/N");
                switch (choice) {
                    case 'Y':
                        System.out.println("Yes");
                    case 'N':
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.display();
                        
                    break;
                }
            case 'Q': //exit menu and return to Main Menu
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");   
        }
    
        
    }

    @Override
    public void doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
