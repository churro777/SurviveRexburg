/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.view.GameMenuView;
import byui.cit260.surviveRexburg.view.StartProgramView;
import byui.cit260.surviveRexburg.view.View;

/**
 *
 * @author arturoaguila
 */
public class SurvivorsListen extends View{

    public SurvivorsListen() {
        super(    "\n================================="
                + "\n-----Survivors Listen to You-----"
                + "\n---------------------------------"
                + "\n Looks like the group that was"
                + "\n attacking you is gonna listen "
                + "\n to you."
                + "\n================================="
                + "\n1 - Offer a Random Item"
                + "\n"
                + "\nM - Open Menu");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case '1': //Start game - FirstDayView
                SurviveRexburg.getScenarioControl().decideOfferingPossibility();
                break;
            case 'M':
                GameMenuView gameMenuView = new GameMenuView();
                gameMenuView.display();
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
