/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.model.Location;
import byui.cit260.surviveRexburg.model.Map;
import byui.cit260.surviveRexburg.model.Scenario;
import byui.cit260.surviveRexburg.view.scenes.CapturedAndInjured;
import byui.cit260.surviveRexburg.view.scenes.CapturedInjuredAndRobbed;
import byui.cit260.surviveRexburg.view.scenes.EscapeAndNewLocation;
import byui.cit260.surviveRexburg.view.scenes.KilledBySurvivors;
import byui.cit260.surviveRexburg.view.scenes.NothingHappensScene;
import byui.cit260.surviveRexburg.view.scenes.ScavengeFoundItem;
import byui.cit260.surviveRexburg.view.scenes.ScavengeNoItem;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsAskHelp;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsAttack;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsGiveItem;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsOfferHelp;
import byui.cit260.surviveRexburg.view.scenes.ZombiesAttack;
import java.util.Arrays;

/**
 *
 * @author arturoaguila
 */
public class ScenarioControl {
    private int scenarioValue;
    private int randomLuckValue;    
            
    static Scenario[] createOneWayScenariosList() {
        Scenario[] oneWayScenarios = new Scenario[Constants.ONE_WAY_SCENARIOS];
        
        //Always happen every day
        //#0
        Scenario startDay = new Scenario();
        startDay.setScenarioName("New Day");
        startDay.setScenarioDescription("The start of a new day.");
        startDay.setActive(true);
        startDay.setScenarioValue(100);
        startDay.setChoiceOne("Stay In Current Location");
        startDay.setChoiceTwo("Fortify");
        startDay.setChoiceThree("Explore");
        startDay.setChoiceFour("Scavenge Current Location");
        startDay.setChoiceFive(null);
        oneWayScenarios[Constants.DAY_STARTS] = startDay;
        
        //#1
        Scenario dayEnds = new Scenario();
        dayEnds.setScenarioName("Day Ends");
        dayEnds.setScenarioDescription("You have survived today. Now time to rest for tomorrow");
        dayEnds.setActive(false);
        dayEnds.setScenarioValue(100);
        dayEnds.setChoiceOne("Sleep");
        dayEnds.setChoiceTwo(null);
        dayEnds.setChoiceThree(null);
        dayEnds.setChoiceFour(null);
        dayEnds.setChoiceFive(null);
        oneWayScenarios[Constants.DAY_ENDS] = dayEnds;
        
        
        
        //OUTCOME Survivors Offer Help > Give you Item > You accept Item CHOICE
        //#9
        Scenario dayEndsAndAcceptHelpAcceptItem = new Scenario();
        dayEndsAndAcceptHelpAcceptItem.setScenarioName
        ("You Accept Help From Survivors And They Give You Item");
        dayEndsAndAcceptHelpAcceptItem.setScenarioDescription
                ("\nThe survivors give you ____ and leave"                
                + "\non their way. The day is over.");
        dayEndsAndAcceptHelpAcceptItem.setActive(false);
        dayEndsAndAcceptHelpAcceptItem.setScenarioValue(0);
        dayEndsAndAcceptHelpAcceptItem.setChoiceOne("Sleep");
        dayEndsAndAcceptHelpAcceptItem.setChoiceTwo(null);
        dayEndsAndAcceptHelpAcceptItem.setChoiceThree(null);
        dayEndsAndAcceptHelpAcceptItem.setChoiceFour(null);
        dayEndsAndAcceptHelpAcceptItem.setChoiceFive(null);
        oneWayScenarios[Constants.DAY_ENDS_ACCEPT_HELP_ACCEPT_ITEM] = dayEndsAndAcceptHelpAcceptItem;
        
        //OUTCOME Survivors Offer Help > Give you Item > You deny the Item CHOICE
        //#10
        Scenario dayEndsAndAcceptHelpDenyItem = new Scenario();
        dayEndsAndAcceptHelpDenyItem.setScenarioName
        ("You Accept Help From Survivors But Deny Their Item");
        dayEndsAndAcceptHelpDenyItem.setScenarioDescription
                ("\nThe Survivors offered to give you an"
                + "\nitem but you refuse their help. They"
                + "\nleave in peace. The day is over.");
        dayEndsAndAcceptHelpDenyItem.setActive(false);
        dayEndsAndAcceptHelpDenyItem.setScenarioValue(0);
        dayEndsAndAcceptHelpDenyItem.setChoiceOne("Sleep");
        dayEndsAndAcceptHelpDenyItem.setChoiceTwo(null);
        dayEndsAndAcceptHelpDenyItem.setChoiceThree(null);
        dayEndsAndAcceptHelpDenyItem.setChoiceFour(null);
        dayEndsAndAcceptHelpDenyItem.setChoiceFive(null);
        oneWayScenarios[Constants.DAY_ENDS_ACCEPT_HELP_DENY_ITEM] = dayEndsAndAcceptHelpDenyItem;

        return oneWayScenarios;
        
        
    }
     
    static void assignScenarioToLocations(Map map, Scenario[] scenarios) {
        Location[][] locations = map.getLocations();
        
        locations[0][0].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[0][1].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[0][2].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[0][3].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[0][4].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[0][5].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[0][6].setScenario(scenarios[Constants.DAY_STARTS]);
        
        locations[1][0].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[1][1].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[1][2].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[1][3].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[1][4].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[1][5].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[1][6].setScenario(scenarios[Constants.DAY_STARTS]);
        
        locations[2][0].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[2][1].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[2][2].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[2][3].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[2][4].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[2][5].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[2][6].setScenario(scenarios[Constants.DAY_STARTS]);
        
        locations[3][0].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[3][1].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[3][2].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[3][3].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[3][4].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[3][5].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[3][6].setScenario(scenarios[Constants.DAY_STARTS]);
        
        locations[4][0].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[4][1].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[4][2].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[4][3].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[4][4].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[4][5].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[4][6].setScenario(scenarios[Constants.DAY_STARTS]);
        
        locations[5][0].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[5][1].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[5][2].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[5][3].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[5][4].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[5][5].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[5][6].setScenario(scenarios[Constants.DAY_STARTS]);
        
        locations[6][0].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[6][1].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[6][2].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[6][3].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[6][4].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[6][5].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[6][6].setScenario(scenarios[Constants.DAY_STARTS]);

        
        
        
    }
    
    
    
