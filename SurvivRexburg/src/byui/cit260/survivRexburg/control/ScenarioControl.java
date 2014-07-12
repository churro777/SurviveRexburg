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
import byui.cit260.surviveRexburg.view.scenes.DefeatSurvivors;
import byui.cit260.surviveRexburg.view.scenes.DefeatSurvivorsGainSupplies;
import byui.cit260.surviveRexburg.view.scenes.DefeatZombies;
import byui.cit260.surviveRexburg.view.scenes.EscapeAndNewLocation;
import byui.cit260.surviveRexburg.view.scenes.KilledBySurvivors;
import byui.cit260.surviveRexburg.view.scenes.KilledByZombies;
import byui.cit260.surviveRexburg.view.scenes.LostFightInjured;
import byui.cit260.surviveRexburg.view.scenes.NothingHappensScene;
import byui.cit260.surviveRexburg.view.scenes.ScavengeFoundItem;
import byui.cit260.surviveRexburg.view.scenes.ScavengeNoItem;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsAskHelp;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsAttack;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsGiveItem;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsKeepAttacking;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsLeave;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsListen;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsOfferHelp;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsRefuseItem;
import byui.cit260.surviveRexburg.view.scenes.SurvivorsTakeItemAndLeave;
import byui.cit260.surviveRexburg.view.scenes.TrickedSurvivorsAttack;
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
    
    
    //Nothing Happens, survivorsOfferHelp, SurvivorsAskHelp, SurvivrosAttack, ZombiesAttack
    public void decideDoNothingPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 80){
            System.out.println("****NothingHappens****");
            NothingHappensScene nothingHappens = new NothingHappensScene();
            nothingHappens.display();
        }
        else if (finalSceneValue <= 79 && finalSceneValue >= 60){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelp survivorsOfferHelp = new SurvivorsOfferHelp();
            survivorsOfferHelp.display();
	}
	else if (finalSceneValue <= 59 && finalSceneValue >= 40){
            System.out.println("****SurvivorsAskHelp****");
            SurvivorsAskHelp survivorsAskHelp = new SurvivorsAskHelp();
            survivorsAskHelp.display();
	}
	else if (finalSceneValue <= 39 && finalSceneValue >= 20){
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display();
        }
	else{
            System.out.println("****ZombiesAttack****");
            ZombiesAttack zombiesAttack = new ZombiesAttack();
            zombiesAttack.display();
	}           
        
    }
    
    //NothingHappens, SurvivorsOfferHelp, SurvivorsAskHelp
    public void decideFortifyPossibilities(){
        int finalSceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        //IF finalSceneValue >= 66
        if (finalSceneValue >= 66){
            System.out.println("****NothingHappens****");
            NothingHappensScene nothingHappens = new NothingHappensScene();
            nothingHappens.display();
        }
        else if (finalSceneValue <= 65 && finalSceneValue >= 33){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelp survivorsOfferHelp = new SurvivorsOfferHelp();
            survivorsOfferHelp.display();
	}
        else {
            System.out.println("****SurvivorsAskHelp****");
            SurvivorsAskHelp survivorsAskHelp = new SurvivorsAskHelp();
            survivorsAskHelp.display();
	}
        
    }
    
    //NothingHappens, SurvivorsOfferHelp, SurvivorsAskHelp,SurvivorsAttack, ZombiesAttack
    public void decideExplorePossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 80){
            NothingHappensScene nothingHappens = new NothingHappensScene();
            nothingHappens.display();
        }
        else if (finalSceneValue <= 79 && finalSceneValue >= 60){
            SurvivorsOfferHelp survivorsOfferHelp = new SurvivorsOfferHelp();
            survivorsOfferHelp.display();
	}
	else if (finalSceneValue <= 59 && finalSceneValue >= 40){
            SurvivorsAskHelp survivorsAskHelp = new SurvivorsAskHelp();
            survivorsAskHelp.display();
	}
	else if (finalSceneValue <= 39 && finalSceneValue >= 20){
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display(); 
        }
	else{
            ZombiesAttack zombiesAttack = new ZombiesAttack();
            zombiesAttack.display(); 
	}
        
    }
    
    //ScavengeFountItem, ScavengeNoItem, SurvivorsOfferHelp,SurvivorsAskHelp, SurvivorsAttack,ZombiesAttack
    public void decideScavengePossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 83){
            System.out.println("****ScavengeFoundItem****");
            ScavengeFoundItem scavengeFoundItem = new ScavengeFoundItem();
            scavengeFoundItem.display();
        }
        else if (finalSceneValue <= 82 && finalSceneValue >= 66){
            System.out.println("****ScavengeNoItem****");
            ScavengeNoItem scavengeNoItem = new ScavengeNoItem();
            scavengeNoItem.display();
	}
	else if (finalSceneValue <= 65 && finalSceneValue >= 49){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelp survivorsOfferHelp = new SurvivorsOfferHelp();
            survivorsOfferHelp.display();
	}
	else if (finalSceneValue <= 48 && finalSceneValue >= 32){
            SurvivorsAskHelp survivorsAskHelp = new SurvivorsAskHelp();
            survivorsAskHelp.display();
        }
        else if (finalSceneValue <= 31 && finalSceneValue >= 15){
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display();
        }
	else{
            System.out.println("****ZombiesAttack****");
            ZombiesAttack zombiesAttack = new ZombiesAttack();
            zombiesAttack.display();
	}
        
    }
    
    //SurvivorsGiveItem, SurvivorsAttack
    public void decideAcceptHelpPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 50){
            System.out.println("****SurvivorsGiveItem****");
            SurvivorsGiveItem survivorsGiveItem = new SurvivorsGiveItem();
            survivorsGiveItem.display();
        }
        else {
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display();  
	}           
        
    }
    
    //SurvivorsLeave, SurvivorsAttack
    public void decideDenyHelpPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****SurvivorsLeave****");
            SurvivorsLeave survivorsLeave = new SurvivorsLeave();
            survivorsLeave.display();
        }
        else {
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display();  
	}
    }
    
    //SurvivorsLeave, SurvivorsAttack
    public void decideRefuseHelpPossiblity(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****SurvivorsLeave****");
            SurvivorsLeave survivorsLeave = new SurvivorsLeave();
            survivorsLeave.display();
        }
        else {
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttack survivorsAttack = new SurvivorsAttack();
            survivorsAttack.display();  
	}
    }
    
    //EscapeAndNewLocation, CapturedAndInjured, CapturedInjuredAndRobbed, KilledBySurvivors
    public void decideRunAwayPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharSpeedAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 75){
            System.out.print("****Escape + Random Location + Day Ends****");
            EscapeAndNewLocation escapeNewLocation = new EscapeAndNewLocation();
            escapeNewLocation.display();   
        }
        else if(finalSceneValue <=74 && finalSceneValue >= 50){           
            GameControl.lowerHealth();
            System.out.print("****Captures + Injured****");
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
    
    //SurvivorsListen, SurvivorsKeepAttacking
    public void decideNegotiatePossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        //IF finalSceneValue >= 50
        if (finalSceneValue >= 50){
            System.out.print("****SurvivorsListen****");
            SurvivorsListen survivorsListen = new SurvivorsListen();
            survivorsListen.display();
        }
        else {
            System.out.println("****SurvivorsKeepAttacking***");
            SurvivorsKeepAttacking survivorsKeepAttacking = new SurvivorsKeepAttacking();
            survivorsKeepAttacking.display();    
	}            
        
    }
    
    //SurvivorsTakeItemAndLeave, TrickedSurvivorsAttack
    public void decideOfferingPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****Took Item and Left****");
            SurvivorsTakeItemAndLeave takeItemLeave = new SurvivorsTakeItemAndLeave();
            takeItemLeave.display();
        }
        else {
            System.out.println("****SurvivorsRefuseItem****");
            SurvivorsRefuseItem survivorsRefuseItem = new SurvivorsRefuseItem();
            survivorsRefuseItem.display();
        }
    }
    
    //SurvivorsTakeItemAndLeave, TrickedSurvivorsAttack
    public void decideHelpSurvivorsPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****Took Item and Left****");
            SurvivorsTakeItemAndLeave takeItemLeave = new SurvivorsTakeItemAndLeave();
            takeItemLeave.display();
        }
        else {
            System.out.println("****Tricked!Survivors Attack****");
            TrickedSurvivorsAttack trickedSurvivorsAttack = new TrickedSurvivorsAttack();
            trickedSurvivorsAttack.display();
        }
    }
    
    //DefeatSurvivorsGainSupplies, DefeatSurvivors, LostFightLostHealth, KilledBySurvivors
    public void decideFightSurvivorsPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharStrengthMeleeRangedAndMinusDays();
        
        if (finalSceneValue >= 75){
            System.out.println("****DefeatSurvivorsGainSupplies****");
            DefeatSurvivorsGainSupplies defeatSurvivorsGainSupplies = new DefeatSurvivorsGainSupplies();
            defeatSurvivorsGainSupplies.display();
        }
        else if (finalSceneValue <= 74 && finalSceneValue >= 50){
            System.out.println("****DefeatSurvivors****");
            DefeatSurvivors defeatSurvivors = new DefeatSurvivors();
            defeatSurvivors.display();
        }
        else if (finalSceneValue <= 49 && finalSceneValue >= 25){
            GameControl.lowerHealth();            
            System.out.println("****LostFightLostHealth");
            LostFightInjured lostFightInjured = new LostFightInjured();
            lostFightInjured.display();
        }
        else {
            System.out.println("****KilledBySurvivors****");
            
            KilledBySurvivors killedBySurvivors = new KilledBySurvivors();
            killedBySurvivors.display();
        }
        
    }
    
    //EscapeAndNewLocation, KilledByZombies
    public void decideRunAwayFromZombiesPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharSpeedAndMinusDays();
        if (finalSceneValue >= 50){
            System.out.println("****Escaped Zombies + New Location****");
            EscapeAndNewLocation escapeAndNewLocation = new EscapeAndNewLocation();
            escapeAndNewLocation.display();
        }
        else {
            System.out.println("****Killed by zombies****");
            KilledByZombies killedByZombies = new KilledByZombies();
            killedByZombies.display();
        }
        
    }
    
    //DefeatZombies, KilledByZombies
    public void decideFightZombiesPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharStrengthMeleeRangedAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****DefeatZombies****");
            DefeatZombies defeatZombies = new DefeatZombies();
            defeatZombies.display();
        }
        else{
            System.out.println("****KilledByZombies****");
            KilledByZombies killedByZombies = new KilledByZombies();
            killedByZombies.display();
        }
    }
    
    
    public int AddGameLuckCharLuckAndMinusDays(){
        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get charLuckValue
        int topCharLuckValue = (int) SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int charLuckValue = (int) ((Math.floor(Math.random() * topCharLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (originalSceneValue + charLuckValue) - daysPassed;
        
        return finalSceneValue;
    }
    
    public int AddGameLuckCharLuckCharCharismaAndMinusDays(){
        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get charCharismaValue
        int charCharismaValue = (int) ((SurviveRexburg.getEndUser().getGameCharacter().getcharCharismaValue())*2);
        //get charLuckValue
        int topCharLuckValue = (int) SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int charLuckValue = (int) ((Math.floor(Math.random() * topCharLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (originalSceneValue + charLuckValue + charCharismaValue) - daysPassed;
        
        return finalSceneValue;
    }
    
    private int AddGameLuckCharLuckCharSpeedAndMinusDays() {
        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get charCharismaValue
        int charSpeedValue = (int) ((SurviveRexburg.getEndUser().getGameCharacter().getcharSpeedValue())*2);
        //get charLuckValue
        int charLuckValue = (int) SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int gameLuckValue = (int) ((Math.floor(Math.random() * charLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (int) ((originalSceneValue + gameLuckValue + charSpeedValue) - daysPassed);
        
        return finalSceneValue;
    }
    
    public int AddGameLuckCharLuckCharStrengthMeleeRangedAndMinusDays(){
        //get daysPassed
        int daysPassed = GameControl.game.getDaysPassed();
        //originalSceneValue = random number between 1 & 100
        int originalSceneValue = (int) (Math.floor(Math.random() * 100) + 1);

        //get weapon value
        //int meleeWeapon = SurviveRexburg.getEndUser().getMeleeWeapon().getMeleeWeaponStrengthValue();
        //int rangedWeapon = SurviveRexburg.getEndUser().getRangedWeapon().getRangedWeaponLuckValue();
        //get charStrengthValue
        int charStrengthValue = (int) ((SurviveRexburg.getEndUser().getGameCharacter().getcharStrengthValue())*2);
        //get charLuckValue
        int charLuckValue = (int) SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int gameLuckValue = (int) ((Math.floor(Math.random() * charLuckValue) + 1)*4);
        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (int) ((originalSceneValue + gameLuckValue + charStrengthValue /*+ meleeWeapon + rangedWeapon*/ ) - daysPassed);
        
        return finalSceneValue;
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
