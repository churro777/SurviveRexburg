/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.model.Backpack;
import byui.cit260.surviveRexburg.model.EndUser;
import byui.cit260.surviveRexburg.model.Game;
import byui.cit260.surviveRexburg.model.GameCharacter;
import byui.cit260.surviveRexburg.model.InventoryItems;
import byui.cit260.surviveRexburg.model.Location;
import byui.cit260.surviveRexburg.model.Map;
import byui.cit260.surviveRexburg.model.Scenario;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author arturoaguila
 */
public class GameControl {
    
    private static Game game;
    private int gameHungerValue;
    
    
    public static void createNewGame(EndUser endUser){
        
        // create new game
        GameControl.game = new Game();
        
        // save as current game
        SurviveRexburg.setCurrentGame(game);
        
        //set player in game object
        GameControl.game.setEndUser(SurviveRexburg.getEndUser());
        
        //create list of characters that the EndUser can choose from
        GameCharacter[] gameCharacters = GameControl.createCharList();
        GameControl.game.setGameCharacters(gameCharacters);
        
        //create invetory list - it will be a list of possible items to be obtained
        InventoryItems[] inventoryList = GameControl.createInventoryList();
        GameControl.game.setInventoryItems(inventoryList);
        
        //create backpack and save in game
        Backpack backpack = new Backpack();
        GameControl.game.setBackpack(backpack);
        
        //creates map
        Map map = GameControl.createMap();
        GameControl.game.setMap(map);
        
        //move player to starting position
        MapControl.moveActorToStartingLocation(0,3);
        
    }
    
    
    //createNewGame functions
    private static Map createMap() {
        //Create map
        Map map = new Map(8,7);
        
        //Create all the scenes for the map
        Scenario[] scenarios = createScenarios();
        
        //Assign the scenes to each location in the map
        GameControl.assignScenarioToLocations(map, scenarios);
        
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
        
        return gameCharacters;
        
    }
    
    
    private static InventoryItems[] createInventoryList() {
        InventoryItems[] inventoryItems = new InventoryItems[Constants.NUMBER_OF_ITEMS];
    
        //food inventory
        InventoryItems cannedTuna = new InventoryItems(1, "Food","Canned Tuna");
        inventoryItems[Constants.CANNED_TUNA] = cannedTuna;
        
        InventoryItems cannedBeans = new InventoryItems(1, "Food", "Canned Beans");
        inventoryItems[Constants.CANNED_BEANS] = cannedBeans;
        
        InventoryItems mangos = new InventoryItems(3, "Food", "Mangos");
        inventoryItems[Constants.MANGOS] = mangos;
        
        InventoryItems cannedChicken = new InventoryItems (1, "Food", "Canned Chicken");
        inventoryItems[Constants.CANNED_CHICKEN] = cannedChicken;
        
        InventoryItems cannedBeefStew = new InventoryItems(1, "Food", "Canned Beef Stew");
        inventoryItems [Constants.CANED_BEEF_STEW] = cannedBeefStew;
        
        InventoryItems apples = new InventoryItems(2, "Food", "Apples");
        inventoryItems [Constants.APPLES] = apples;
        
        InventoryItems bananas = new InventoryItems(2, "Food", "Bananas");
        inventoryItems [Constants.BANANAS] = bananas;
        
        InventoryItems saltineCrackers = new InventoryItems(1, "Food", "Saltine Crackers");
        inventoryItems [Constants.SALTINE_CRACKERS] = saltineCrackers;
        
        InventoryItems cannedChickenSoup = new InventoryItems(1, "Food", "Canned Chicken Soup");
        inventoryItems [Constants.CANNED_CHICKEN_SOUP] = cannedChickenSoup;
        
        InventoryItems milk = new InventoryItems(3, "Food", "Milk");
        inventoryItems [Constants.MILK] = milk;
        
        InventoryItems potatoes = new InventoryItems(2, "Food", "Potatoes");
        inventoryItems [Constants.POTATOES] = potatoes;
        
        InventoryItems bread = new InventoryItems(1, "Food", "Bread");
        inventoryItems [Constants.BREAD] = bread;
        
        InventoryItems cheese = new InventoryItems(1, "Food", "Cheese");
        inventoryItems [Constants.CHEESE] = cheese;
        
        InventoryItems cereal = new InventoryItems(1, "Food", "Cereal");
        inventoryItems [Constants.CEREAL] = cereal;
        
        InventoryItems eggs = new InventoryItems(1, "Food", "Eggs");
        inventoryItems [Constants.EGGS] = eggs;
        
        InventoryItems topRamen = new InventoryItems(1, "Food", "Top Ramen");
        inventoryItems [Constants.TOP_RAMEN] = topRamen;
        
        InventoryItems chocolate = new InventoryItems (1, "Food", "Chocolate");
        inventoryItems [Constants.CHOCOLATE] = chocolate;
        
        InventoryItems soda = new InventoryItems (1, "Food", "Chocolate");
        inventoryItems [Constants.SODA]  = soda;
                
        //spoiled food
        InventoryItems rottenEggs = new InventoryItems (1, "Spoiled Food", "Rotten Eggs");
        inventoryItems [Constants.ROTTEN_EGGS] = rottenEggs;
        
        InventoryItems moldyCheese = new InventoryItems (1, "Spoiled Food", "Moldy Cheese");
        inventoryItems [Constants.MOLDY_CHEESE] = moldyCheese;
        
        InventoryItems sourMilk = new InventoryItems (3, "Spoiled Food", "Sour Milk");
        inventoryItems [Constants.SOUR_MILK] = sourMilk;
        
        InventoryItems moldyBread = new InventoryItems (1, "Spoiled Food", "Moldy Bread");
        inventoryItems [Constants.MOLDY_BREAD] = moldyBread;
        
        InventoryItems rottenMangos = new InventoryItems (3, "Spoiled Food", "Rotten Mangos");
        inventoryItems [Constants.ROTTEN_MANGO] = rottenMangos;
        
        InventoryItems rottenApples = new InventoryItems (2, "Spoiled Food", "Rotten Apples");
        inventoryItems [Constants.ROTTEN_APPLE] = rottenApples;
        
        InventoryItems rottenBananas = new InventoryItems (2, "Spoiled Food", "Rotten Bananas");
        inventoryItems [Constants.ROTTEN_BANANA] = rottenBananas;
        
        //melee weapons
        InventoryItems baseballBat = new InventoryItems(4, "Melee Weapon", "Baseball Bat");
        inventoryItems[Constants.BASEBALL_BAT] = baseballBat;
        
        InventoryItems sledgeHammer = new InventoryItems(15, "Melee Weapon", "Sledge Hammer");
        inventoryItems[Constants.SLEDGE_HAMMER] = sledgeHammer;
        
        InventoryItems hammer = new InventoryItems(15, "Melee Weapon", "Hammer");
        inventoryItems[Constants.HAMMER] = hammer;
        
        InventoryItems golfClub = new InventoryItems(3, "Melee Weapon", "Golf Club");
        inventoryItems[Constants.GOLF_CLUB] = golfClub;
        
        InventoryItems steakKnife = new InventoryItems(2, "Melee Weapon", "Steak Knife");
        inventoryItems[Constants.STEAK_KNIFE] = steakKnife;
        
        InventoryItems tennisRacket = new InventoryItems(5, "Melee Weapon", "Tennis Racket");
        inventoryItems[Constants.TENNIS_RACKET] = tennisRacket;
        
        //ranged weapons
        InventoryItems shotgun = new InventoryItems(8, "Ranged Weapon", "Shotgun");
        inventoryItems[Constants.SHOTGUN] = shotgun;
        
        InventoryItems huntingRifle = new InventoryItems(7, "Ranged Weapon", "Shotgun");
        inventoryItems[Constants.HUNTING_RIFLE] = huntingRifle;
        
        InventoryItems handgun = new InventoryItems(2, "Ranged Weapon", "Handgun");
        inventoryItems[Constants.HANDGUN] = handgun;
        
        InventoryItems bowAndArrow = new InventoryItems(3, "Ranged Weapon", "Bow and Arrow");
        inventoryItems[Constants.BOW_AND_ARROW] = bowAndArrow;
        
        //random weapons
        InventoryItems laptop = new InventoryItems(20, "Random Item", "Laptop");
        inventoryItems[Constants.LAPTOP] = laptop;
        
        InventoryItems textbook = new InventoryItems(8, "Random Item", "Laptop");
        inventoryItems[Constants.TEXTBOOK] = textbook;
        
        InventoryItems boots = new InventoryItems(4, "Random Item", "Boots");
        inventoryItems[Constants.BOOTS] = boots;
        
        InventoryItems stuffedAnimals = new InventoryItems(3, "Random Item", "Stuffed Animals");
        inventoryItems[Constants.STUFFED_ANIMALS] = stuffedAnimals;
        
        InventoryItems fryingPan = new InventoryItems(3, "Random Item", "Frying Pan");
        inventoryItems[Constants.FRYING_PAN] = fryingPan;
        
        InventoryItems soccerBall = new InventoryItems(2, "Random Item", "Soccer Ball");
        inventoryItems[Constants.SOCCER_BALL] = soccerBall;
        
        InventoryItems basketBall = new InventoryItems(2, "Random Item", "Basketball");
        inventoryItems[Constants.BASKETBALL] = basketBall;
        
        InventoryItems notebook = new InventoryItems(1, "Random Item", "Notebook");
        inventoryItems [Constants.NOTEBOOK] = notebook;
        
        InventoryItems tvRemote = new InventoryItems(1, "Random Item", "TV Remote");
        inventoryItems [Constants.TV_REMOTE] = tvRemote;
        
        InventoryItems keys = new InventoryItems(1, "Random Item", "Keys");
        inventoryItems [Constants.KEYS] = keys;
        
        InventoryItems fishingRod = new InventoryItems(1, "Random Item", "Fishing Rod");
        inventoryItems [Constants.FISHING_ROD] = fishingRod;
        
        InventoryItems tennisBall = new InventoryItems(1, "Random Item", "Tennis Ball");
        inventoryItems [Constants.TENNIS_BALL] = tennisBall;
        
        return inventoryItems;
        
        
        
    }
    
    
    
    private static Scenario[] createScenarioList() {
        Scenario[] scenarios = new Scenario[];
        
        Scenario nothing = new Scenario(100, "Nothing happens");
        
        
        return null;
        
        
    }
     
     private static void assignScenarioToLocations(Map map, Scenario[] scenarios) {
        System.out.println("***assign scenarios to locations");
    }
     
     
    
    
    public int increaseDailyDifficulty(int scenarioValue, int daysPassed) {
        
        if (scenarioValue < 1 || scenarioValue > 100){
            return -1;
        }
        
        if (daysPassed < 1 || daysPassed > 30){
            return -1;
        }

        scenarioValue -= daysPassed;

        return scenarioValue;    
    }
    
    
    public int decreaseCharHunger(int charHungerValue){
        
        
        if (charHungerValue < 1 || charHungerValue > 100){
                return -1;
        }

        gameHungerValue =  (int) ((Math.random() * 10) + 1);
        
        charHungerValue -= gameHungerValue;

        return charHungerValue;
    }
   
    
}//end of class
