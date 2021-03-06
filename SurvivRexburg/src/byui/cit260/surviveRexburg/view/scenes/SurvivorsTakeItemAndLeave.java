/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import byui.cit260.surviveRexburg.view.GameMenuView;
import byui.cit260.surviveRexburg.view.StartProgramView;
import byui.cit260.surviveRexburg.view.View;

/**
 *
 * @author arturoaguila
 */
public class SurvivorsTakeItemAndLeave extends View{

    public SurvivorsTakeItemAndLeave() {
        super(    "\n================================="
                + "\n-------Survivors Thank You-------"
                + "\n================================="
                + "\n The group thanks you and go on"
                + "\n their way to try to survive"
                + "\n this terrible world."
                + "\n================================="
                + "\n1 - EndDay"
                + "\n"
                + "\nM - Open Menu");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case '1': //Start game - FirstDayView
                DayEndScene dayEndScene = new DayEndScene();
                dayEndScene.display();
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
