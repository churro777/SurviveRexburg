/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import byui.cit260.surviveRexburg.model.Backpack;
import byui.cit260.surviveRexburg.model.Food;
import byui.cit260.surviveRexburg.model.GameCharacter;
import byui.cit260.surviveRexburg.model.MeleeWeapons;
import byui.cit260.surviveRexburg.model.RangedWeapons;
import byui.cit260.surviveRexburg.model.SpoiledFood;

/**
 *
 * @author arturoaguila
 */
public class ItemControl {
    
    
    private static Backpack createBackpack(){
        Backpack backpack = new Backpack();
        backpack.setMaxWeight(10* GameCharacter.charStrengthValue);
        backpack.setLoadedWeight(0);
        return backpack;
    }
    
    
    
    
         
    static Food[] createFoodList() {
    
        //food inventory

        Food[] food = new Food[Constants.NUMBER_OF_ITEMS_FOOD];

        Food cannedTuna = new Food(1, "Food","Canned Tuna");
        food[Constants.CANNED_TUNA] = cannedTuna;
        
        Food cannedBeans = new Food(1, "Food", "Canned Beans");
        food[Constants.CANNED_BEANS] = cannedBeans;
        
        Food mangos = new Food(3, "Food", "Mangos");
        food[Constants.MANGOS] = mangos;
        
        Food cannedChicken = new Food (1, "Food", "Canned Chicken");
        food[Constants.CANNED_CHICKEN] = cannedChicken;
        
        Food cannedBeefStew = new Food(1, "Food", "Canned Beef Stew");
        food [Constants.CANED_BEEF_STEW] = cannedBeefStew;
        
        Food apples = new Food(2, "Food", "Apples");
        food [Constants.APPLES] = apples;
        
        Food bananas = new Food(2, "Food", "Bananas");
        food [Constants.BANANAS] = bananas;
        
        Food saltineCrackers = new Food(1, "Food", "Saltine Crackers");
        food [Constants.SALTINE_CRACKERS] = saltineCrackers;
        
        Food cannedChickenSoup = new Food(1, "Food", "Canned Chicken Soup");
        food [Constants.CANNED_CHICKEN_SOUP] = cannedChickenSoup;
        
        Food milk = new Food(3, "Food", "Milk");
        food [Constants.MILK] = milk;
        
        Food potatoes = new Food(2, "Food", "Potatoes");
        food [Constants.POTATOES] = potatoes;
        
        Food bread = new Food(1, "Food", "Bread");
        food [Constants.BREAD] = bread;
        
        Food cheese = new Food(1, "Food", "Cheese");
        food [Constants.CHEESE] = cheese;
        
        Food cereal = new Food(1, "Food", "Cereal");
        food [Constants.CEREAL] = cereal;
        
        Food eggs = new Food(1, "Food", "Eggs");
        food [Constants.EGGS] = eggs;
        
        Food topRamen = new Food(1, "Food", "Top Ramen");
        food [Constants.TOP_RAMEN] = topRamen;
        
        Food chocolate = new Food (1, "Food", "Chocolate");
        food [Constants.CHOCOLATE] = chocolate;
        
        Food soda = new Food (1, "Food", "Chocolate");
        food [Constants.SODA]  = soda;
        
        return food;
    }

    
    static SpoiledFood[] createSpoiledFoodList() {
        
        //spoiled food
        SpoiledFood[] spoiledFood = new SpoiledFood[Constants.NUMBER_OF_ITEMS_SPOILED_FOOD];
        
        SpoiledFood rottenEggs = new SpoiledFood (1, "Spoiled Food", "Rotten Eggs");
        spoiledFood [Constants.ROTTEN_EGGS] = rottenEggs;
        
        SpoiledFood moldyCheese = new SpoiledFood (1, "Spoiled Food", "Moldy Cheese");
        spoiledFood [Constants.MOLDY_CHEESE] = moldyCheese;
        
        SpoiledFood sourMilk = new SpoiledFood (3, "Spoiled Food", "Sour Milk");
        spoiledFood [Constants.SOUR_MILK] = sourMilk;
        
        SpoiledFood moldyBread = new SpoiledFood (1, "Spoiled Food", "Moldy Bread");
        spoiledFood [Constants.MOLDY_BREAD] = moldyBread;
        
        SpoiledFood rottenMangos = new SpoiledFood (3, "Spoiled Food", "Rotten Mangos");
        spoiledFood [Constants.ROTTEN_MANGO] = rottenMangos;
        
        SpoiledFood rottenApples = new SpoiledFood (2, "Spoiled Food", "Rotten Apples");
        spoiledFood [Constants.ROTTEN_APPLE] = rottenApples;
        
        SpoiledFood rottenBananas = new SpoiledFood (2, "Spoiled Food", "Rotten Bananas");
        spoiledFood [Constants.ROTTEN_BANANA] = rottenBananas;
        
        return spoiledFood;
    }
    
    static MeleeWeapons[] createMeleeWeaponsList() {
       
    
        //melee weapons
        MeleeWeapons[] meleeWeapons = new MeleeWeapons[Constants.NUMBER_OF_ITEMS_MELEE_WEAPONS];
        
        MeleeWeapons baseballBat = new MeleeWeapons(4, "Melee Weapon", "Baseball Bat");
        meleeWeapons[Constants.BASEBALL_BAT] = baseballBat;
        
        MeleeWeapons sledgeHammer = new MeleeWeapons(15, "Melee Weapon", "Sledge Hammer");
        meleeWeapons[Constants.SLEDGE_HAMMER] = sledgeHammer;
        
        MeleeWeapons hammer = new MeleeWeapons(15, "Melee Weapon", "Hammer");
        meleeWeapons[Constants.HAMMER] = hammer;
        
        MeleeWeapons golfClub = new MeleeWeapons(3, "Melee Weapon", "Golf Club");
        meleeWeapons[Constants.GOLF_CLUB] = golfClub;
        
        MeleeWeapons steakKnife = new MeleeWeapons(2, "Melee Weapon", "Steak Knife");
        meleeWeapons[Constants.STEAK_KNIFE] = steakKnife;
        
        MeleeWeapons tennisRacket = new MeleeWeapons(5, "Melee Weapon", "Tennis Racket");
        meleeWeapons[Constants.TENNIS_RACKET] = tennisRacket;
        
        return meleeWeapons;
    }
    
    static RangedWeapons[] createRangedWeaponList() {
       
        //ranged weapons
        RangedWeapons[] rangedWeapons = new RangedWeapons[Constants.NUMBER_OF_ITEMS_RANGED_WEAPONS];
        
        RangedWeapons shotgun = new RangedWeapons(8, "Ranged Weapon", "Shotgun");
        rangedWeapons[Constants.SHOTGUN] = shotgun;
        
        RangedWeapons huntingRifle = new RangedWeapons(7, "Ranged Weapon", "Shotgun");
        rangedWeapons[Constants.HUNTING_RIFLE] = huntingRifle;
        
        RangedWeapons handgun = new RangedWeapons(2, "Ranged Weapon", "Handgun");
        rangedWeapons[Constants.HANDGUN] = handgun;
        
        RangedWeapons bowAndArrow = new RangedWeapons(3, "Ranged Weapon", "Bow and Arrow");
        rangedWeapons[Constants.BOW_AND_ARROW] = bowAndArrow;
        
        return rangedWeapons;
    }

    
    
    
    
    
}
