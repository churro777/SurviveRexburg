/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.sceneFrames.CapturedAndInjuredFrame;
import byui.cit260.surviveRexburg.sceneFrames.CapturedInjuredAndRobbedFrame;
import byui.cit260.surviveRexburg.sceneFrames.DefeatSurvivorsFrame;
import byui.cit260.surviveRexburg.sceneFrames.DefeatSurvivorsGainSuppliesFrame;
import byui.cit260.surviveRexburg.sceneFrames.DefeatZombiesFrame;
import byui.cit260.surviveRexburg.sceneFrames.EscapeAndNewLocationFrame;
import byui.cit260.surviveRexburg.sceneFrames.KilledBySurvivorsFrame;
import byui.cit260.surviveRexburg.sceneFrames.KilledByZombiesFrame;
import byui.cit260.surviveRexburg.sceneFrames.LostFightInjuredFrame;
import byui.cit260.surviveRexburg.sceneFrames.NothingHappensFrame;
import byui.cit260.surviveRexburg.sceneFrames.ScavengedFoundItemFrame;
import byui.cit260.surviveRexburg.sceneFrames.ScavengedNoItem;
import byui.cit260.surviveRexburg.sceneFrames.SurvivorsAskHelpFrame;
import byui.cit260.surviveRexburg.sceneFrames.SurvivorsAttackFrame;
import byui.cit260.surviveRexburg.sceneFrames.SurvivorsGiveItemFrame;
import byui.cit260.surviveRexburg.sceneFrames.SurvivorsKeepAttackingFrame;
import byui.cit260.surviveRexburg.sceneFrames.SurvivorsLeaveFrame;
import byui.cit260.surviveRexburg.sceneFrames.SurvivorsListenFrame;
import byui.cit260.surviveRexburg.sceneFrames.SurvivorsOfferHelpFrame;
import byui.cit260.surviveRexburg.sceneFrames.SurvivorsRefuseItemFrame;
import byui.cit260.surviveRexburg.sceneFrames.SurvivorsTakeItemAndLeaveFrame;
import byui.cit260.surviveRexburg.sceneFrames.TrickedSurvivorsAttack;
import byui.cit260.surviveRexburg.sceneFrames.ZombieAttackFrame;


/**
 *
 * @author arturoaguila
 */
