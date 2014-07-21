/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import Survivrexburg.SurviveRexburg;
import byui.cit260.surviveRexburg.model.Backpack;
import byui.cit260.surviveRexburg.model.Food;
import byui.cit260.surviveRexburg.model.GameCharacter;
import byui.cit260.surviveRexburg.model.InventoryItems;
import byui.cit260.surviveRexburg.model.MeleeWeapons;
import byui.cit260.surviveRexburg.model.RangedWeapons;
import byui.cit260.surviveRexburg.model.SpoiledFood;
import java.util.*;


/**
 *
 * @author arturoaguila
 */
public class ItemControl {
    
    
    public static void createBackpack(){
        Backpack backpack = new Backpack();
        backpack.setMaxWeight(10* GameCharacter.charStrengthValue);
        backpack.setLoadedWeight(0);
        SurviveRexburg.getCurrentGame().getEndUser().setBackpack(backpack);

    }
    
    /* //Flexible Array (?)
    public static void main(String args[]) {
        
        //create back via arraylist class 
        Backpack backpack = new Backpack();
        System.out.println("Intial size of backpack: " + Backpack.size());
        
        //add elements to the array list
        Backpack.add("A");
        Backpack.add("B");
        Backpack.add("C");
        Backpack.add("D");
        System.out.println("Size of backpack after additions: " + Backpack.size());
        
        //display the array list
        System.out.println("Contents of backpack: " + Backpack);
        //remove elements from the array list
        Backpack.remove("A");
        System.out.println("Size of backpack after deletions: " + Backpack.size());
        System.out.println("Contents of backpack: " + Backpack);
        
        
    } */
    
    
    
    
    /*HashMap[String, ArrayList[Item]] items = new HashMap[String, ArrayList<Item]]();
    public void add(Item item){
        String name = item.getName();
        ArrayList[Item] itemGroup = items.get(name);
        if(itemGroup==null) //add a new group, if none exist, yet
        {
            itemGroup = new ArrayList[Items]();
            item.put(name, itemGroup);
        }
        itemGroup.add(item);
        
    }
    
    public void remove(String name){
        String name = item.getName();
        ArrayList[Item] itemGroup = items.get(name);
        if(itemGroup==null) return;
        itemGroup.remove(name);
        //remove an empty group
        if(itemGroup.size()) == 0;
        item.remove(name);
    }*/
    
    // 18 Food items     
    static Food[] createFoodList() {
    
        //food inventory

        Food[] food = new Food[Constants.NUMBER_OF_ITEMS_FOOD];

        //                          Name     +     Type  + Quantity
        Food cannedTuna = new Food("Canned Tuna", "Food", 0);
        food[Constants.CANNED_TUNA] = cannedTuna;
        
        Food cannedBeans = new Food("Canned Beans", "Food", 0);
        food[Constants.CANNED_BEANS] = cannedBeans;
        
        Food mangos = new Food("Mangos", "Food", 0);
        food[Constants.MANGOS] = mangos;
        
        Food cannedChicken = new Food("Canned Chicken", "Food", 0);
        food[Constants.CANNED_CHICKEN] = cannedChicken;
        
        Food cannedBeefStew = new Food("Canned Beef Stew", "Food", 0);
        food [Constants.CANED_BEEF_STEW] = cannedBeefStew;
        
        Food apples = new Food("Apples", "Food", 0);
        food [Constants.APPLES] = apples;
        
        Food bananas = new Food("Bananas", "Food", 0);
        food [Constants.BANANAS] = bananas;
        
        Food saltineCrackers = new Food("Saltine Crackers", "Food", 0);
        food [Constants.SALTINE_CRACKERS] = saltineCrackers;
        
        Food cannedChickenSoup = new Food("Canned Chicken Soup","Food", 0);
        food [Constants.CANNED_CHICKEN_SOUP] = cannedChickenSoup;
        
        Food milk = new Food("Milk", "Food", 0);
        food [Constants.MILK] = milk;
        
        Food potatoes = new Food("Potatoes", "Food", 0);
        food [Constants.POTATOES] = potatoes;
        
        Food bread = new Food( "Bread", "Food",0);
        food [Constants.BREAD] = bread;
        
        Food cheese = new Food( "Cheese", "Food",0);
        food [Constants.CHEESE] = cheese;
        
        Food cereal = new Food("Cereal", "Food", 0);
        food [Constants.CEREAL] = cereal;
        
        Food eggs = new Food("Eggs", "Food", 0);
        food [Constants.EGGS] = eggs;
        
        Food topRamen = new Food("Top Ramen", "Food", 0);
        food [Constants.TOP_RAMEN] = topRamen;
        
        Food chocolate = new Food ("Chocolate", "Food",0 );
        food [Constants.CHOCOLATE] = chocolate;
        
        Food soda = new Food ("Soda", "Food", 0);
        food [Constants.SODA]  = soda;
        
        return food;
    }

    // 7 Spoiled Food Items
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
    
