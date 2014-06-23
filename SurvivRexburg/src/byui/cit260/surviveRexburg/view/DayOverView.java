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
public class DayOverView extends View{

    public DayOverView() {
        super    ("\n================DAY OVER=================="
                + "\n|                                        |"
                + "\n| The day is over. Survive the next day  |"
                + "\n|                                        |"
                + "\n==========================================");
    }

    @Override
    public void doAction(String value) {
        
      char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case '1': //display the movementdisplay
                System.out.println("**** Sleep ****");
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
//end of DayOverView class
