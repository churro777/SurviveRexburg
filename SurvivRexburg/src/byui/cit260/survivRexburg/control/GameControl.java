/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;
import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.model.Backpack;
import byui.cit260.surviveRexburg.model.EndUser;
import byui.cit260.surviveRexburg.model.Food;
import byui.cit260.surviveRexburg.model.Game;
import byui.cit260.surviveRexburg.model.GameCharacter;
import byui.cit260.surviveRexburg.model.Location;
import byui.cit260.surviveRexburg.model.Map;
import byui.cit260.surviveRexburg.model.MeleeWeapons;
import byui.cit260.surviveRexburg.model.RangedWeapons;
import byui.cit260.surviveRexburg.model.Scenario;
import byui.cit260.surviveRexburg.model.SpoiledFood;
import byui.cit260.surviveRexburg.view.scenes.KilledByHunger;
import byui.cit260.surviveRexburg.view.scenes.WonGame;


/**
 *
 * @author arturoaguila
 */
public class GameControl {
    
    public static Game game;
    private int gameHungerValue;
    
    
    public static void createNewGame(){
        
        // create new game
        GameControl.game = new Game();
        System.out.println("***Game Created***");
        
        // save as current game
        SurviveRexburg.setCurrentGame(game);
        System.out.println("***Game saved***");
        
        
        //create lists of items - food, spoiled food, melee weapons, ranged weapons
        GameControl.createItemLists();
        System.out.println("****List of Items created****");
        
        //create list of characters that the EndUser can choose from
        GameCharacter[] gameCharacters = GameControl.createCharList();
        GameControl.game.setGameCharacters(gameCharacters);
        System.out.println("***List of Characters created***");
        
        
        //create player object and set hunger and health to 100
        EndUser player = new EndUser();
        SurviveRexburg.setEndUser(player);
        player.setHealth(100);
        player.setHunger(100);
        player.setMeleeWeapon(SurviveRexburg.getCurrentGame().getMeleeWeaponsList()[Constants.FISTS]);
        player.setRangedWeapon(SurviveRexburg.getCurrentGame().getRangedWeaponsList()[Constants.RANGED_FISTS]);
        System.out.println("****Player created****");
        //set player in game object
        //GameControl.game.setEndUser(player);
        System.out.println("***Save Player in Game***");
        
               
        SurviveRexburg.getCurrentGame().setDaysPassed(1);
        System.out.println("****Set DaysPassed to 1");
        
        GameControl.resetFortifyLevel();
        System.out.println("****Set FortifyLevel to 0");
                
        //create different Scenario Lists
        //GameControl.createScenariosLists();
        
        //create backpack and save in game
        Backpack backpack = new Backpack();
        GameControl.game.setBackpack(backpack);
        
        //create map
        Map map = GameControl.createMap();
        GameControl.game.setMap(map);
        
        //move player to starting position
        MapControl.moveActorToStartingLocation(0,3);
        
        //create other control classes
        ScenarioControl scenarioControl = new ScenarioControl();
        SurviveRexburg.setScenarioControl(scenarioControl);
        
        
    }
    
    
    //createNewGame functions
    private static Map createMap() {
        //Create map
        Map map = new Map(8,7);
        
        //Creat list of locations
        Location[] locations = MapControl.createLocationList();
        GameControl.game.setLocations(locations);
        
        //Create all the scenes for the map
        Scenario[] scenarios = ScenarioControl.createOneWayScenariosList();
        
        //Assign the scenes to each location in the map
        ScenarioControl.assignScenarioToLocations(map, scenarios);
        
        return map;
    }

    private static void createEndUser() {
        System.out.println("***createEndUser function runs***");
    }
    
