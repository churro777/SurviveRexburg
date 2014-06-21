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
public class GameScreenView extends View{

    public GameScreenView(String promptMessage) {
        super("**title and description of StartDay scenario or whatever scenario is on");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice){
            case '1':
                System.out.println("Choice 1 activates");
                break;
            case '2':
                System.out.println("Choice 2 activates");
                break;
            case '3':
                System.out.println("Choice 3 activates");
                break;
            case '4':
                System.out.println("Choice 4 activates");
                break;
            case '5':
                System.out.println("Choice 5 activates");
                break;
        }
    }
    
}
