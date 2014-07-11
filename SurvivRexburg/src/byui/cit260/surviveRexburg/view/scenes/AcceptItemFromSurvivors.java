/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import byui.cit260.surviveRexburg.view.GameMenuView;
import byui.cit260.surviveRexburg.view.StartDayView;
import byui.cit260.surviveRexburg.view.StartProgramView;
import byui.cit260.surviveRexburg.view.View;

/**
 *
 * @author arturoaguila
 */
public class AcceptItemFromSurvivors extends View{

    public AcceptItemFromSurvivors() {
        super(    "\n================================="
                + "\n-----You Accept The Supplies-----"
                + "\n================================="
                + "\n You got some supplies! Make sure"
                + "\n you make them last. What a great"
                + "\n day. Time for sleep."
                + "\n================================="
                + "\n1 - End Day"
                + "\n"
                + "\nM - Open Menu");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case '1': //Start game - FirstDayView
                StartDayView startDay = new StartDayView();
                startDay.display();
                break;
            case 'M': //Open Menu
                GameMenuView gameMenuview = new GameMenuView();
                gameMenuview.display();
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
