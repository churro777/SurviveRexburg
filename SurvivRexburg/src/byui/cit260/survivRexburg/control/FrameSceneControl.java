/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.sceneFrames.NothingHappensFrame;
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

/**
 *
 * @author arturoaguila
 */
public class FrameSceneControl {
    
    
    //Nothing Happens, survivorsOfferHelp, SurvivorsAskHelp, SurvivrosAttack, ZombiesAttack
    public void decideDoNothingPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 80){
            System.out.println("****NothingHappens****");
            NothingHappensFrame nothingHappensFrame = new NothingHappensFrame();
            nothingHappensFrame.setVisible(true);
        }
        /*
        else if (finalSceneValue <= 79 && finalSceneValue >= 60){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelp survivorsOfferHelp = new SurvivorsOfferHelp();
            survivorsOfferHelp.display();
	}
        */
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
        int fortifyValue = SurviveRexburg.getCurrentGame().getFortifyLevel();
        int sceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        int finalSceneValue = fortifyValue + sceneValue;
        
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
            GameControl.decreaseHealth();
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
            GameControl.decreaseHealth();            
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
        int charCharismaValue = (int) ((SurviveRexburg.getEndUser().getGameCharacter().getcharCharismaValue())*3);
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
        int charSpeedValue = (int) ((SurviveRexburg.getEndUser().getGameCharacter().getcharSpeedValue())*3);
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
        int meleeWeapon = SurviveRexburg.getEndUser().getMeleeWeapon().getMeleeWeaponStrengthValue();
        int rangedWeapon = SurviveRexburg.getEndUser().getRangedWeapon().getRangedWeaponLuckValue();
        //get charStrengthValue
        int charStrengthValue = (int) ((SurviveRexburg.getEndUser().getGameCharacter().getcharStrengthValue())*2);
        //get charLuckValue
        int topCharLuckValue = (int) SurviveRexburg.getEndUser().getGameCharacter().getcharLuckValue();
        //gameLuckValue = (random number between 1 and charLuckValue) * 4
        int charLuckValue = (int) ((Math.floor(Math.random() * topCharLuckValue) + 1)*4);
        
        int meleeStrength = (int) Math.ceil((meleeWeapon + charStrengthValue) * 1.5);
        int rangedLuck = (int) Math.ceil((rangedWeapon + charLuckValue) * 1.5);

        //finalSceneValue = (originalSceneValue + gameLuckValue) - daysPassed
        int finalSceneValue = (int) ((originalSceneValue + charLuckValue + charStrengthValue + meleeStrength + rangedLuck) - daysPassed);
        
        return finalSceneValue;
}
    
    
    
    
}
