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
    public static void decideFrameDoNothingPossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckAndMinusDays();
        
        //10%
        if (finalSceneValue >= 90){
            System.out.println("****NothingHappens****");
            NothingHappensFrame nothingHappensFrame = new NothingHappensFrame();
            nothingHappensFrame.setVisible(true);
        }
        //15%
        else if (finalSceneValue <= 89 && finalSceneValue >= 76){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelpFrame survivorsOfferHelpFrame = new SurvivorsOfferHelpFrame();
            survivorsOfferHelpFrame.setVisible(true);
	}
        //25%
	else if (finalSceneValue <= 75 && finalSceneValue >= 51){
            System.out.println("****SurvivorsAskHelp****");
            SurvivorsAskHelpFrame survivorsAskHelpFrame = new SurvivorsAskHelpFrame();
            survivorsAskHelpFrame.setVisible(true);
	}
        //20%
	else if (finalSceneValue <= 50 && finalSceneValue >= 30){
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true);
        }
        //30%
	else{
            System.out.println("****ZombiesAttack****");
            ZombieAttackFrame zombieAttackFrame = new ZombieAttackFrame();
            zombieAttackFrame.setVisible(true);
	}           
        
    }
    
    //NothingHappens, SurvivorsOfferHelp, SurvivorsAskHelp
    public static void decideFrameFortifyPossibilities(){
        int fortifyValue = SurviveRexburg.getCurrentGame().getFortifyLevel();
        int sceneValue = FrameSceneControl.AddGameLuckCharLuckAndMinusDays();
        
        int finalSceneValue = fortifyValue + sceneValue;
        
        //20%
        if (finalSceneValue >= 80){
            System.out.println("****NothingHappens****");
            NothingHappensFrame nothingHappensFrame = new NothingHappensFrame();
            nothingHappensFrame.setVisible(true);
        }
        //30%
        else if (finalSceneValue <= 79 && finalSceneValue >= 50){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelpFrame survivorsOfferHelpFrame = new SurvivorsOfferHelpFrame();
            survivorsOfferHelpFrame.setVisible(true);
	}
        //50%
        else {
            System.out.println("****SurvivorsAskHelp****");
            SurvivorsAskHelpFrame survivorsAskHelpFrame = new SurvivorsAskHelpFrame();
            survivorsAskHelpFrame.setVisible(true);
	}
        
    }
    
    //NothingHappens, SurvivorsOfferHelp, SurvivorsAskHelp,SurvivorsAttack, ZombiesAttack
    public static void decideFrameExplorePossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckAndMinusDays();
        
        GameControl.resetFortifyLevel();
        
        //15%
        if (finalSceneValue >= 90){
            ScavengedFoundItemFrame foundItemFrame = new ScavengedFoundItemFrame();
            foundItemFrame.setVisible(true);
        }
        //5%
        else if (finalSceneValue <= 85 && finalSceneValue >= 80){
            NothingHappensFrame nothingHappensFrame = new NothingHappensFrame();
            nothingHappensFrame.setVisible(true);
        }
        //75%
        else if (finalSceneValue <= 79 && finalSceneValue >= 65){
            SurvivorsOfferHelpFrame survivorsOfferHelpFrame = new SurvivorsOfferHelpFrame();
            survivorsOfferHelpFrame.setVisible(true);
	}
        //25%
	else if (finalSceneValue <= 64 && finalSceneValue >= 40){
            SurvivorsAskHelpFrame survivorsAskHelpFrame = new SurvivorsAskHelpFrame();
            survivorsAskHelpFrame.setVisible(true);
	}
        //15%
	else if (finalSceneValue <= 39 && finalSceneValue >= 25){
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true);
        }
        //25%
	else{
            ZombieAttackFrame zombieAttackFrame = new ZombieAttackFrame();
            zombieAttackFrame.setVisible(true);
	}
        
    }
    
    //ScavengeFountItem, ScavengeNoItem, SurvivorsOfferHelp,SurvivorsAskHelp, SurvivorsAttack,ZombiesAttack
    public static void decideFrameScavengePossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckAndMinusDays();
        
        //17%
        if (finalSceneValue >= 83){
            ItemControl.gainRandomFood();
            System.out.println("****ScavengeFoundItem****");
            ScavengedFoundItemFrame  scavengedFoundItemFrame = new ScavengedFoundItemFrame();
            scavengedFoundItemFrame.setVisible(true);
        }
        //17%
        else if (finalSceneValue <= 82 && finalSceneValue >= 66){
            System.out.println("****ScavengeNoItem****");
            ScavengedNoItem scavengedNoItem = new ScavengedNoItem();
            scavengedNoItem.setVisible(true);
	}
        //10%
	else if (finalSceneValue <= 65 && finalSceneValue >= 55){
            System.out.println("****SurvivorsOfferHelp****");
            SurvivorsOfferHelpFrame survivorsOfferHelpFrame = new SurvivorsOfferHelpFrame();
            survivorsOfferHelpFrame.setVisible(true);
	}
        //15%
	else if (finalSceneValue <= 54 && finalSceneValue >= 40){
            SurvivorsAskHelpFrame survivorsAskHelpFrame = new SurvivorsAskHelpFrame();
            survivorsAskHelpFrame.setVisible(true);
        }
        //15
        else if (finalSceneValue <= 39 && finalSceneValue >= 25){
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true);
        }
        //24%
	else{
            System.out.println("****ZombiesAttack****");
            ZombieAttackFrame zombieAttackFrame = new ZombieAttackFrame();
            zombieAttackFrame.setVisible(true);
	}
        
    }
    
    //SurvivorsGiveItem, SurvivorsAttack
    public static void decideFrameAcceptHelpPossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
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
    public static void decideFrameDenyHelpPossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        //25%
        if (finalSceneValue >= 75){
            System.out.println("****SurvivorsLeave****");
            SurvivorsLeaveFrame survivorsLeaveFrame = new SurvivorsLeaveFrame();
            survivorsLeaveFrame.setVisible(true);
        }
        //75%
        else {
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true); 
	}
    }
    
    //SurvivorsLeave, SurvivorsAttack
    public static void decideFrameRefuseHelpPossiblity(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        //60%
        if (finalSceneValue >= 40){
            System.out.println("****SurvivorsLeave****");
            SurvivorsLeaveFrame survivorsLeaveFrame = new SurvivorsLeaveFrame();
            survivorsLeaveFrame.setVisible(true);
        }
        //40%
        else {
            System.out.println("****SurvivorsAttack****");
            SurvivorsAttackFrame survivorsAttackFrame = new SurvivorsAttackFrame();
            survivorsAttackFrame.setVisible(true);  
	}
    }
    
    //EscapeAndNewLocation, CapturedAndInjured, CapturedInjuredAndRobbed, KilledBySurvivors
    public static void decideFrameRunAwayPossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharSpeedAndMinusDays();
        
        //25%
        if (finalSceneValue >= 75){
            MapControl.newRandomLotion();
            System.out.print("****Escape + Random Location + Day Ends****");
            EscapeAndNewLocationFrame escapeNewLocationFrame = new EscapeAndNewLocationFrame();
            escapeNewLocationFrame.setVisible(true);
        }
        //20%
        else if(finalSceneValue <=74 && finalSceneValue >= 56){           
            GameControl.decreaseHealth();
            System.out.print("****Captures + Injured****");
            CapturedAndInjuredFrame capturedAndInjuredFrame = new CapturedAndInjuredFrame();
            capturedAndInjuredFrame.setVisible(true);
        }
        //25%
        else if(finalSceneValue <= 55 && finalSceneValue >= 30){
            GameControl.decreaseHealth();
            ItemControl.loseRandomItem();
            System.out.println("****Captured + Injured + Robbed****");
            CapturedInjuredAndRobbedFrame capturedInjuredAndRobbedFrame = new CapturedInjuredAndRobbedFrame();
            capturedInjuredAndRobbedFrame.setVisible(true);
        }
        //30%
        else {
            System.out.println("****Killed by Survivors***");
            KilledBySurvivorsFrame killedBySurvivorsFrame = new KilledBySurvivorsFrame();
            killedBySurvivorsFrame.setVisible(true);
	}
  
    }
    
    //SurvivorsListen, SurvivorsKeepAttacking
    public static void decideFrameNegotiatePossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
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
    public static void decideFrameOfferingPossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 50){
            ItemControl.loseRandomItem();
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
    public static void decideFrameHelpSurvivorsPossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharCharismaAndMinusDays();
        
        if (finalSceneValue >= 70){
            ItemControl.loseRandomItem();
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
    public static void decideFrameFightSurvivorsPossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharStrengthMeleeRangedAndMinusDays();
        
        //20%
        if (finalSceneValue >= 80){
            System.out.println("****DefeatSurvivorsGainSupplies****");
            ItemControl.gainRandomFood();
            DefeatSurvivorsGainSuppliesFrame defeatSurvivorsGainSuppliesFrame = new DefeatSurvivorsGainSuppliesFrame();
            defeatSurvivorsGainSuppliesFrame.setVisible(true);
        }
        //25%
        else if (finalSceneValue <= 79 && finalSceneValue >= 55){
            System.out.println("****DefeatSurvivors****");
            DefeatSurvivorsFrame defeatSurvivorsFrame = new DefeatSurvivorsFrame();
            defeatSurvivorsFrame.setVisible(true);
        }
        //15%
        else if (finalSceneValue <= 54 && finalSceneValue >= 40){
            GameControl.decreaseHealth();            
            System.out.println("****LostFightLostHealth");
            LostFightInjuredFrame lostFightInjuredFrame = new LostFightInjuredFrame();
            lostFightInjuredFrame.setVisible(true);
        }
        //40%
        else {
            System.out.println("****KilledBySurvivors****");
            KilledBySurvivorsFrame killedBySurvivorsFrame = new KilledBySurvivorsFrame();
            killedBySurvivorsFrame.setVisible(true);
        }
        
    }
    
    //EscapeAndNewLocation, KilledByZombies
    public static void decideFrameRunAwayFromZombiesPossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharSpeedAndMinusDays();
        if (finalSceneValue >= 65){
            MapControl.newRandomLotion();
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
    public static void decideFrameFightZombiesPossibility(){
        int finalSceneValue = FrameSceneControl.AddGameLuckCharLuckCharStrengthMeleeRangedAndMinusDays();
        
        if (finalSceneValue >= 75){
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
    
    
    public static int AddGameLuckCharLuckAndMinusDays(){
        //get daysPassed
        int daysPassed = (int) Math.floor(GameControl.game.getDaysPassed() * 2);
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
    
    public static int AddGameLuckCharLuckCharCharismaAndMinusDays(){
        //get daysPassed
        int daysPassed = (int) Math.floor(GameControl.game.getDaysPassed() * 2);
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
    
    private static int AddGameLuckCharLuckCharSpeedAndMinusDays() {
        //get daysPassed
        int daysPassed = (int) Math.floor(GameControl.game.getDaysPassed() * 2);
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
    
    public static int AddGameLuckCharLuckCharStrengthMeleeRangedAndMinusDays(){
        //get daysPassed
        int daysPassed = (int) Math.floor(GameControl.game.getDaysPassed() * 2);
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
