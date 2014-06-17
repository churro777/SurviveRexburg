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
    
    public static Game game;
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
        Scenario[] scenarios = createScenarioList();
        
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
    
    
    private static Location[][] createLocationList() {
        
        Location[] locations = new Location[56];
        
        //0
        Location gunStore = new Location();
        gunStore.setName("Gun Store");
        gunStore.setRow(0);
        gunStore.setColumn(0);
        gunStore.setVisited(false);
        gunStore.setScenario(null);
        gunStore.setSurvivors(null);
        gunStore.setZombies(null);
        locations[Constants.GUNSTORE] = gunStore;
        
       
        //1
        Location jambaJuice = new Location();
        jambaJuice.setName("Jumba Juice");
        jambaJuice.setRow(0);
        jambaJuice.setColumn(1);
        jambaJuice.setVisited(false);
        jambaJuice.setScenario(null);
        jambaJuice.setSurvivors(null);
        jambaJuice.setZombies(null);
        locations[Constants.JAMBA_JUICE] = jambaJuice;
        
        //2
        Location broulims = new Location();
        broulims.setName("Broulim's");
        broulims.setRow(0);
        broulims.setColumn(2);
        broulims.setVisited(false);
        broulims.setScenario(null);
        broulims.setSurvivors(null);
        broulims.setZombies(null);
        locations[Constants.BROULIMS] = broulims;
        
        //3
        Location fireStation = new Location();
        fireStation.setName("Fire Station");
        fireStation.setRow(0);
        fireStation.setColumn(3);
        fireStation.setVisited(false);
        fireStation.setScenario(null);
        fireStation.setSurvivors(null);
        fireStation.setZombies(null);
        locations[Constants.FIRE_STATION] = fireStation;
        
        //4
        Location tacoBell = new Location();
        tacoBell.setName("Taco Bell");
        tacoBell.setRow(0);
        tacoBell.setColumn(4);
        tacoBell.setVisited(false);
        tacoBell.setScenario(null);
        tacoBell.setSurvivors(null);
        tacoBell.setZombies(null);
        locations[Constants.TACOBELL] = tacoBell;
        
        //5
        Location bikeStore = new Location();
        bikeStore.setName("Bike Store");
        bikeStore.setRow(0);
        bikeStore.setColumn(5);
        bikeStore.setVisited(false);
        bikeStore.setScenario(null);
        bikeStore.setSurvivors(null);
        bikeStore.setZombies(null);
        locations[Constants.BIKE_STORE] = bikeStore;
        
        //6
        Location insuranceOffice = new Location();
        insuranceOffice.setName("Insurance Office");
        insuranceOffice.setRow(0);
        insuranceOffice.setColumn(6);
        insuranceOffice.setVisited(false);
        insuranceOffice.setScenario(null);
        insuranceOffice.setSurvivors(null);
        insuranceOffice.setZombies(null);
        locations[Constants.INSURANCE_OFFICE] = insuranceOffice;
        
        //7
        Location mavericks = new Location();
        mavericks.setName("Maverick's");
        mavericks.setRow(1);
        mavericks.setColumn(0);
        mavericks.setVisited(false);
        mavericks.setScenario(null);
        mavericks.setSurvivors(null);
        mavericks.setZombies(null);
        locations[Constants.MAVERICKS] = mavericks;
        
        //8
        Location dominos = new Location();
        dominos.setName("Domino's");
        dominos.setRow(1);
        dominos.setColumn(1);
        dominos.setVisited(false);
        dominos.setScenario(null);
        dominos.setSurvivors(null);
        dominos.setZombies(null);
        locations[Constants.DOMINOS] = dominos;
        
        //9
        Location salon = new Location();
        salon.setName("Salon");
        salon.setRow(1);
        salon.setColumn(2);
        salon.setVisited(false);
        salon.setScenario(null);
        salon.setSurvivors(null);
        salon.setZombies(null);
        locations[Constants.SALON] = salon;
        
        //10
        Location melaluca = new Location();
        melaluca.setName("Melaluca");
        melaluca.setRow(1);
        melaluca.setColumn(3);
        melaluca.setVisited(false);
        melaluca.setScenario(null);
        melaluca.setSurvivors(null);
        melaluca.setZombies(null);
        locations[Constants.MELALUCA] = melaluca;
        
        //11
        Location donuts = new Location();
        donuts.setName("Donut's");
        donuts.setRow(1);
        donuts.setColumn(4);
        donuts.setVisited(false);
        donuts.setScenario(null);
        donuts.setSurvivors(null);
        donuts.setZombies(null);
        locations[Constants.DONUTS] = donuts;
        
        //12
        Location gringos = new Location();
        gringos.setName("Gringo's");
        gringos.setRow(1);
        gringos.setColumn(5);
        gringos.setVisited(false);
        gringos.setScenario(null);
        gringos.setSurvivors(null);
        gringos.setZombies(null);
        locations[Constants.GRINGOS] = gringos;
        
        //13
        Location keyBank = new Location();
        keyBank.setName("Key Bank");
        keyBank.setRow(1);
        keyBank.setColumn(6);
        keyBank.setVisited(false);
        keyBank.setScenario(null);
        keyBank.setSurvivors(null);
        keyBank.setZombies(null);
        locations[Constants.KEYBANK] = keyBank;
        
        //14
        Location porterParkField = new Location();
        porterParkField.setName("Porter Park Field");
        porterParkField.setRow(2);
        porterParkField.setColumn(0);
        porterParkField.setVisited(false);
        porterParkField.setScenario(null);
        porterParkField.setSurvivors(null);
        porterParkField.setZombies(null);
        locations[Constants.PORTER_PARK_FIELD] = porterParkField;
        
        //15
        Location nielsons = new Location();
        nielsons.setName("Nielson's");
        nielsons.setRow(2);
        nielsons.setColumn(1);
        nielsons.setVisited(false);
        nielsons.setScenario(null);
        nielsons.setSurvivors(null);
        nielsons.setZombies(null);
        locations[Constants.NIELSONS] = nielsons;
        
        
        
        
        
        
        
        
        return null;
    }
            
            
    
    
    
    
    private static Scenario[] createScenarioList() {
        Scenario[] scenarios = new Scenario[Constants.SCENARIOS_COUNT];
        
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
        startDay.setChoiceFour("Search Current Location");
        startDay.setChoiceFive(null);
        scenarios[Constants.DAY_STARTS] = startDay;
        
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
        scenarios[Constants.DAY_ENDS] = dayEnds;
        
        //OUTCOMES Start Day > Stay in Current Location CHOICE
        //#2
        Scenario nothingHappens = new Scenario();
        nothingHappens.setScenarioName("Nothing happens");
        nothingHappens.setScenarioDescription("What a boring day.");
        nothingHappens.setScenarioValue(80);
        nothingHappens.setActive(false);
        nothingHappens.setChoiceOne(null);
        nothingHappens.setChoiceTwo(null);
        nothingHappens.setChoiceThree(null);
        nothingHappens.setChoiceFour(null);
        nothingHappens.setChoiceFive(null);
        scenarios[Constants.NOTHING_HAPPENS] = nothingHappens;
        
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
        scenarios[Constants.SURVIVORS_OFFER_HELP] = survivorsOfferHelp;
        
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
        scenarios[Constants.SURVIVORS_ASK_HELP] = survivorsAskForHelp;
        
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
        scenarios[Constants.SURVIVORS_ATTACK] = survivorsAttack;
        
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
        scenarios[Constants.ZOMBIES_ATTACK] = zombiesAttack;
        
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
        scenarios[Constants.SURVIVORS_GIVE_YOU_ITEM] = survivorsGiveItem;
        
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
        scenarios[Constants.TRICKED_ATTACKED_AFTER_OFFERING_HELP] = trickedAttackedAfterOfferingHelp;

        
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
        scenarios[Constants.DAY_ENDS_ACCEPT_HELP_ACCEPT_ITEM] = dayEndsAndAcceptHelpAcceptItem;
        
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
        scenarios[Constants.DAY_ENDS_ACCEPT_HELP_DENY_ITEM] = dayEndsAndAcceptHelpDenyItem;
        
        
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
        scenarios [Constants.ESCAPE_TO_LOCATION_DAY_ENDS] = escapeToLocationDayEnds;
        
        
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
        scenarios [Constants.CAPTURED_AND_INJURED_DAY_ENDS] = capturedAndInjuredDayEnds;
        
                
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
        scenarios [Constants.CAPTURED_INJURED_ROBBED_DAY_ENDS] = capturedInjuredAndRobbedDayEnds;
        
        
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
        scenarios [Constants.CAPTURED_AND_DEAD] = capturedAndDead;
            
        
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
        scenarios[Constants.SURVIVORS_LISTEN_TO_NEGOTIATION] = survivorsListenToNegotiation;
        
        
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
        scenarios [Constants.SURVIVORS_DONT_LISTEN_TO_NEGOTIATION] = survivorsDontListenToNegotiation;
        
        
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
        scenarios[Constants.WIN_FIGHT_GAIN_SUPPLIES_DAY_ENDS] = winFightGainSuppliesDayEnds;
        
        
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
        scenarios[Constants.WIN_FIGHT_DAY_ENDS] = winFightDayEnds;
        
        
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
        scenarios[Constants.LOSE_FIGHT_INJURED_DAY_ENDS] = loseFightInjuredDayEnds;
        
        
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
        scenarios[Constants.LOSE_FIGHT_INJURED_DAY_ENDS] = loseFightDead;
        
        
         
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
        scenarios [Constants.TAKE_OFFER_AND_LEAVE_DAY_ENDS] = takeOfferAndLeaveDayEnds;
        
        
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
        scenarios [Constants.DONT_TAKE_OFFER_AND_ATTACK] = dontTakeOfferAndAndAttack;
        
        
                
                
                
        /*
        //OUTCOMES Survivors Offer Help > Refuse Help CHOICE
        //#9
        Scenario survivorsDeniedHelpAndLeave = new Scenario();
        survivorsDeniedHelpAndLeave.setScenarioName("Survivors Leave After You Deny Them Help");
        survivorsDeniedHelpAndLeave.setScenarioDescription("\nYou refuse to offer help to the struggling survivors. "
                                                        + "\nThey decide to look elsewhere for help. "
                                                        + "\nThe day is over. You have survived today. "
                                                        + "\nTime for sleep");
        survivorsDeniedHelpAndLeave.setActive(false);
        survivorsDeniedHelpAndLeave.setScenarioValue(0);
        survivorsDeniedHelpAndLeave.setChoiceOne(null);
        survivorsDeniedHelpAndLeave.setChoiceTwo(null);
        survivorsDeniedHelpAndLeave.setChoiceThree(null);
        survivorsDeniedHelpAndLeave.setChoiceFour(null);
        survivorsDeniedHelpAndLeave.setChoiceFive(null);
        */
                
        return scenarios;
        
        
    }
     
    private static void assignScenarioToLocations(Map map, Scenario[] scenarios) {
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
        locations[4][7].setScenario(scenarios[Constants.DAY_STARTS]);
        
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

        locations[7][0].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[7][1].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[7][2].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[7][3].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[7][4].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[7][5].setScenario(scenarios[Constants.DAY_STARTS]);
        locations[7][6].setScenario(scenarios[Constants.DAY_STARTS]);
        
        
    }
     
    public static InventoryItems[] getSortedInventoryList(){
        
        //get inventory list for the current game
        InventoryItems[] inventoryList =
                SurviveRexburg.getCurrentGame().getInventoryItems();
        
        //using a BubbleSort to sort the list of inventoryList by name
        InventoryItems tempInventoryItem;
        for (int i=0; i < inventoryList.length -1; i++){
            for (int j = 0; j < inventoryList.length-1-i; j++){
                if (inventoryList[j].getDescription().
                        compareToIgnoreCase(inventoryList[j+1].getDescription()) > 0){
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j+1];
                    inventoryList[j+1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    } 
    
    
    
    /*
    public static Scenario[] getSortedScenarioList(){
        
        Scenario[] scenarioList =
                SurviveRexburg.getCurrentGame().getScenarios();
      {
            int i, j;
            String temp;

            for ( i = 0;  i < Scenario.length - 1;  i++ )
            {
                for ( j = i + 1;  j < Scenario.length;  j++ )
                {  
                         if ( Scenario [ i ].compareToIgnoreCase( Scenario [ j ] ) > 0 )
                          {                                             // ascending sort
                                      temp = Scenario [ i ];
                                      Scenario [ i ] = Scenario [ j ];    // swapping
                                      Scenario [ j ] = temp; 
                                      
                           } 
                   } 
             } 
      } 
        
       return scenarioList;            
    }*/
    
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
