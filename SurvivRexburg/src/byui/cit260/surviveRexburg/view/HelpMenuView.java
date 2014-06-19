/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.view;

import java.util.Scanner;

/**
 *
 * @author arturoaguila
 */
public class HelpMenuView extends View{
   
    public HelpMenuView(){
            super("\n"
            + "\n------------------HELP MENU--------------------"
            + "\n|G - What is the goal of the game?            |"
            + "\n|M - How to move                              |"
            + "\n|E - How to Equip an Item                     |"
            + "\n|Q - Quit to Main Menu                        |"
            + "\n-----------------------------------------------");
    }

    //attributes of the displayStuff functions
    private final String GOALDISPLAY  ="\n"
            + "\n-----------------------------------------------"
            + "\n| The goal of SURVIVE REXBURG is to survive   |"
            + "\n| for 30 days. You will need to fend of       |"
            + "\n| both the living and the dead. But your worst|"
            + "\n| enemy will be starvation. Do your best to   |"
            + "\n| find food wherever you can and make sure to |"
            + "\n| eat it wisely.                              |"
            + "\n-----------------------------------------------";
    private final String MOVEMENTDISPLAY ="\n"
            + "\n-----------------------------------------------"
            + "\n| WE'RE NOT SURE YET. Ask again later. Arrows |"
            + "\n| or something.                               |" 
            + "\n-----------------------------------------------";
            
    private final String EQUIPMENTDISPLAY ="\n"
            + "\n-----------------------------------------------"
            + "\n| IDK man. Ask me later                       |"
            + "\n-----------------------------------------------";
    
    


    
    
    private void doAction(char choice) {
        
        switch (choice) {
            case 'G': //display the goal display
                System.out.println(GOALDISPLAY);
                break;
            case 'M': //display the movementdisplay
                System.out.println(MOVEMENTDISPLAY);
                break;
            case 'E': //save the current equipment display
                System.out.println(EQUIPMENTDISPLAY);
                break;
            case 'Q': //exit menu and return to Main Menu
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
                return;
            default:    
                System.out.println("\n**** Invalid selection *** Try again");
                break;   
        }
    //end doAction function    
    }

    @Override
    public void doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