    private static GameCharacter[] createCharList() {
        GameCharacter[] gameCharacters = new GameCharacter[Constants.NUMBER_OF_CHARACTERS];
        
        GameCharacter ben = new GameCharacter(10, 5, 1, 4, "Ben");
        gameCharacters[Constants.BEN] = ben;
        
        GameCharacter bing = new GameCharacter(6, 8, 3, 3, "Bing");
        gameCharacters[Constants.BING] = bing;
        
        GameCharacter hayley = new GameCharacter(1, 5, 6, 8, "Hayley");
        gameCharacters[Constants.HAYLEY] = hayley;
        
        GameCharacter megan = new GameCharacter(6, 2, 8, 4, "Megan");
        gameCharacters[Constants.MEGAN] = megan;
        
        GameCharacter nathan = new GameCharacter(10, 10, 10, 10, "Nathan - Cheat Mode");
        gameCharacters[Constants.NATE]= nathan;
        
        return gameCharacters;
        
    }
          
    

    
    public static void increaseDaysPassed(){
        int oldDays = SurviveRexburg.getCurrentGame().getDaysPassed();
        int newDays = oldDays + 1;
        SurviveRexburg.getCurrentGame().setDaysPassed(newDays);
    }
    
    public static void checkIfThirtyDays(){
        int days = SurviveRexburg.getCurrentGame().getDaysPassed();
        
        if (days == 30){
            WonGame wonGame = new WonGame();
            wonGame.display();
        }
        
    }
    
    public static void increaseFortifyLevel(){
        int oldFortifyLevel = SurviveRexburg.getCurrentGame().getFortifyLevel();
        int newFortifyLevel = oldFortifyLevel + 1;
        SurviveRexburg.getCurrentGame().setFortifyLevel(newFortifyLevel);
    }
    
    public static void resetFortifyLevel(){
        SurviveRexburg.getCurrentGame().setFortifyLevel(0);
    }
    
    public static void decreaseHealth() {
        int charStrength = (int) SurviveRexburg.getEndUser().getGameCharacter().getcharStrengthValue();
        int damage = (int) (Math.floor(Math.random()*25)+11);
        int finalDamage = damage - charStrength;
        
        int oldHealth = SurviveRexburg.getEndUser().getHealth();
        int newHealth = oldHealth - finalDamage;
        
        SurviveRexburg.getEndUser().setHealth(newHealth);
        System.out.println("****Lower Health****");
    }
    
    public static void decreaseCharHunger(){
        int charHungerValue = SurviveRexburg.getEndUser().getHunger();
        
        if (charHungerValue <= 0){
            KilledByHunger killedByHunger = new KilledByHunger();
            killedByHunger.display();
        }

        int gameHungerValue = 10;
        
        int newHunger = charHungerValue - gameHungerValue;

        SurviveRexburg.getEndUser().setHunger(newHunger);
        
        System.out.println("****Hunger decreased****");
    }

    public static void createItemLists(){
        
        //create invetory list - it will be a list of possible items to be obtained
        Food[] foodList = ItemControl.createFoodList();
        GameControl.game.setFoodList(foodList);
        System.out.println("***FoodList created***");
        
        SpoiledFood[] spoiledFoodList = ItemControl.createSpoiledFoodList();
        GameControl.game.setSpoiledFoodList(spoiledFoodList);
        System.out.println("***SpoiledFoodList created***");
        
        MeleeWeapons[] meleeWeaponList = ItemControl.createMeleeWeaponsList();
        GameControl.game.setMeleeWeaponsList(meleeWeaponList);
        System.out.println("***MeleeWeaponsList crated***");
        
        RangedWeapons[] rangedWeaponList = ItemControl.createRangedWeaponList();
        GameControl.game.setRangedWeaponsList(rangedWeaponList);
        System.out.println("***RangedWeaponsList created***");
        
    }
    
    
    
    
   
    
    public static EndUser createPlayer(String playersName) {
        System.out.println("\n**** createPlayer function called ****");
        EndUser player = new EndUser();
        player.setEndUserName(playersName);
        
        SurviveRexburg.setEndUser(player);
        
        return player;
    
    }

    public static void saveGame(Game currentGame) {
        SurviveRexburg.setCurrentGame(game);
        System.out.println("\n**** saveGame stub function called ****");
    }
    
}//end of class