    public void decideDoNothingPossibility(){

        
        
        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get charLuckValue
        double charLuckValue = SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int gameLuckValue = (int) ((Math.floor(Math.random() * charLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed;
        
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 80){
            //THEN nothing happens and choose 0 from chooseDoNothingPossiblities Array
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            String scenarioName = nothingHappens[0].getScenarioName();
            String scenarioDesc = nothingHappens[0].getScenarioDescription();
            String scenarioChoiceOne = nothingHappens[0].getChoiceOne();
            */
            NothingHappensScene nothingHappens = new NothingHappensScene();
            nothingHappens.display();
            
        }
        else if (finalSceneValue <= 79 && finalSceneValue >= 60){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[1].getScenarioName();
            nothingHappens[1].getScenarioDescription();
            */
            
            SurvivorsOfferHelp survivorsOfferHelp = new SurvivorsOfferHelp();
            survivorsOfferHelp.display();
            
	}
	else if (finalSceneValue <= 59 && finalSceneValue >= 40){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[2].getScenarioName();
            nothingHappens[2].getScenarioDescription();
            */
            SurvivorsAskHelp survivorsAskHelp = new SurvivorsAskHelp();
            survivorsAskHelp.display();
	}
	else if (finalSceneValue <= 39 && finalSceneValue >= 20){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[3].getScenarioName();
            nothingHappens[3].getScenarioDescription();
            */
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display();
            
        }
	else{
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[4].getScenarioName();
            nothingHappens[4].getScenarioDescription();
            */
            
            ZombiesAttack zombiesAttack = new ZombiesAttack();
            zombiesAttack.display();
            
            
	}
        
        
                
        
    }
    static Scenario[] createDoNothingPossibilitiesList(){
        
        Scenario[] chooseDoNothingPossibilities = new Scenario[Constants.DO_NOTHING_OUTCOMES_COUNT];
        
        //OUTCOMES Start Day > Stay in Current Location CHOICE
        //#2
        Scenario nothingHappens = new Scenario();
        nothingHappens.setScenarioName("Nothing happens");
        nothingHappens.setScenarioDescription("What a boring day.");
        nothingHappens.setScenarioValue(80);
        nothingHappens.setActive(false);
        nothingHappens.setChoiceOne("1 - Sleep");// Sleep == Day Ends
        nothingHappens.setChoiceTwo(null);
        nothingHappens.setChoiceThree(null);
        nothingHappens.setChoiceFour(null);
        nothingHappens.setChoiceFive(null);
        chooseDoNothingPossibilities[Constants.NOTHING_HAPPENS] = nothingHappens;
        
        //#3
        Scenario survivorsOfferHelp = new Scenario();
        survivorsOfferHelp.setScenarioName("Survivors Offer Help");
        survivorsOfferHelp.setScenarioDescription("Some survivors come by and offer help. What do you do?");
        survivorsOfferHelp.setActive(false);
        survivorsOfferHelp.setScenarioValue(60);
        survivorsOfferHelp.setChoiceOne("1 - Accept Help");
        survivorsOfferHelp.setChoiceTwo("2 - Refuse Help");
        survivorsOfferHelp.setChoiceThree("3 - Fight");
        survivorsOfferHelp.setChoiceFour(null);
        survivorsOfferHelp.setChoiceFive(null);
        chooseDoNothingPossibilities[Constants.SURVIVORS_OFFER_HELP] = survivorsOfferHelp;
        
        //#4
        Scenario survivorsAskForHelp = new Scenario();
        survivorsAskForHelp.setScenarioName("Survivors Ask You For Help");
        survivorsAskForHelp.setScenarioDescription("A group of survivors ask you for their help.");
        survivorsAskForHelp.setActive(false);
        survivorsAskForHelp.setScenarioValue(40);
        survivorsAskForHelp.setChoiceOne("Help the Survivors");
        survivorsAskForHelp.setChoiceTwo("Refuse to Help");
        survivorsAskForHelp.setChoiceThree("Run Away");
        survivorsAskForHelp.setChoiceFour("Fight");
        survivorsAskForHelp.setChoiceFive(null);
        chooseDoNothingPossibilities[Constants.SURVIVORS_ASK_HELP] = survivorsAskForHelp;
        
        //#5
        Scenario survivorsAttack = new Scenario();
        survivorsAttack.setScenarioName("Survivors Attack You");
        survivorsAttack.setScenarioDescription("You see a group of survivors in the distance. THEY START ATTACKING YOU!");
        survivorsAttack.setActive(false);
        survivorsAttack.setScenarioValue(20);
        survivorsAttack.setChoiceOne("Run");
        survivorsAttack.setChoiceTwo("Negotiate");
        survivorsAttack.setChoiceThree("Fight");
        survivorsAttack.setChoiceFour(null);
        survivorsAttack.setChoiceFive(null);
        chooseDoNothingPossibilities[Constants.SURVIVORS_ATTACK] = survivorsAttack;
        
        //#6
        Scenario zombiesAttack = new Scenario();
        zombiesAttack.setScenarioName("Zombies Attack");
        zombiesAttack.setScenarioDescription("It looks like a group of survivors...wait...IT'S ZOMBIES!!!!");
        zombiesAttack.setActive(false);
        zombiesAttack.setScenarioValue(0);
        zombiesAttack.setChoiceOne("Run");
        zombiesAttack.setChoiceTwo("Fight");
        zombiesAttack.setChoiceThree(null);
        zombiesAttack.setChoiceFour(null);
        zombiesAttack.setChoiceFive(null);
        chooseDoNothingPossibilities[Constants.ZOMBIES_ATTACK] = zombiesAttack;
        
        
        return chooseDoNothingPossibilities;
        
        
    }
    
    public void decideFortifyPossibilities(){

        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get charLuckValue
        double charLuckValue = SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int gameLuckValue = (int) ((Math.floor(Math.random() * charLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed;
        
        
        //IF finalSceneValue >= 66
        if (finalSceneValue >= 66){
            //THEN nothing happens and choose 0 from chooseDoNothingPossiblities Array
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            String scenarioName = nothingHappens[0].getScenarioName();
            String scenarioDesc = nothingHappens[0].getScenarioDescription();
            String scenarioChoiceOne = nothingHappens[0].getChoiceOne();
            */
            NothingHappensScene nothingHappens = new NothingHappensScene();
            nothingHappens.display();
            
        }
        else if (finalSceneValue <= 65 && finalSceneValue >= 33){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[1].getScenarioName();
            nothingHappens[1].getScenarioDescription();
            */
            
            SurvivorsOfferHelp survivorsOfferHelp = new SurvivorsOfferHelp();
            survivorsOfferHelp.display();
            
	}
        else {
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[2].getScenarioName();
            nothingHappens[2].getScenarioDescription();
            */
            SurvivorsAskHelp survivorsAskHelp = new SurvivorsAskHelp();
            survivorsAskHelp.display();
	}
        
    }
    static Scenario[] createFortifyPossibilitiesList(){
        
        Scenario[] chooseFortifyPossibilities = new Scenario[Constants.FORTIFY_OUTCOMES_COUNT];
        
        Scenario safelyFortify = new Scenario();
        safelyFortify.setScenarioName("Safely fortify");
        safelyFortify.setScenarioDescription("What a boring but safe day.");
        safelyFortify.setScenarioValue(80);
        safelyFortify.setActive(false);
        safelyFortify.setChoiceOne("Sleep");
        safelyFortify.setChoiceTwo(null);
        safelyFortify.setChoiceThree(null);
        safelyFortify.setChoiceFour(null);
        safelyFortify.setChoiceFive(null);
        chooseFortifyPossibilities[Constants.SAFELY_FORTIFY] = safelyFortify;
        
        //#3
        Scenario survivorsOfferHelp = new Scenario();
        survivorsOfferHelp.setScenarioName("Survivors Offer Help");
        survivorsOfferHelp.setScenarioDescription("Some survivors come by and offer help. What do you do?");
        survivorsOfferHelp.setActive(false);
        survivorsOfferHelp.setScenarioValue(60);
        survivorsOfferHelp.setChoiceOne("Accept Help");
        survivorsOfferHelp.setChoiceTwo("Refuse Help");
        survivorsOfferHelp.setChoiceThree("Fight");
        survivorsOfferHelp.setChoiceFour(null);
        survivorsOfferHelp.setChoiceFive(null);
        chooseFortifyPossibilities[Constants.SURVIVORS_OFFER_HELP_WHEN_FORTIFY] = survivorsOfferHelp;
        
        //#4
        Scenario survivorsAskForHelp = new Scenario();
        survivorsAskForHelp.setScenarioName("Survivors Ask You For Help");
        survivorsAskForHelp.setScenarioDescription("A group of survivors ask you for their help.");
        survivorsAskForHelp.setActive(false);
        survivorsAskForHelp.setScenarioValue(40);
        survivorsAskForHelp.setChoiceOne("Help the Survivors");
        survivorsAskForHelp.setChoiceTwo("Refuse to Help");
        survivorsAskForHelp.setChoiceThree("Run Away");
        survivorsAskForHelp.setChoiceFour("Fight");
        survivorsAskForHelp.setChoiceFive(null);
        chooseFortifyPossibilities[Constants.SURVIVORS_ASK_HELP_WHEN_FORTIFY] = survivorsAskForHelp;
        
        
        
        
        return chooseFortifyPossibilities;
    }
    
    public void decideExplorePossibility(){

        
        
        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get charLuckValue
        double charLuckValue = SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int gameLuckValue = (int) ((Math.floor(Math.random() * charLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed;
        
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 80){
            //THEN nothing happens and choose 0 from chooseDoNothingPossiblities Array
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            String scenarioName = nothingHappens[0].getScenarioName();
            String scenarioDesc = nothingHappens[0].getScenarioDescription();
            String scenarioChoiceOne = nothingHappens[0].getChoiceOne();
            */
            NothingHappensScene nothingHappens = new NothingHappensScene();
            nothingHappens.display();
            
        }
        else if (finalSceneValue <= 79 && finalSceneValue >= 60){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[1].getScenarioName();
            nothingHappens[1].getScenarioDescription();
            */
            
            SurvivorsOfferHelp survivorsOfferHelp = new SurvivorsOfferHelp();
            survivorsOfferHelp.display();
            
	}
	else if (finalSceneValue <= 59 && finalSceneValue >= 40){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[2].getScenarioName();
            nothingHappens[2].getScenarioDescription();
            */
            SurvivorsAskHelp survivorsAskHelp = new SurvivorsAskHelp();
            survivorsAskHelp.display();
	}
	else if (finalSceneValue <= 39 && finalSceneValue >= 20){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[3].getScenarioName();
            nothingHappens[3].getScenarioDescription();
            */
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display();
            
        }
	else{
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[4].getScenarioName();
            nothingHappens[4].getScenarioDescription();
            */
            
            ZombiesAttack zombiesAttack = new ZombiesAttack();
            zombiesAttack.display();
            
            
	}
        
        
                
        
    }
    static Scenario[] createExplorePossibilitiesList(){
        
        Scenario[] chooseExplorePossibilities = new Scenario[Constants.EXPLORE_OUTCOMES_COUNT];
        
        //OUTCOMES Start Day > Stay in Current Location CHOICE
        //#2
        Scenario safeTrip = new Scenario();
        safeTrip.setScenarioName("Safe Trip");
        safeTrip.setScenarioDescription("What a boring day.");
        safeTrip.setScenarioValue(80);
        safeTrip.setActive(false);
        safeTrip.setChoiceOne("Sleep");
        safeTrip.setChoiceTwo(null);
        safeTrip.setChoiceThree(null);
        safeTrip.setChoiceFour(null);
        safeTrip.setChoiceFive(null);
        chooseExplorePossibilities[Constants.SAFE_TRIP] = safeTrip;
        
        //#3
        Scenario survivorsOfferHelp = new Scenario();
        survivorsOfferHelp.setScenarioName("Survivors Offer Help");
        survivorsOfferHelp.setScenarioDescription("Some survivors come by and offer help. What do you do?");
        survivorsOfferHelp.setActive(false);
        survivorsOfferHelp.setScenarioValue(60);
        survivorsOfferHelp.setChoiceOne("Accept Help");
        survivorsOfferHelp.setChoiceTwo("Refuse Help");
        survivorsOfferHelp.setChoiceThree("Fight");
        survivorsOfferHelp.setChoiceFour(null);
        survivorsOfferHelp.setChoiceFive(null);
        chooseExplorePossibilities[Constants.SURVIVORS_OFFER_HELP_WHEN_EXPLORE] = survivorsOfferHelp;
        
        //#4
        Scenario survivorsAskForHelp = new Scenario();
        survivorsAskForHelp.setScenarioName("Survivors Ask You For Help");
        survivorsAskForHelp.setScenarioDescription("A group of survivors ask you for their help.");
        survivorsAskForHelp.setActive(false);
        survivorsAskForHelp.setScenarioValue(40);
        survivorsAskForHelp.setChoiceOne("Help the Survivors");
        survivorsAskForHelp.setChoiceTwo("Refuse to Help");
        survivorsAskForHelp.setChoiceThree("Run Away");
        survivorsAskForHelp.setChoiceFour("Fight");
        survivorsAskForHelp.setChoiceFive(null);
        chooseExplorePossibilities[Constants.SURVIVORS_ASK_HELP_WHEN_EXPLORE] = survivorsAskForHelp;
        
        //#5
        Scenario survivorsAttack = new Scenario();
        survivorsAttack.setScenarioName("Survivors Attack You");
        survivorsAttack.setScenarioDescription("You see a group of survivors in the distance. THEY START ATTACKING YOU!");
        survivorsAttack.setActive(false);
        survivorsAttack.setScenarioValue(20);
        survivorsAttack.setChoiceOne("Run");
        survivorsAttack.setChoiceTwo("Negotiate");
        survivorsAttack.setChoiceThree("Fight");
        survivorsAttack.setChoiceFour(null);
        survivorsAttack.setChoiceFive(null);
        chooseExplorePossibilities[Constants.SURVIVORS_ATTACK_WHEN_EXPLORE] = survivorsAttack;
        
        //#6
        Scenario zombiesAttack = new Scenario();
        zombiesAttack.setScenarioName("Zombies Attack");
        zombiesAttack.setScenarioDescription("It looks like a group of survivors...wait...IT'S ZOMBIES!!!!");
        zombiesAttack.setActive(false);
        zombiesAttack.setScenarioValue(0);
        zombiesAttack.setChoiceOne("Run");
        zombiesAttack.setChoiceTwo("Fight");
        zombiesAttack.setChoiceThree(null);
        zombiesAttack.setChoiceFour(null);
        zombiesAttack.setChoiceFive(null);
        chooseExplorePossibilities[Constants.ZOMBIES_ATTACK_WHEN_EXPLORE] = zombiesAttack;
        
        return chooseExplorePossibilities;
        
    }
    
    public void decideScavengePossibility(){

        
        
        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get charLuckValue
        double charLuckValue = SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int gameLuckValue = (int) ((Math.floor(Math.random() * charLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed;
        
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 83){
            //THEN nothing happens and choose 0 from chooseDoNothingPossiblities Array
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            String scenarioName = nothingHappens[0].getScenarioName();
            String scenarioDesc = nothingHappens[0].getScenarioDescription();
            String scenarioChoiceOne = nothingHappens[0].getChoiceOne();
            */
            ScavengeFoundItem scavengeFoundItem = new ScavengeFoundItem();
            scavengeFoundItem.display();
            
        }
        else if (finalSceneValue <= 82 && finalSceneValue >= 66){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[1].getScenarioName();
            nothingHappens[1].getScenarioDescription();
            */
            
            ScavengeNoItem scavengeNoItem = new ScavengeNoItem();
            scavengeNoItem.display();
            
	}
	else if (finalSceneValue <= 65 && finalSceneValue >= 49){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[2].getScenarioName();
            nothingHappens[2].getScenarioDescription();
            */
            SurvivorsOfferHelp survivorsOfferHelp = new SurvivorsOfferHelp();
            survivorsOfferHelp.display();
	}
	else if (finalSceneValue <= 48 && finalSceneValue >= 32){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[3].getScenarioName();
            nothingHappens[3].getScenarioDescription();
            */
            SurvivorsAskHelp survivorsAskHelp = new SurvivorsAskHelp();
            survivorsAskHelp.display();
            
        }
        else if (finalSceneValue <= 31 && finalSceneValue >= 15){
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[3].getScenarioName();
            nothingHappens[3].getScenarioDescription();
            */
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display();
            
        }
	else{
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[4].getScenarioName();
            nothingHappens[4].getScenarioDescription();
            */
            
            ZombiesAttack zombiesAttack = new ZombiesAttack();
            zombiesAttack.display();
            
            
	}
        
        
                
        
    }
    static Scenario[] createScavengePossiblitiesList(){
        
        Scenario[] chooseScavengePossibilities = new Scenario[Constants.SCAVENGE_OUTCOMES_COUNT];
        
        
        Scenario findItem = new Scenario();
        findItem.setScenarioName("Found Items");
        findItem.setScenarioDescription("You found some supplies!.");
        findItem.setScenarioValue(80);
        findItem.setActive(false);
        findItem.setChoiceOne("Sleep");
        findItem.setChoiceTwo(null);
        findItem.setChoiceThree(null);
        findItem.setChoiceFour(null);
        findItem.setChoiceFive(null);
        chooseScavengePossibilities[Constants.FIND_ITEM] = findItem;
        
        Scenario findNothing = new Scenario();
        findNothing.setScenarioName("You found nothing.");
        findNothing.setScenarioDescription("Better luck next time.");
        findNothing.setScenarioValue(80);
        findNothing.setActive(false);
        findNothing.setChoiceOne(null);
        findNothing.setChoiceTwo(null);
        findNothing.setChoiceThree(null);
        findNothing.setChoiceFour(null);
        findNothing.setChoiceFive(null);
        chooseScavengePossibilities[Constants.FIND_NOTHING] = findNothing;
        
        //#3
        Scenario survivorsOfferHelp = new Scenario();
        survivorsOfferHelp.setScenarioName("Survivors Offer Help");
        survivorsOfferHelp.setScenarioDescription("Some survivors come by and offer help. What do you do?");
        survivorsOfferHelp.setActive(false);
        survivorsOfferHelp.setScenarioValue(60);
        survivorsOfferHelp.setChoiceOne("Accept Help");
        survivorsOfferHelp.setChoiceTwo("Refuse Help");
        survivorsOfferHelp.setChoiceThree("Fight");
        survivorsOfferHelp.setChoiceFour(null);
        survivorsOfferHelp.setChoiceFive(null);
        chooseScavengePossibilities[Constants.SURVIVORS_OFFER_HELP] = survivorsOfferHelp;
        
        //#4
        Scenario survivorsAskForHelp = new Scenario();
        survivorsAskForHelp.setScenarioName("Survivors Ask You For Help");
        survivorsAskForHelp.setScenarioDescription("A group of survivors ask you for their help.");
        survivorsAskForHelp.setActive(false);
        survivorsAskForHelp.setScenarioValue(40);
        survivorsAskForHelp.setChoiceOne("Help the Survivors");
        survivorsAskForHelp.setChoiceTwo("Refuse to Help");
        survivorsAskForHelp.setChoiceThree("Run Away");
        survivorsAskForHelp.setChoiceFour("Fight");
        survivorsAskForHelp.setChoiceFive(null);
        chooseScavengePossibilities[Constants.SURVIVORS_ASK_HELP] = survivorsAskForHelp;
        
        //#5
        Scenario survivorsAttack = new Scenario();
        survivorsAttack.setScenarioName("Survivors Attack You");
        survivorsAttack.setScenarioDescription("You see a group of survivors in the distance. THEY START ATTACKING YOU!");
        survivorsAttack.setActive(false);
        survivorsAttack.setScenarioValue(20);
        survivorsAttack.setChoiceOne("Run");
        survivorsAttack.setChoiceTwo("Negotiate");
        survivorsAttack.setChoiceThree("Fight");
        survivorsAttack.setChoiceFour(null);
        survivorsAttack.setChoiceFive(null);
        chooseScavengePossibilities[Constants.SURVIVORS_ATTACK] = survivorsAttack;
        
        //#6
        Scenario zombiesAttack = new Scenario();
        zombiesAttack.setScenarioName("Zombies Attack");
        zombiesAttack.setScenarioDescription("It looks like a group of survivors...wait...IT'S ZOMBIES!!!!");
        zombiesAttack.setActive(false);
        zombiesAttack.setScenarioValue(0);
        zombiesAttack.setChoiceOne("Run");
        zombiesAttack.setChoiceTwo("Fight");
        zombiesAttack.setChoiceThree(null);
        zombiesAttack.setChoiceFour(null);
        zombiesAttack.setChoiceFive(null);
        chooseScavengePossibilities[Constants.ZOMBIES_ATTACK] = zombiesAttack;
        
        return chooseScavengePossibilities;
        
    }
    
    public void decideAcceptHelpPossibility(){

        
        
        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get charCharismaValue
        double charCharismaValue = (SurviveRexburg.getEndUser().getGameCharacter().getcharCharismaValue())*2;
        //get charLuckValue
        double charLuckValue = SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int gameLuckValue = (int) ((Math.floor(Math.random() * charLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (int) ((originalSceneValue + gameLuckValue + charCharismaValue) - daysPassed);
        
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 50){
            //THEN nothing happens and choose 0 from chooseDoNothingPossiblities Array
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            String scenarioName = nothingHappens[0].getScenarioName();
            String scenarioDesc = nothingHappens[0].getScenarioDescription();
            String scenarioChoiceOne = nothingHappens[0].getChoiceOne();
            */
            SurvivorsGiveItem survivorsGiveItem = new SurvivorsGiveItem();
            survivorsGiveItem.display();
            
        }
        else {
            /*
            Scenario[] nothingHappens = SurviveRexburg.getCurrentGame().getChooseDoNothingPossibilities();
            nothingHappens[4].getScenarioName();
            nothingHappens[4].getScenarioDescription();
            */
            
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display();
            
            
	}
        
        
                
        
    }
    static Scenario[] createAcceptHelpPossibilitiesList(){
        
        Scenario[] chooseAcceptHelpPossibilities = new Scenario[Constants.ACCEPT_HELP_OUTCOMES_COUNT];
        
        //OUTCOMES of SurvivorsOfferHelp>Accept Help CHOICE
        //#7
        Scenario survivorsGiveItem = new Scenario();
        survivorsGiveItem.setScenarioName("Survivors Give You Supplies");
        survivorsGiveItem.setScenarioDescription("The survivors decide to leave you with some supplies to help survive.");
        survivorsGiveItem.setActive(false);
        survivorsGiveItem.setScenarioValue(50);
        survivorsGiveItem.setChoiceOne("Accept Item");
        survivorsGiveItem.setChoiceOne("Refuse Item");
        survivorsGiveItem.setChoiceOne(null);
        survivorsGiveItem.setChoiceOne(null);
        survivorsGiveItem.setChoiceOne(null);
        chooseAcceptHelpPossibilities[Constants.SURVIVORS_GIVE_YOU_ITEM] = survivorsGiveItem;
        
        //#8
        Scenario trickedAttackedAfterOfferingHelp = new Scenario();
        trickedAttackedAfterOfferingHelp.setScenarioName("Tricked! Survivors Attack!");
        trickedAttackedAfterOfferingHelp.setScenarioDescription("The group of survivors offer help but have tricked you! And are now attacking you!");
        trickedAttackedAfterOfferingHelp.setActive(false);
        trickedAttackedAfterOfferingHelp.setScenarioValue(0);
        trickedAttackedAfterOfferingHelp.setChoiceOne("Run");
        trickedAttackedAfterOfferingHelp.setChoiceTwo("Negotiate");
        trickedAttackedAfterOfferingHelp.setChoiceThree("Fight");
        trickedAttackedAfterOfferingHelp.setChoiceFour(null);
        trickedAttackedAfterOfferingHelp.setChoiceFive(null);
        chooseAcceptHelpPossibilities[Constants.TRICKED_ATTACKED_AFTER_OFFERING_HELP] = trickedAttackedAfterOfferingHelp;

        return chooseAcceptHelpPossibilities;
    }
    
    public void decideRunAwayPossibility(){
        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get charCharismaValue
        double charSpeedValue = (SurviveRexburg.getEndUser().getGameCharacter().getcharSpeedValue())*2;
        //get charLuckValue
        double charLuckValue = (SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue()) * 2;
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int gameLuckValue = (int) ((Math.floor(Math.random() * charLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (int) ((originalSceneValue + gameLuckValue + charSpeedValue) - daysPassed);
        
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 75){
            System.out.print("****Escape + Random Location + Day Ends****");
            
            EscapeAndNewLocation escapeNewLocation = new EscapeAndNewLocation();
            escapeNewLocation.display();
            
            
        }
        else if(finalSceneValue <=74 && finalSceneValue >= 50){
            System.out.print("****Captures + Injured****");
            
            GameControl.lowerHealth();
            
            CapturedAndInjured capturedAndInjured = new CapturedAndInjured();
            capturedAndInjured.display();
            
            
        }
        else if(finalSceneValue <=49 && finalSceneValue >= 25){
            System.out.println("****Captured + Injured + Robbed****");
            
            CapturedInjuredAndRobbed capturedInjuredAndRobbed = new CapturedInjuredAndRobbed();
            capturedInjuredAndRobbed.display();
        }
        else {
            System.out.println("****Killed by Survivors***");
            
            KilledBySurvivors killedBySurvivors = new KilledBySurvivors();
            killedBySurvivors.display();
            
            
	}
        
        
                
        
    }
    static Scenario[] createRunAwayFromSurvivorsPossibilitiesList(){
        
        Scenario[] chooseRunAwayFromSurvivorsPossibilities = new Scenario[Constants.RUN_AWAY_SURVIVORS_OUTCOMES_COUNT];
        
        //OUTCOME
        //#11 Survivors Offer Help > Trick+Attack > Run CHOICE
        Scenario escapeToLocationDayEnds = new Scenario();
        escapeToLocationDayEnds.setScenarioName
        ("Survivors Trick You And Attack You Run And Escape To New Location With Day Ending");
        escapeToLocationDayEnds.setScenarioDescription
                ("\nYou run away and the survivors chase you "
                + "\ndown all the way to ______. You "
                + "\nlose them around the corner and they "
                + "\ndecide to forget you. The sun is setting "
                + "\nand you're so exhausted you stay where you "
                + "\nare at. The day is about over.");
        escapeToLocationDayEnds.setActive(false);
        escapeToLocationDayEnds.setScenarioValue(75);
        escapeToLocationDayEnds.setChoiceOne("Sleep");
        escapeToLocationDayEnds.setChoiceTwo(null);
        escapeToLocationDayEnds.setChoiceThree(null);
        escapeToLocationDayEnds.setChoiceFour(null);
        escapeToLocationDayEnds.setChoiceFive(null);
        chooseRunAwayFromSurvivorsPossibilities [Constants.ESCAPE_TO_LOCATION_DAY_ENDS] = escapeToLocationDayEnds;
        
        
        //OUTCOME
        //#12 Survivors Offer Help > Trick/Attack > Run and Captured CHOICE
        Scenario capturedAndInjuredDayEnds = new Scenario();
        capturedAndInjuredDayEnds.setScenarioName
        ("You Are Captured And Injured With Day Ends");
        capturedAndInjuredDayEnds.setScenarioDescription
                ("\nYou run away and immediately they grab"
                + "\nyou. They beat you up and you lose ____ "
                + "\nhealth. The survivors leave you there "
                + "\nto endure the pain. The day is about over."
                + "\nThe only thing you can do is sleep off "
                + "\nthe injury and continue the next day.");
        capturedAndInjuredDayEnds.setActive(false);
        capturedAndInjuredDayEnds.setScenarioValue(50);
        capturedAndInjuredDayEnds.setChoiceOne("Sleep");
        capturedAndInjuredDayEnds.setChoiceTwo(null);
        capturedAndInjuredDayEnds.setChoiceThree(null);
        capturedAndInjuredDayEnds.setChoiceFour(null);
        capturedAndInjuredDayEnds.setChoiceFive(null);
        chooseRunAwayFromSurvivorsPossibilities [Constants.CAPTURED_AND_INJURED_DAY_ENDS] = capturedAndInjuredDayEnds;
        
                
        //OUTCOME        
        //#13 Survivors Offer Help > Trick/Attack > Run and Captured and Robbed CHOICE
        Scenario capturedInjuredAndRobbedDayEnds = new Scenario();
        capturedInjuredAndRobbedDayEnds.setScenarioName
        ("You Are Captured Injured And Robbed With Day Ends");
        capturedInjuredAndRobbedDayEnds.setScenarioDescription
                ("\nYou run as fast as you can. But it wasn't"
                + "\ngood enough. They caught up and punch you"
                + "\ntil you pass out. They take the opportunity"
                + "\nto steal _____ from you. In addition, you"
                + "\nlost _____ health points. You are out until"
                + "\nthe next morning.");
        capturedInjuredAndRobbedDayEnds.setActive(false);
        capturedInjuredAndRobbedDayEnds.setScenarioValue(25);
        capturedInjuredAndRobbedDayEnds.setChoiceOne("Sleep");
        capturedInjuredAndRobbedDayEnds.setChoiceTwo(null);
        capturedInjuredAndRobbedDayEnds.setChoiceThree(null);
        capturedInjuredAndRobbedDayEnds.setChoiceFour(null);
        capturedInjuredAndRobbedDayEnds.setChoiceFive(null);
        chooseRunAwayFromSurvivorsPossibilities [Constants.CAPTURED_INJURED_ROBBED_DAY_ENDS] = capturedInjuredAndRobbedDayEnds;
        
        
        //OUTCOME
        //#14 Survivors Offer Help > Trick/Attack > Run and Dead CHOICE
        Scenario capturedAndDead = new Scenario();
        capturedAndDead.setScenarioName
        ("You Are Captured Aftering Trying To Run And Dead");
        capturedAndDead.setScenarioDescription
                ("\nAs you were running you trip on a crack"
                + "in the cement. They catch up to you. You"
                + "messed with the wrong crowd, because they "
                + "murder you. But don't worry, they made your"
                + "death quick and painless. Wanna try again?");
        capturedAndDead.setActive(false);
        capturedAndDead.setScenarioValue(0);
        capturedAndDead.setChoiceOne("Game Over");
        capturedAndDead.setChoiceTwo(null);
        capturedAndDead.setChoiceThree(null);
        capturedAndDead.setChoiceFour(null);
        capturedAndDead.setChoiceFive(null);
        chooseRunAwayFromSurvivorsPossibilities [Constants.CAPTURED_AND_DEAD] = capturedAndDead;
        
        return chooseRunAwayFromSurvivorsPossibilities;
        
    }
    
    static Scenario[] createNegotiatePossibilitiesList(){
        
        Scenario[] chooseNegotiatePossibilities = new Scenario[Constants.NEGOTIATE_OUTCOMES_COUNT];
        
        //OUTCOME Survivors Offer Help > Accept Help CHOICE 
        //      > Survivors Attack You > Negotiate CHOICE
        //#15
        Scenario survivorsListenToNegotiation = new Scenario();
        survivorsListenToNegotiation.setScenarioName("Survivors Listen to Your Proposition");
        survivorsListenToNegotiation.setScenarioDescription
        ("\nYou offer a worthwhile bribe. The attacking "
        + "\nsurvivors stop attacking and listen to what "
        + "\nyou have to offer.");
        survivorsListenToNegotiation.setActive(false);
        survivorsListenToNegotiation.setScenarioValue(50);
        survivorsListenToNegotiation.setChoiceOne("Offer Item");
        survivorsListenToNegotiation.setChoiceTwo(null);
        survivorsListenToNegotiation.setChoiceThree(null);
        survivorsListenToNegotiation.setChoiceFour(null);
        survivorsListenToNegotiation.setChoiceFive(null);
        chooseNegotiatePossibilities[Constants.SURVIVORS_LISTEN_TO_NEGOTIATION] = survivorsListenToNegotiation;
        
        
        //#16
        Scenario survivorsDontListenToNegotiation = new Scenario();
        survivorsDontListenToNegotiation.setScenarioName("Survivors Won't Listen");
        survivorsDontListenToNegotiation.setScenarioDescription
        ("They won't listen! They're still coming after you!");
        survivorsDontListenToNegotiation.setActive(false);
        survivorsDontListenToNegotiation.setScenarioValue(0);
        survivorsDontListenToNegotiation.setChoiceOne("Run");
        survivorsDontListenToNegotiation.setChoiceTwo("Fight");
        survivorsDontListenToNegotiation.setChoiceThree(null);
        survivorsDontListenToNegotiation.setChoiceFour(null);
        survivorsDontListenToNegotiation.setChoiceFive(null);
        chooseNegotiatePossibilities [Constants.SURVIVORS_DONT_LISTEN_TO_NEGOTIATION] = survivorsDontListenToNegotiation;
        
        return chooseNegotiatePossibilities;
    }
    
    
    static Scenario[] createOfferingPossibilitiesList(){
        Scenario[] chooseOfferingPossibilities = new Scenario[Constants.OFFERING_OUTCOMES_COUNT];
        
        //OUTCOME
        //#21 Survivors Attack > Negotiate > Listen > Offering 1 > Take+Leave+Day Ends
        Scenario takeOfferAndLeaveDayEnds = new Scenario();
        takeOfferAndLeaveDayEnds.setScenarioName
        ("Survivors Take Your Offer And Leave With Day End");
        takeOfferAndLeaveDayEnds.setScenarioDescription
            ("\nThe Survivors like your offering. They take"
           + "\nyour item and leave in peace. The day is"
           + "just about over.");
        takeOfferAndLeaveDayEnds.setActive(false);
        takeOfferAndLeaveDayEnds.setScenarioValue(50);
        takeOfferAndLeaveDayEnds.setChoiceOne("Sleep");
        takeOfferAndLeaveDayEnds.setChoiceTwo(null);
        takeOfferAndLeaveDayEnds.setChoiceThree(null);
        takeOfferAndLeaveDayEnds.setChoiceFour(null);
        takeOfferAndLeaveDayEnds.setChoiceFive(null);
        chooseOfferingPossibilities [Constants.TAKE_OFFER_AND_LEAVE_DAY_ENDS] = takeOfferAndLeaveDayEnds;
        
        
        //OUTCOME
        //#22 Survivors Attack > Negotiate > Listen > Don't like Offering
        Scenario dontTakeOfferAndAndAttack = new Scenario();
        dontTakeOfferAndAndAttack.setScenarioName
        ("Survivors Don't Like Your Offering And Attack You");
        dontTakeOfferAndAndAttack.setScenarioDescription
                ("\nThe disguist on their face was apparent."
                + "\nYou tried to make your sales pitch sound"
                + "\ngood but it wasn't enough. They are ready"
                + "\nto attack!");
        dontTakeOfferAndAndAttack.setActive(false);
        dontTakeOfferAndAndAttack.setScenarioValue(0);
        dontTakeOfferAndAndAttack.setChoiceOne("Run");
        dontTakeOfferAndAndAttack.setChoiceTwo("Fight");
        dontTakeOfferAndAndAttack.setChoiceThree(null);
        dontTakeOfferAndAndAttack.setChoiceFour(null);
        dontTakeOfferAndAndAttack.setChoiceFive(null);
        chooseOfferingPossibilities [Constants.DONT_TAKE_OFFER_AND_ATTACK] = dontTakeOfferAndAndAttack;
        
        return chooseOfferingPossibilities;        
    }
    
    
    static Scenario[] createFightSurvivorsPossibilitiesList(){
        
        Scenario[] chooseFightSurvivorsPossibilities = new Scenario[Constants.FIGHT_SURVIVORS_OUTCOMES_COUNT];
        
        //OUTCOME Survivors Offer Help > Accept Help CHOICE 
        //      > Survivors Attack You > Fight CHOICE
        //#17
        Scenario winFightGainSuppliesDayEnds = new Scenario();
        winFightGainSuppliesDayEnds.setScenarioName("You Won the Fight! And You found stuff!");
        winFightGainSuppliesDayEnds.setScenarioDescription
        ("\nLooks like you won the fight! You seem to have "
        + "\nfound some useful items as well! You survived "
        + "\ntoday. Time to rest for tomrrow.");
        winFightGainSuppliesDayEnds.setActive(false);
        winFightGainSuppliesDayEnds.setScenarioValue(75);
        winFightGainSuppliesDayEnds.setChoiceOne("Sleep");
        winFightGainSuppliesDayEnds.setChoiceTwo(null);
        winFightGainSuppliesDayEnds.setChoiceThree(null);
        winFightGainSuppliesDayEnds.setChoiceFour(null);
        winFightGainSuppliesDayEnds.setChoiceFive(null);
        chooseFightSurvivorsPossibilities[Constants.WIN_FIGHT_GAIN_SUPPLIES_DAY_ENDS] = winFightGainSuppliesDayEnds;
        
        
        //#18
        Scenario winFightDayEnds = new Scenario();
        winFightDayEnds.setScenarioName("You Won the Fight!");
        winFightDayEnds.setScenarioDescription
        ("\nYou won the fight! You sure know what you're "
        + "\ndoing. The day is over time to rest for tomrrow.");
        winFightDayEnds.setActive(false);
        winFightDayEnds.setScenarioValue(50);
        winFightDayEnds.setChoiceOne("Sleep");
        winFightDayEnds.setChoiceTwo(null);
        winFightDayEnds.setChoiceThree(null);
        winFightDayEnds.setChoiceFour(null);
        winFightDayEnds.setChoiceFive(null);
        chooseFightSurvivorsPossibilities[Constants.WIN_FIGHT_DAY_ENDS] = winFightDayEnds;
        
        
        //#19
        Scenario loseFightInjuredDayEnds = new Scenario();
        loseFightInjuredDayEnds.setScenarioName("You Lost and are Hurt");
        loseFightInjuredDayEnds.setScenarioDescription
        ("\nYou have lost this fight. You were injured "
        + "\nbut not killed. Consider yourself lucky. "
        + "\nThese are dangerous times. Time to get some "
        + "\nsleep to survive tomorrow.");
        loseFightInjuredDayEnds.setActive(false);
        loseFightInjuredDayEnds.setScenarioValue(25);
        loseFightInjuredDayEnds.setChoiceOne("Sleep");
        loseFightInjuredDayEnds.setChoiceTwo(null);
        loseFightInjuredDayEnds.setChoiceThree(null);
        loseFightInjuredDayEnds.setChoiceFour(null);
        loseFightInjuredDayEnds.setChoiceFive(null);
        chooseFightSurvivorsPossibilities[Constants.LOSE_FIGHT_INJURED_DAY_ENDS] = loseFightInjuredDayEnds;
        
        
        //#20
        Scenario loseFightDead = new Scenario();
        loseFightDead.setScenarioName("You Were Killed in Battle");
        loseFightDead.setScenarioDescription
        ("\nYou have lost this fight.....and you're life. Sometimes fighting is always the answer.");
        loseFightDead.setActive(false);
        loseFightDead.setScenarioValue(0);
        loseFightDead.setChoiceOne("Game Over");
        loseFightDead.setChoiceTwo(null);
        loseFightDead.setChoiceThree(null);
        loseFightDead.setChoiceFour(null);
        loseFightDead.setChoiceFive(null);
        chooseFightSurvivorsPossibilities[Constants.LOSE_FIGHT_INJURED_DAY_ENDS] = loseFightDead;
        
        return chooseFightSurvivorsPossibilities;
        
        
    }
    
    static Scenario[] createRunAwayFromZombiesPossibilitiesList(){
        
        Scenario[] chooseRunAwayFromZombiesPossibilities = new Scenario[Constants.RUN_AWAY_FROM_ZOMBIES_OUTCOMES_COUNT];
        
        Scenario escapeZombies = new Scenario();
        escapeZombies.setScenarioName("");
        escapeZombies.setScenarioDescription
                ("\nYou run away and the Zombies chase you "
                + "\ndown all the way to ______. You "
                + "\nlose them around the corner and they "
                + "\ndecide to forget you. The sun is setting "
                + "\nand you're so exhausted you stay where you "
                + "\nare at. The day is about over.");
        escapeZombies.setActive(false);
        escapeZombies.setScenarioValue(75);
        escapeZombies.setChoiceOne("Sleep");
        escapeZombies.setChoiceTwo(null);
        escapeZombies.setChoiceThree(null);
        escapeZombies.setChoiceFour(null);
        escapeZombies.setChoiceFive(null);
        chooseRunAwayFromZombiesPossibilities [Constants.ESCAPE_ZOMBIES_NEW_LOCATION_DAY_ENDS] = escapeZombies;
        
        Scenario killedByZombies = new Scenario();
        killedByZombies.setScenarioName("");
        killedByZombies.setScenarioDescription
                ("\nYou run away and the Zombies chase you "
                + "\ndown all the way to ______. You "
                + "\nlose them around the corner and they "
                + "\ndecide to forget you. The sun is setting "
                + "\nand you're so exhausted you stay where you "
                + "\nare at. The day is about over.");
        killedByZombies.setActive(false);
        killedByZombies.setScenarioValue(75);
        killedByZombies.setChoiceOne("Sleep");
        killedByZombies.setChoiceTwo(null);
        killedByZombies.setChoiceThree(null);
        killedByZombies.setChoiceFour(null);
        killedByZombies.setChoiceFive(null);
        chooseRunAwayFromZombiesPossibilities [Constants.KILLED_BY_ZOMBIES] = killedByZombies;
        
        return chooseRunAwayFromZombiesPossibilities;
    }
    
    static Scenario[] createFightZombiesPossibilitiesList(){
        
        Scenario[] chooseFightZombiesPossiblities = new Scenario[Constants.FIGHT_ZOMBIES_OUTCOMES_COUNT];
        
        Scenario killZombiesInFight = new Scenario();
        killZombiesInFight.setScenarioName("You Won the Fight! And You found stuff!");
        killZombiesInFight.setScenarioDescription
        ("\nLooks like you won the fight! You seem to have "
        + "\nfound some useful items as well! You survived "
        + "\ntoday. Time to rest for tomrrow.");
        killZombiesInFight.setActive(false);
        killZombiesInFight.setScenarioValue(75);
        killZombiesInFight.setChoiceOne("Sleep");
        killZombiesInFight.setChoiceTwo(null);
        killZombiesInFight.setChoiceThree(null);
        killZombiesInFight.setChoiceFour(null);
        killZombiesInFight.setChoiceFive(null);
        chooseFightZombiesPossiblities[Constants.KILL_ZOMBIES_DAY_ENDS] = killZombiesInFight;
        
        Scenario zombiesKillYouInFight = new Scenario();
        zombiesKillYouInFight.setScenarioName
        ("You Are Captured Aftering Trying To Run And Dead");
        zombiesKillYouInFight.setScenarioDescription
                ("\nAs you were running you trip on a crack"
                + "in the cement. They catch up to you. You"
                + "messed with the wrong crowd, because they "
                + "murder you. But don't worry, they made your"
                + "death quick and painless. Wanna try again?");
        zombiesKillYouInFight.setActive(false);
        zombiesKillYouInFight.setScenarioValue(0);
        zombiesKillYouInFight.setChoiceOne("Game Over");
        zombiesKillYouInFight.setChoiceTwo(null);
        zombiesKillYouInFight.setChoiceThree(null);
        zombiesKillYouInFight.setChoiceFour(null);
        zombiesKillYouInFight.setChoiceFive(null);
        chooseFightZombiesPossiblities [Constants.KILLED_BY_ZOMBIES_AFTER_FIGHT] = zombiesKillYouInFight;
        
        return chooseFightZombiesPossiblities;
        
        
        
        
    }
    
    
    
    
    
    /*
    
        public static Scenario[] getSortedScenarioList(){
            Scenario[] scenarios = SurviveRexburg.getCurrentGame().getScenarios();
            
            int i, j;
            Scenario temp;

            for ( i = 0;  i < scenarios.length - 1;  i++ )
            {
                for ( j = i + 1;  j < scenarios.length;  j++ )
                {  
                         if (scenarios[i].getScenarioValue() > scenarios[j].getScenarioValue())
                          {                                             // ascending sort
                                      temp = scenarios [i];
                                      scenarios [i] = scenarios [j];    // swapping
                                      scenarios [j] = temp; 
                                      
                           } 
                   } 
             } 
       
        
       return scenarios;            
    }
    
    */
    
}//end of ScenarioControl
