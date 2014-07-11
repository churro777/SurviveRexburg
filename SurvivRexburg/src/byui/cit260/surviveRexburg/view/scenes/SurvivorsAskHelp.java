/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view.scenes;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.view.StartProgramView;
import byui.cit260.surviveRexburg.view.View;

/**
 *
 * @author arturoaguila
 */
public class SurvivorsAskHelp extends View{

    public SurvivorsAskHelp() {
        super(    "\n================================="
                + "\n-----Survivors Ask For Help------"
                + "\n---------------------------------"
                + "\n You are approached by a group of"
                + "\n survivors. They ask for help."
                + "\n================================="
                + "\n1 - Help Them"
                + "\n2 - Refuse to Help"
                + "\n3 - Run Away"
                + "\n4 - Fight"
                + "\n"
                + "\nM - Open Menu");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case '1': //Start game - FirstDayView
                //SurviveRexburg.getScenarioControl().
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
