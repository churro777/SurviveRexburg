/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.surviveRexburg.view;

import Survivrexburg.SurviveRexburg;
import byui.cit260.survivRexburg.control.Constants;
import java.util.Scanner;

/**
 *
 * @author carissa888
 */
public class ChooseCharacterView extends View {
//    private String charChoice;

    public ChooseCharacterView() {
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
                + "\n");
    }

    @Override
    public void doAction(String value) {

        char choice = value.toUpperCase().charAt(0);

        switch (choice) {
            case '1': //display "Are you sure?"
                System.out.println("You chose Bing. Are you sure? Y/N");

                String charChoiceOne = this.getChoice();

                switch (charChoiceOne) {
                    case "Y":
                        System.out.println("Okay. You chose Bing.");
                        System.out.println("***Assign Bing to EndUser****");
                        SurviveRexburg.getEndUser().setGameCharacter(SurviveRexburg.getCurrentGame().getGameCharacters()[Constants.BING]);
                        MainMenuView mainMenuView = new MainMenuView();
                        mainMenuView.display();
                        break;
                    case "N":
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.display();
                        break;
                }

                break;
            case '2': //choosing ben - he's got not charisma
                System.out.println("You chose Ben. Are you sure, he only has 1 Charisma? Y/N");

                String charChoiceTwo = this.getChoice();

                switch (charChoiceTwo) {
                    case "Y":
                        System.out.println("Okay. You chose Ben.");
                        System.out.println("***Assign Ben to EndUser****");
                        SurviveRexburg.getEndUser().setGameCharacter(SurviveRexburg.getCurrentGame().getGameCharacters()[Constants.BEN]);
                        MainMenuView mainMenuView = new MainMenuView();
                        mainMenuView.display();
                        break;
                    case "N":
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.display();
                        break;
                }

                break;
            case '3': //choosing megan
                System.out.println("You chose Megan. Good choice. Y/N");

                String charChoiceThree = this.getChoice();

                switch (charChoiceThree) {
                    case "Y":
                        System.out.println("Okay. You chose Megan.");
                        System.out.println("***Assign Megan to EndUser****");
                        SurviveRexburg.getEndUser().setGameCharacter(SurviveRexburg.getCurrentGame().getGameCharacters()[Constants.MEGAN]);
                        MainMenuView mainMenuView = new MainMenuView();
                        mainMenuView.display();
                        break;
                    case "N":
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.display();
                        break;
                }

                break;
            case '4': //choosing hayley
                System.out.println("You chose Hayley. Good luck. Y/N");

                String charChoiceFour = this.getChoice();

                switch (charChoiceFour) {
                    case "Y":
                        System.out.println("Okay. You chose Hayley.");
                        System.out.println("***Assign Hayley to EndUser****");
                        SurviveRexburg.getEndUser().setGameCharacter(SurviveRexburg.getCurrentGame().getGameCharacters()[Constants.HAYLEY]);
                        MainMenuView mainMenuView = new MainMenuView();
                        mainMenuView.display();
                        break;
                    case "N":
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.display();
                        break;
                }
                break;
            case '5':
                System.out.println("Cheat Mode? Y/N");

                String charCheatChoice = this.getChoice();

                switch (charCheatChoice) {
                    case "Y":
                        System.out.println("Woah...cheat mode. You S.O.B.");
                        System.out.println("***cheat mode Nathan****");
                        SurviveRexburg.getEndUser().setGameCharacter(SurviveRexburg.getCurrentGame().getGameCharacters()[Constants.NATE]);
                        MainMenuView mainMenuView = new MainMenuView();
                        mainMenuView.display();
                        break;
                    case "N":
                        ChooseCharacterView chooseChar = new ChooseCharacterView();
                        chooseChar.display();
                        break;
                }
                break;
            case 'Q': //exit menu and return to Main Menu
                StartProgramView startProgramView = new StartProgramView();
                startProgramView.display();
                return;
            default:
                System.out.println("\n**** Invalid selection *** Try again");
        }
    }

    public String getChoice() {

        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        boolean valid = false; //indicates if the name has been retrieved
        String charChoice = null;

        while (!valid) { //while a valid name ahs not been retrieved

            //get the name for the keyboard and trim off the blanks
            System.out.println("\t\nEnter your selection below:");

            charChoice = keyboard.nextLine();
            charChoice = charChoice.trim();

            if (charChoice.length() < 1) { // exiting?
                System.out.println("\n*** Invalid selection *** Try again");
                continue;
            }

            break;
        }
        return charChoice; //return the input
    }

}//end of ChooseCharacterView class