public class FrameSceneControl {
    
    
    //Nothing Happens, survivorsOfferHelp, SurvivorsAskHelp, SurvivrosAttack, ZombiesAttack
    public void decideFrameDoNothingPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 80){
            System.out.println("****NothingHappens****");
            NothingHappensFrame nothingHappensFrame = new NothingHappensFrame();
            nothingHappensFrame.setVisible(true);
        }
        else if (finalSceneValue <= 79 && finalSceneValue >= 60){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelpFrame survivorsOfferHelpFrame = new SurvivorsOfferHelpFrame();
            survivorsOfferHelpFrame.setVisible(true);
	}
	else if (finalSceneValue <= 59 && finalSceneValue >= 40){
            System.out.println("****SurvivorsAskHelp****");
            SurvivorsAskHelpFrame survivorsAskHelpFrame = new SurvivorsAskHelpFrame();
            survivorsAskHelpFrame.setVisible(true);
	}
	else if (finalSceneValue <= 39 && finalSceneValue >= 20){
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true);
        }
	else{
            System.out.println("****ZombiesAttack****");
            ZombieAttackFrame zombieAttackFrame = new ZombieAttackFrame();
            zombieAttackFrame.setVisible(true);
	}           
        
    }
    
    //NothingHappens, SurvivorsOfferHelp, SurvivorsAskHelp
    public void decideFrameFortifyPossibilities(){
        int fortifyValue = SurviveRexburg.getCurrentGame().getFortifyLevel();
        int sceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        int finalSceneValue = fortifyValue + sceneValue;
        
        //IF finalSceneValue >= 66
        if (finalSceneValue >= 66){
            System.out.println("****NothingHappens****");
            NothingHappensFrame nothingHappensFrame = new NothingHappensFrame();
            nothingHappensFrame.setVisible(true);
        }
        else if (finalSceneValue <= 65 && finalSceneValue >= 33){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelpFrame survivorsOfferHelpFrame = new SurvivorsOfferHelpFrame();
            survivorsOfferHelpFrame.setVisible(true);
	}
        else {
            System.out.println("****SurvivorsAskHelp****");
            SurvivorsAskHelpFrame survivorsAskHelpFrame = new SurvivorsAskHelpFrame();
            survivorsAskHelpFrame.setVisible(true);
	}
        
    }
    
    //NothingHappens, SurvivorsOfferHelp, SurvivorsAskHelp,SurvivorsAttack, ZombiesAttack
    public void decideFrameExplorePossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 80){
            NothingHappensFrame nothingHappensFrame = new NothingHappensFrame();
            nothingHappensFrame.setVisible(true);
        }
        else if (finalSceneValue <= 79 && finalSceneValue >= 60){
            SurvivorsOfferHelpFrame survivorsOfferHelpFrame = new SurvivorsOfferHelpFrame();
            survivorsOfferHelpFrame.setVisible(true);
	}
	else if (finalSceneValue <= 59 && finalSceneValue >= 40){
            SurvivorsAskHelpFrame survivorsAskHelpFrame = new SurvivorsAskHelpFrame();
            survivorsAskHelpFrame.setVisible(true);
	}
	else if (finalSceneValue <= 39 && finalSceneValue >= 20){
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true);
        }
	else{
            ZombieAttackFrame zombieAttackFrame = new ZombieAttackFrame();
            zombieAttackFrame.setVisible(true);
	}
        
    }
    
    //ScavengeFountItem, ScavengeNoItem, SurvivorsOfferHelp,SurvivorsAskHelp, SurvivorsAttack,ZombiesAttack
    public void decideFrameScavengePossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 83){
            ItemControl.gainRandomFood();
            System.out.println("****ScavengeFoundItem****");
            ScavengedFoundItemFrame  scavengedFoundItemFrame = new ScavengedFoundItemFrame();
            scavengedFoundItemFrame.setVisible(true);
        }
        else if (finalSceneValue <= 82 && finalSceneValue >= 66){
            System.out.println("****ScavengeNoItem****");
            ScavengedNoItem scavengedNoItem = new ScavengedNoItem();
            scavengedNoItem.setVisible(true);
            
	}
	else if (finalSceneValue <= 65 && finalSceneValue >= 49){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelpFrame survivorsOfferHelpFrame = new SurvivorsOfferHelpFrame();
            survivorsOfferHelpFrame.setVisible(true);
	}
	else if (finalSceneValue <= 48 && finalSceneValue >= 32){
            SurvivorsAskHelpFrame survivorsAskHelpFrame = new SurvivorsAskHelpFrame();
            survivorsAskHelpFrame.setVisible(true);
        }
        else if (finalSceneValue <= 31 && finalSceneValue >= 15){
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true);
        }
	else{
            System.out.println("****ZombiesAttack****");
            ZombieAttackFrame zombieAttackFrame = new ZombieAttackFrame();
            zombieAttackFrame.setVisible(true);
	}
        
    }
    
    //SurvivorsGiveItem, SurvivorsAttack
    public void decideFrameAcceptHelpPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 50){
            ItemControl.gainRandomFood();
            System.out.println("****SurvivorsGiveItem****");
            SurvivorsGiveItemFrame survivorsGiveItemFrame = new SurvivorsGiveItemFrame();
            survivorsGiveItemFrame.setVisible(true);
        }
        else {
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true);
	}           
        
    }
    
    //SurvivorsLeave, SurvivorsAttack
    public void decideFrameDenyHelpPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****SurvivorsLeave****");
            SurvivorsLeaveFrame survivorsLeaveFrame = new SurvivorsLeaveFrame();
            survivorsLeaveFrame.setVisible(true);
        }
        else {
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true); 
	}
    }
    
    //SurvivorsLeave, SurvivorsAttack
    public void decideFrameRefuseHelpPossiblity(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****SurvivorsLeave****");
            SurvivorsLeaveFrame survivorsLeaveFrame = new SurvivorsLeaveFrame();
            survivorsLeaveFrame.setVisible(true);
        }
        else {
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true);  
	}
    }
    
    //EscapeAndNewLocation, CapturedAndInjured, CapturedInjuredAndRobbed, KilledBySurvivors
    public void decideFrameRunAwayPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharSpeedAndMinusDays();
        
        //IF finalSceneValue >= 80
        if (finalSceneValue >= 75){
            GameControl.newLocation();
            System.out.print("****Escape + Random Location + Day Ends****");
            EscapeAndNewLocationFrame escapeNewLocationFrame = new EscapeAndNewLocationFrame();
            escapeNewLocationFrame.setVisible(true);
        }
        else if(finalSceneValue <=74 && finalSceneValue >= 50){           
            GameControl.decreaseHealth();
            System.out.print("****Captures + Injured****");
            CapturedAndInjuredFrame capturedAndInjuredFrame = new CapturedAndInjuredFrame();
            capturedAndInjuredFrame.setVisible(true);
        }
        else if(finalSceneValue <=49 && finalSceneValue >= 25){
            GameControl.decreaseHealth();
            System.out.println("****Captured + Injured + Robbed****");
            CapturedInjuredAndRobbedFrame capturedInjuredAndRobbedFrame = new CapturedInjuredAndRobbedFrame();
            capturedInjuredAndRobbedFrame.setVisible(true);
        }
        else {
            System.out.println("****Killed by Survivors***");
            KilledBySurvivorsFrame killedBySurvivorsFrame = new KilledBySurvivorsFrame();
            killedBySurvivorsFrame.setVisible(true);
	}
  
    }
    
    //SurvivorsListen, SurvivorsKeepAttacking
    public void decideFrameNegotiatePossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        //IF finalSceneValue >= 50
        if (finalSceneValue >= 50){
            System.out.print("****SurvivorsListen****");
            SurvivorsListenFrame survivorsListenFrame = new SurvivorsListenFrame();
            survivorsListenFrame.setVisible(true);
        }
        else {
            System.out.println("****SurvivorsKeepAttacking***");
            SurvivorsKeepAttackingFrame survivorsKeepAttackingFrame = new SurvivorsKeepAttackingFrame();
            survivorsKeepAttackingFrame.setVisible(true);
	}            
        
    }
    
    //SurvivorsTakeItemAndLeave, TrickedSurvivorsAttack
    public void decideFrameOfferingPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****Took Item and Left****");
            SurvivorsTakeItemAndLeaveFrame takeItemLeaveFrame = new SurvivorsTakeItemAndLeaveFrame();
            takeItemLeaveFrame.setVisible(true);
        }
        else {
            System.out.println("****SurvivorsRefuseItem****");
            SurvivorsRefuseItemFrame survivorsRefuseItemFrame = new SurvivorsRefuseItemFrame();
            survivorsRefuseItemFrame.setVisible(true);
        }
    }
    
    //SurvivorsTakeItemAndLeave, TrickedSurvivorsAttack
    public void decideFrameHelpSurvivorsPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****Took Item and Left****");
            SurvivorsTakeItemAndLeaveFrame takeItemLeaveFrame = new SurvivorsTakeItemAndLeaveFrame();
            takeItemLeaveFrame.setVisible(true);
        }
        else {
            System.out.println("****Tricked!Survivors Attack****");
            TrickedSurvivorsAttack trickedSurvivorsAttack = new TrickedSurvivorsAttack();
            trickedSurvivorsAttack.setVisible(true);
        }
    }
    
    //DefeatSurvivorsGainSupplies, DefeatSurvivors, LostFightLostHealth, KilledBySurvivors
    public void decideFrameFightSurvivorsPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharStrengthMeleeRangedAndMinusDays();
        
        if (finalSceneValue >= 75){
            System.out.println("****DefeatSurvivorsGainSupplies****");
            DefeatSurvivorsGainSuppliesFrame defeatSurvivorsGainSuppliesFrame = new DefeatSurvivorsGainSuppliesFrame();
            defeatSurvivorsGainSuppliesFrame.setVisible(true);
        }
        else if (finalSceneValue <= 74 && finalSceneValue >= 50){
            System.out.println("****DefeatSurvivors****");
            DefeatSurvivorsFrame defeatSurvivorsFrame = new DefeatSurvivorsFrame();
            defeatSurvivorsFrame.setVisible(true);
        }
        else if (finalSceneValue <= 49 && finalSceneValue >= 25){
            GameControl.decreaseHealth();            
            System.out.println("****LostFightLostHealth");
            LostFightInjuredFrame lostFightInjuredFrame = new LostFightInjuredFrame();
            lostFightInjuredFrame.setVisible(true);
        }
        else {
            System.out.println("****KilledBySurvivors****");
            KilledBySurvivorsFrame killedBySurvivorsFrame = new KilledBySurvivorsFrame();
            killedBySurvivorsFrame.setVisible(true);
        }
        
    }
    
    //EscapeAndNewLocation, KilledByZombies
    public void decideFrameRunAwayFromZombiesPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharSpeedAndMinusDays();
        if (finalSceneValue >= 50){
            GameControl.newLocation();
            System.out.println("****Escaped Zombies + New Location****");
            EscapeAndNewLocationFrame escapeAndNewLocationFrame = new EscapeAndNewLocationFrame();
            escapeAndNewLocationFrame.setVisible(true);
        }
        else {
            System.out.println("****Killed by zombies****");
            KilledByZombiesFrame killedByZombiesFrame = new KilledByZombiesFrame();
            killedByZombiesFrame.setVisible(true);
        }
        
    }
    
    //DefeatZombies, KilledByZombies
    public void decideFrameFightZombiesPossibility(){
        int finalSceneValue = this.AddGameLuckCharLuckCharStrengthMeleeRangedAndMinusDays();
        
        if (finalSceneValue >= 50){
            System.out.println("****DefeatZombies****");
            DefeatZombiesFrame defeatZombiesFrame = new DefeatZombiesFrame();
            defeatZombiesFrame.setVisible(true);
        }
        else{
            System.out.println("****KilledByZombies****");
            KilledByZombiesFrame killedByZombiesFrame = new KilledByZombiesFrame();
            killedByZombiesFrame.setVisible(true);
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
