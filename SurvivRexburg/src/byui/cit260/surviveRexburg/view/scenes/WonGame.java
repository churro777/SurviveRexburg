/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import byui.cit260.survivRexburg.control.GameControl;
import byui.cit260.surviveRexburg.view.GameMenuView;
import byui.cit260.surviveRexburg.view.StartDayView;
import byui.cit260.surviveRexburg.view.StartProgramView;
import byui.cit260.surviveRexburg.view.View;

/**
 *
 * @author arturoaguila
 */
public class WonGame extends View{

    public WonGame() {
        super(    "\n================================="
                + "\n--------Help Has Arrived!!!------"
                + "\n================================="
                + "\n You survived long enough for"
                + "\n help to arrive and save the town"
                + "\n from chaos."
                + "\n"
                + "\n And..."
                + "\n"
                + "\n YOU WON THE GAME!!!!!!!!!!!!!!!!"
                + "\n================================="
                + "\n"
                + "\n1 - Play Again"
                + "\n");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case '1': //Start game - FirstDayView
                StartProgramView startGame = new StartProgramView();
                startGame.display();
                break;
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
