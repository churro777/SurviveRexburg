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


/**
 *
 * @author arturoaguila
 */
public class GameControl {
    
    public static Game game;



    private int gameHungerValue;
    
    
    public static void createNewGame(EndUser endUser){
        
        // create new game
        GameControl.game = new Game();
        System.out.println("***Game Created***");
        
        // save as current game
        SurviveRexburg.setCurrentGame(game);
        System.out.println("***Game saved***");
        
        //set player in game object
        GameControl.game.setEndUser(SurviveRexburg.getEndUser());
        System.out.println("***Save Player in Game***");
        
        //create list of characters that the EndUser can choose from
        GameCharacter[] gameCharacters = GameControl.createCharList();
        GameControl.game.setGameCharacters(gameCharacters);
        System.out.println("***List of Characters created***");

        //create lists of items - food, spoiled food, melee weapons, ranged weapons
        GameControl.createItemLists();
        
        //create different Scenario Lists
        GameControl.createScenariosLists();
        
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
        
        return gameCharacters;
        
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
    
    public static void createScenariosLists(){
        
        Scenario[] oneWayScenarios = ScenarioControl.createOneWayScenariosList();
        GameControl.game.setOneWayScenarios(oneWayScenarios);
        System.out.println("\n***OneWayScenariosList crated***"
                        +  "\n***OneWayScenarioList saved***");
        
        Scenario[] chooseDoNothingPossibilities = ScenarioControl.createDoNothingPossibilitiesList();
        GameControl.game.setChooseDoNothingPossibilities(chooseDoNothingPossibilities);
        System.out.println("***DoNothingPossibilities created***");
        
        Scenario[] chooseFortifyPossibilities = ScenarioControl.createFortifyPossibilitiesList();
        GameControl.game.setChooseFortifyPossibilities(chooseFortifyPossibilities);
        System.out.println("***FortifyPossbilities created***");
        
        Scenario[] chooseExplorePossibilities = ScenarioControl.createExplorePossibilitiesList();
        GameControl.game.setChooseExplorePossibilities(chooseExplorePossibilities);
        System.out.println("***ExplorePossibilities created***");
        
        Scenario[] chooseScavengePossbilities = ScenarioControl.createScavengePossiblitiesList();
        GameControl.game.setChooseScavengePossbilities(chooseScavengePossbilities);
        System.out.println("***ScavengePossibilities created***");
        
        
        
        Scenario[] chooseAcceptHelpPossiblities = ScenarioControl.createAcceptHelpPossibilitiesList();
        GameControl.game.setChooseAcceptHelpPossiblities(chooseAcceptHelpPossiblities);
        System.out.println("***AcceptHelpPossibilities created***");
        
        Scenario[] chooseRunAwayFromSurvivorsPossibilities = ScenarioControl.createRunAwayFromSurvivorsPossibilitiesList();
        GameControl.game.setChooseRunAwayFromSurvivorsPossibilities(chooseRunAwayFromSurvivorsPossibilities);
        System.out.println("***RunAwayFromSurvivorsPossibilities created***");
        
        Scenario[] chooseNegotiatePossibilities = ScenarioControl.createNegotiatePossibilitiesList();
        GameControl.game.setChooseNegotiatePossibilities(chooseNegotiatePossibilities);
        System.out.println("***NegotiatePossibilities created***");
        
        Scenario[] chooseOfferingPossibilities = ScenarioControl.createOfferingPossibilitiesList();
        GameControl.game.setChooseOfferingPossibilities(chooseOfferingPossibilities);
        System.out.println("***OfferingPossibilities created***");
        
        Scenario[] chooseFightSurvivorsPossibilities = ScenarioControl.createFightSurvivorsPossibilitiesList();
        GameControl.game.setChooseFightSurvivorsPossibilities(chooseFightSurvivorsPossibilities);
        System.out.println("***FightSurvivorsPossibilities created****");
        
        
        
        Scenario[] chooseRunAwayFromZombiesPossibilities = ScenarioControl.createRunAwayFromZombiesPossibilitiesList();
        GameControl.game.setChooseRunAwayFromZombiesPossibilities(chooseRunAwayFromZombiesPossibilities);
        System.out.println("***RunAwayFromZombiesPossibilities created***");
        
        Scenario[] chooseFightZombiesPossibilities = ScenarioControl.createFightZombiesPossibilitiesList();
        GameControl.game.setChooseFightZombiesPossibilities(chooseFightZombiesPossibilities);
        System.out.println("***FightZombiesPossibilities created***");
        
        
    }

 
    
}//end of class
