/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

/**
 *
 * @author carissa888
 */
public class GameOverView extends View{

    public GameOverView() {
        super  ("\n================GAME OVER================="
                + "|                                        |"
                + "| You survived ___ days. Would you want  |"
                + "| to play again?                         |"
                + "|                                        |"
              + "\n==========================================");
    }


    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case '1': //display the movementdisplay
                System.out.println("**** New Game ****");
                break;
            case '2': //save the current equipment display
                System.out.println("**** Load Game ****");
                break;
            case '3': //save the current equipment display
                System.out.println("**** Quit ****");
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

     