    // 7 Melee Weapons - Fists, Baseball Bat, Sledge Hammer, Hammer, Golf Club, Steak Knife, Tennis Racket
    static MeleeWeapons[] createMeleeWeaponsList() {
       
    
        //melee weapons
        MeleeWeapons[] meleeWeapons = new MeleeWeapons[Constants.NUMBER_OF_ITEMS_MELEE_WEAPONS];
        
        MeleeWeapons fists = new MeleeWeapons(0, "Melee Weapon", "Fists");
        meleeWeapons[Constants.FISTS] = fists;
        
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
    
    // 5 Ranged Weapons - Fists, Shotgun, Hunting Rifle, Handgun, Bow and Arrow
    static RangedWeapons[] createRangedWeaponList() {
       
        //ranged weapons
        RangedWeapons[] rangedWeapons = new RangedWeapons[Constants.NUMBER_OF_ITEMS_RANGED_WEAPONS];
        
        RangedWeapons rangedFists = new RangedWeapons(0, "Ranged Weapon", "Ranged Fists");
        rangedWeapons[Constants.RANGED_FISTS] = rangedFists;
        
        RangedWeapons shotgun = new RangedWeapons(8, "Ranged Weapon", "Shotgun");
        rangedWeapons[Constants.SHOTGUN] = shotgun;
        
        RangedWeapons huntingRifle = new RangedWeapons(7, "Ranged Weapon", "Hunting Rifle");
        rangedWeapons[Constants.HUNTING_RIFLE] = huntingRifle;
        
        RangedWeapons handgun = new RangedWeapons(2, "Ranged Weapon", "Handgun");
        rangedWeapons[Constants.HANDGUN] = handgun;
        
        RangedWeapons bowAndArrow = new RangedWeapons(3, "Ranged Weapon", "Bow and Arrow");
        rangedWeapons[Constants.BOW_AND_ARROW] = bowAndArrow;
        
        return rangedWeapons;
    }
    
    public static void putFoodInBackpack(){
        
        SurviveRexburg.getCurrentGame().getEndUser().getBackpack().setApples(SurviveRexburg.getCurrentGame().getFoodList()[Constants.APPLES]);
        SurviveRexburg.getCurrentGame().getEndUser().getBackpack().setCannedBeans(SurviveRexburg.getCurrentGame().getFoodList()[Constants.CANNED_BEANS]);
        SurviveRexburg.getCurrentGame().getEndUser().getBackpack().setCannedTuna(SurviveRexburg.getCurrentGame().getFoodList()[Constants.CANNED_TUNA]);
        SurviveRexburg.getCurrentGame().getEndUser().getBackpack().setCereal(SurviveRexburg.getCurrentGame().getFoodList()[Constants.CEREAL]);
        SurviveRexburg.getCurrentGame().getEndUser().getBackpack().setChocolate(SurviveRexburg.getCurrentGame().getFoodList()[Constants.CHOCOLATE]);
        SurviveRexburg.getCurrentGame().getEndUser().getBackpack().setTopRamen(SurviveRexburg.getCurrentGame().getFoodList()[Constants.TOP_RAMEN]);
        SurviveRexburg.getCurrentGame().getEndUser().getBackpack().setPotatoes(SurviveRexburg.getCurrentGame().getFoodList()[Constants.POTATOES]);
        SurviveRexburg.getCurrentGame().getEndUser().getBackpack().setBread(SurviveRexburg.getCurrentGame().getFoodList()[Constants.BREAD]);
        
        
        
    }

    //Apples, Canned Beans, Canned tuna, Ceral, Chocolate, TopRamen, Potatoes, Bread
    public static void gainRandomFood(){
        int randomNumber = (int) (Math.round(Math.random() * 8) + 1);
        
        switch (randomNumber) {
            case '1'://Apples
                int oldQuantityApples = SurviveRexburg.getEndUser().getBackpack().getApples().getQuantityInStock();
                int newQuantityApples = oldQuantityApples + 1;
                SurviveRexburg.getEndUser().getBackpack().getApples().setQuantityInStock(newQuantityApples);
                String applesString = SurviveRexburg.getEndUser().getBackpack().getApples().getItemName();
                SurviveRexburg.getEndUser().getBackpack().setDisplayItemName(applesString);
                break;
            case '2'://Canned Beans
                int oldQuantityCannedBeans = SurviveRexburg.getEndUser().getBackpack().getCannedBeans().getQuantityInStock();
                int newQuantityCannedBeans = oldQuantityCannedBeans + 1;
                SurviveRexburg.getEndUser().getBackpack().getCannedBeans().setQuantityInStock(newQuantityCannedBeans);
                String beansString = SurviveRexburg.getEndUser().getBackpack().getCannedBeans().getItemName();
                SurviveRexburg.getEndUser().getBackpack().setDisplayItemName(beansString);
                break;
            case '3'://Canned Tuna
                int oldQuantityCannedTuna = SurviveRexburg.getEndUser().getBackpack().getCannedTuna().getQuantityInStock();
                int newQuantityCannedTuna = oldQuantityCannedTuna + 1;
                SurviveRexburg.getEndUser().getBackpack().getCannedTuna().setQuantityInStock(newQuantityCannedTuna);
                String tunaString = SurviveRexburg.getEndUser().getBackpack().getCannedTuna().getItemName();
                SurviveRexburg.getEndUser().getBackpack().setDisplayItemName(tunaString);
                break;
            case '4'://Cereal
                int oldQuantityCereal = SurviveRexburg.getEndUser().getBackpack().getCereal().getQuantityInStock();
                int newQuantityCereal = oldQuantityCereal + 1;
                SurviveRexburg.getEndUser().getBackpack().getCereal().setQuantityInStock(newQuantityCereal);
                String cerealString = SurviveRexburg.getEndUser().getBackpack().getCereal().getItemName();
                SurviveRexburg.getEndUser().getBackpack().setDisplayItemName(cerealString);
                break;
            case '5'://Chocolate
                int oldQuantityChocolate = SurviveRexburg.getEndUser().getBackpack().getChocolate().getQuantityInStock();
                int newQuantityChocolate = oldQuantityChocolate + 1;
                SurviveRexburg.getEndUser().getBackpack().getChocolate().setQuantityInStock(newQuantityChocolate);
                String chocolateString = SurviveRexburg.getEndUser().getBackpack().getChocolate().getItemName();
                SurviveRexburg.getEndUser().getBackpack().setDisplayItemName(chocolateString);
                break;
            case '6'://TopRamen
                int oldQuantityTopRamen = SurviveRexburg.getEndUser().getBackpack().getTopRamen().getQuantityInStock();
                int newQuantityTopRamen = oldQuantityTopRamen + 1;
                SurviveRexburg.getEndUser().getBackpack().getTopRamen().setQuantityInStock(newQuantityTopRamen);
                String topRamenString = SurviveRexburg.getEndUser().getBackpack().getTopRamen().getItemName();
                SurviveRexburg.getEndUser().getBackpack().setDisplayItemName(topRamenString);
                break;
            case '7'://Potatoes
                int oldQuantityPotatoes = SurviveRexburg.getEndUser().getBackpack().getPotatoes().getQuantityInStock();
                int newQuantityPotatoes = oldQuantityPotatoes + 1;
                SurviveRexburg.getEndUser().getBackpack().getPotatoes().setQuantityInStock(newQuantityPotatoes);
                String potatoesString = SurviveRexburg.getEndUser().getBackpack().getPotatoes().getItemName();
                SurviveRexburg.getEndUser().getBackpack().setDisplayItemName(potatoesString);
                break;
            case '8'://Bread
                int oldQuantityBread = SurviveRexburg.getEndUser().getBackpack().getBread().getQuantityInStock();
                int newQuantityBread = oldQuantityBread + 1;
                SurviveRexburg.getEndUser().getBackpack().getBread().setQuantityInStock(newQuantityBread);
                String breadString = SurviveRexburg.getEndUser().getBackpack().getBread().getItemName();
                SurviveRexburg.getEndUser().getBackpack().setDisplayItemName(breadString);
                break;
        }
        
        
    }
    
    
    public static void gainRandomWeapon(){
        int randomNumber = (int) (Math.floor(Math.random() * 100) + 1);
        
        //determine ranged weapon out of 4
        //Shotgun, Hunting Rifle, Handgun, Bow and Arrow
        if (randomNumber >= 66){
            int ranged = (int) (Math.floor(Math.random() * 4) + 1);
            
            switch (ranged) {
                case '1':
                    RangedWeapons shotgun = SurviveRexburg.getCurrentGame().getRangedWeaponsList()[Constants.SHOTGUN];
                    SurviveRexburg.getEndUser().setRangedWeapon(shotgun);
                    break;
                case '2':
                    RangedWeapons huntingRifle = SurviveRexburg.getCurrentGame().getRangedWeaponsList()[Constants.HUNTING_RIFLE];
                    SurviveRexburg.getEndUser().setRangedWeapon(huntingRifle);
                    break;
                case '3':
                    RangedWeapons handgun = SurviveRexburg.getCurrentGame().getRangedWeaponsList()[Constants.HANDGUN];
                    SurviveRexburg.getEndUser().setRangedWeapon(handgun);
                    break;
                case '4':
                    RangedWeapons bowAndArrow = SurviveRexburg.getCurrentGame().getRangedWeaponsList()[Constants.BOW_AND_ARROW];
                    SurviveRexburg.getEndUser().setRangedWeapon(bowAndArrow);
                    break;
            }
            
        }
        //determine melee weapon out of 6
        //Baseball Bat, Sledge Hammer, Hammer, Golf Club, Steak Knife, Tennis Racket
        else if (randomNumber <= 65 && randomNumber >= 33){
            int melee = (int) (Math.floor(Math.random() * 6) + 1);
            
            switch (melee) {
                case '1':
                    MeleeWeapons baseballBat = SurviveRexburg.getCurrentGame().getMeleeWeaponsList()[Constants.BASEBALL_BAT];
                    SurviveRexburg.getEndUser().setMeleeWeapon(baseballBat);
                    break;
            }
        }
        
        
        
        
    }
    
    
    
    
    
}//end of class
