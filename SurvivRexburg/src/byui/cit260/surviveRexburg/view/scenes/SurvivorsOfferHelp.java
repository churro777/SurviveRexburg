/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.view.StartDayView;
import byui.cit260.surviveRexburg.view.StartProgramView;
import byui.cit260.surviveRexburg.view.View;

/**
 *
 * @author arturoaguila
 */
public class SurvivorsOfferHelp extends View{

    public SurvivorsOfferHelp() {
        super(    "\n================================="
                + "\n----Survivors Offer You Help-----"
                + "\n================================="
                + "\n You are approached by a group of"
                + "\n survivors. They are willing to"
                + "\n help a fellow survivor."
                + "\n================================="
                + "\n1 - Accept Help"
                + "\n2 - Refuse Help"
                + "\n3 - Fight"
                + "\n"
                + "\nM - Open Menu");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        switch (choice) {
            case '1':
                SurviveRexburg.getScenarioControl().decideAcceptHelpPossibility();
                break;
            case '2':
                SurviveRexburg.getScenarioControl().decideDenyhelpPossibility();
                break;
            case '3':
                SurviveRexburg.getScenarioControl().decideFightSurvivorsPossibility();
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
