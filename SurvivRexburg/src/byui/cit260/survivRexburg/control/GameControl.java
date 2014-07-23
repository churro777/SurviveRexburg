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
import byui.cit260.surviveRexburg.model.InventoryItems;
import byui.cit260.surviveRexburg.model.Location;
import byui.cit260.surviveRexburg.model.Map;
import byui.cit260.surviveRexburg.model.MeleeWeapons;
import byui.cit260.surviveRexburg.model.RangedWeapons;
import byui.cit260.surviveRexburg.model.Scenario;
import byui.cit260.surviveRexburg.model.SpoiledFood;
import byui.cit260.surviveRexburg.sceneFrames.KilledByHungerFrame;
import byui.cit260.surviveRexburg.sceneFrames.WonGameFrame;
import byui.cit260.surviveRexburg.sceneFrames.startDayFrame;
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
        SurviveRexburg.setCurrentGame(GameControl.game);
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
        SurviveRexburg.getCurrentGame().setEndUser(player);
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
        System.out.println("****Set DaysPassed to 1****");
        
        GameControl.resetFortifyLevel();
        System.out.println("****Set FortifyLevel to 0****");
                
        //create different Scenario Lists
        //GameControl.createScenariosLists();
        
        ItemControl itemControl = new ItemControl();
        SurviveRexburg.setItemControl(itemControl);
        System.out.println("****Create ItemControl****");
        
        //create backpack and save in game
        ItemControl.createBackpack();
        System.out.println("****Create Backpack****");
        ItemControl.putFoodInBackpack();
        SurviveRexburg.getItemControl().setDisplayItemName("None");
        
        //create map
        Map map = GameControl.createMap();
        GameControl.game.setMap(map);
        System.out.println("****Create Map and set it in game****");
        
        //move player to starting position
        MapControl.moveActorToStartingLocation();
        
        //create other control classes
        ScenarioControl scenarioControl = new ScenarioControl();
        SurviveRexburg.setScenarioControl(scenarioControl);
        System.out.println("****Create ScenarioControl****");
        
        FrameSceneControl frameControl = new FrameSceneControl();
        SurviveRexburg.setFrameSceneControl(frameControl);
        System.out.println("****Create FrameControl****");
        
        MapControl mapControl = new MapControl();
        SurviveRexburg.setMapControl(mapControl);
        
        
        
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
        else{
            startDayFrame startDay = new startDayFrame();
            startDay.setVisible(true);
        }
        
    }
    
    public static void checkIfThirtyDaysFrame(){
        int days = SurviveRexburg.getCurrentGame().getDaysPassed();
        
        if (days == 30){
            WonGameFrame wonGame = new WonGameFrame();
            wonGame.setVisible(true);
        }
        
    }
    
    public static void checkIfHungerIsZero(){
        int hunger = SurviveRexburg.getEndUser().getHunger();
        
        if (hunger < 1){
            KilledByHungerFrame killedByHunger = new KilledByHungerFrame();
            killedByHunger.setVisible(true);
        }
        else{
            startDayFrame startDay = new startDayFrame();
            startDay.setVisible(true);
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
    
    public static void increaseHealth(){
        int oldHealth = SurviveRexburg.getEndUser().getHealth();
        int newHealth = oldHealth + 15;
        
        SurviveRexburg.getEndUser().setHealth(newHealth);
        System.out.println("****Incrase Health****");
    }
    
    public static void increaseHunger(){
        int oldHunger = SurviveRexburg.getEndUser().getHunger();
        int newHunger = oldHunger + 15;
        
        SurviveRexburg.getEndUser().setHunger(newHunger);
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
    
    public static void decreaseHunger(){
        int charHungerValue = SurviveRexburg.getEndUser().getHunger();        
        int newHunger = charHungerValue - 10;

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
        System.out.println("***MeleeWeaponsList created***");
        
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
