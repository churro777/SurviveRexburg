/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

/**
 *
 * @author arturoaguila
 */
public class GameScenario extends View{

    public GameScenario() {
        super    ("\n***scenario title"
                + "\n------------------------"
                + "\n***scenario description"
                + "\n------------------------"
                + "\n1- Choice 1"
                + "\n2- Choice 2"
                + "\n3- Choice 3"
                + "\n4- Choice 4"
                + "\n5- Choice 5");
        
    }



    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case '1': //display the movementdisplay
                System.out.println("**** First choice ****");
                break;
            case '2': //save the current equipment display
                System.out.println("**** Second choice ****");
                break;
            case '3': //save the current equipment display
                System.out.println("**** Third choice ****");
                break;
            case '4':
                System.out.println("**** Fourth choice ****");
                break;
            case '5':
                System.out.println("**** Nothing is there****");
                break;
            case 'M': //exit menu and return to Main Menu
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
        
        
    }
    
}

