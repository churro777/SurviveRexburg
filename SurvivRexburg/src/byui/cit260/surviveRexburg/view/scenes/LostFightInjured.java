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
public class LostFightInjured extends View{

    public LostFightInjured() {
        super(    "\n================================="
                + "\n------Injured But Survived-------"
                + "\n================================="
                + "\n Turns out you're not as good of"
                + "\n a fighter as you thought. On the "
                + "\n plus side you're a survivor. You "
                + "\n made out alive with a few injuries "
                + "\n but at least you made it out alive."
                + "\n================================="
                + "\n"
                + "\n1 - End Day"
                + "\n"
                + "\nM - Open Menu");
    }

    @Override
    public void doAction(String value) {
        
        char choice = value.toUpperCase().charAt(0);
        
        
        switch (choice) {
            case '1': // end day screen
                DayEndScene dayEndScene = new DayEndScene();
                dayEndScene.display();
            case 'M':
                GameMenuView gameMenuView = new GameMenuView();
                gameMenuView.display();
            case 'Q': //quit game
                StartProgramView startProgramView = new StartProgramView();
                startProgramView.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;
            
        }
    }
    
}
