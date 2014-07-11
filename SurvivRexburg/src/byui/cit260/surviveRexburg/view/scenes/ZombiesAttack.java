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
public class ZombiesAttack extends View{

    public ZombiesAttack() {
        super(    "\n================================="
                + "\n-----------ZOMBIES!!!------------"
                + "\n================================="
                + "\n ZOMBIES!!!!!"
                + "\n ZOMBIES!!!!!"
                + "\n ZOMBIES!!!!!"
                + "\n================================="
                + "\n1 - Run"
                + "\n2 - Fight"
                + "\n"
                + "\nM - Open Menu");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case '1': //Start game - FirstDayView
                SurviveRexburg.getScenarioControl().decideRunAwayPossibility();
                break;
            case '2':
                SurviveRexburg.getScenarioControl().decideFightZombiesPossibility();
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
