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
public class SurvivorsGiveItem extends View{

    public SurvivorsGiveItem() {
        super(    "\n================================="
                + "\n--Survivors Offer You Supplies---"
                + "\n================================="
                + "\n A group of survivors aregoing to"
                + "\n give you supplies. We should"
                + "\n help each other in these time"
                + "\n of need."
                + "\n================================="
                + "\n1 - Accept Supplies"
                + "\n2 - Refuse Supplies"
                + "\n"
                + "\nM - Open Menu");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case '1': //Start game - FirstDayView
                AcceptItemFromSurvivors acceptItem = new AcceptItemFromSurvivors();
                acceptItem.display();
                break;
            case '2':
                RefuseItemFromSurvivors refuseItem = new RefuseItemFromSurvivors();
                refuseItem.display();
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
