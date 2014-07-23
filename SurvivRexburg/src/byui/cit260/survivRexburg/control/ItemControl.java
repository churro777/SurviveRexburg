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
    
    
    private String displayItemName;
    private String displayWeaponName;

    public String getDisplayItemName() {
        return displayItemName;
    }

    public void setDisplayItemName(String displayItemName) {
        this.displayItemName = displayItemName;
    }

    public String getDisplayWeaponName() {
        return displayWeaponName;
    }

    public void setDisplayWeaponName(String displayWeaponName) {
        this.displayWeaponName = displayWeaponName;
    }
    
    
    
    
    //Functions
    
    public static void createBackpack(){
        Backpack backpack = new Backpack();
        backpack.setMaxWeight(10* GameCharacter.charStrengthValue);
        backpack.setLoadedWeight(0);
        SurviveRexburg.getCurrentGame().getEndUser().setBackpack(backpack);

    }
    
    // 8 Food items     
    static Food[] createFoodList() {
    
        //food inventory

        Food[] food = new Food[Constants.NUMBER_OF_ITEMS_FOOD];

        //                          Type  +    Name  + Quantity
        Food cannedTuna = new Food( "Food","Canned Tuna", 0);
        food[Constants.CANNED_TUNA] = cannedTuna;
        
        Food cannedBeans = new Food("Food","Canned Beans",  0);
        food[Constants.CANNED_BEANS] = cannedBeans;
        
        Food apples = new Food("Food","Apples",  0);
        food [Constants.APPLES] = apples;
        
        Food potatoes = new Food("Food","Potatoes",  0);
        food [Constants.POTATOES] = potatoes;
        
        Food bread = new Food( "Food", "Bread",0);
        food [Constants.BREAD] = bread;
        
        Food cereal = new Food("Food", "Cereal", 0);
        food [Constants.CEREAL] = cereal;;
        
        Food topRamen = new Food( "Food", "Top Ramen",0);
        food [Constants.TOP_RAMEN] = topRamen;
        
        Food chocolate = new Food ( "Food","Chocolate",0 );
        food [Constants.CHOCOLATE] = chocolate;
        
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
    
    //Apples, Canned Beans, Canned Tuna, Cereal, Chocolate, TopRamen, Potatoes, Bread
    public static void putFoodInBackpack(){
        //apples
        Food apples = SurviveRexburg.getCurrentGame().getFoodList()[Constants.APPLES];
        SurviveRexburg.getEndUser().getBackpack().setApples(apples);
        //Canned Beans
        Food cannedBeans = SurviveRexburg.getCurrentGame().getFoodList()[Constants.CANNED_BEANS];
        SurviveRexburg.getEndUser().getBackpack().setCannedBeans(cannedBeans);
        //Canned Tuna
        Food cannedTuna = SurviveRexburg.getCurrentGame().getFoodList()[Constants.CANNED_TUNA];
        SurviveRexburg.getEndUser().getBackpack().setCannedTuna(cannedTuna);
        //Cereal
        Food cereal = SurviveRexburg.getCurrentGame().getFoodList()[Constants.CEREAL];
        SurviveRexburg.getEndUser().getBackpack().setCereal(cereal);
        //Chocolate
        Food chocolate = SurviveRexburg.getCurrentGame().getFoodList()[Constants.CHOCOLATE];
        SurviveRexburg.getEndUser().getBackpack().setChocolate(chocolate);
        //Top Ramen
        Food topRamen = SurviveRexburg.getCurrentGame().getFoodList()[Constants.TOP_RAMEN];
        SurviveRexburg.getEndUser().getBackpack().setTopRamen(topRamen);
        //Potatoes
        Food potatoes = SurviveRexburg.getCurrentGame().getFoodList()[Constants.POTATOES];
        SurviveRexburg.getEndUser().getBackpack().setPotatoes(potatoes);
        //Bread
        Food bread = SurviveRexburg.getCurrentGame().getFoodList()[Constants.BREAD];
        SurviveRexburg.getEndUser().getBackpack().setBread(bread);
        
        
        
    }

    //Apples, Canned Beans, Canned tuna, Ceral, Chocolate, TopRamen, Potatoes, Bread
    public static void gainRandomFood(){
        int randomNumber = (int) (Math.round(Math.random() * 8) + 1);
                            
                
        switch (randomNumber) {
            case 1://Apples
                int oldQuantityApples = SurviveRexburg.getEndUser().getBackpack().getApples().getQuantityInStock();
                int newQuantityApples = oldQuantityApples + 1;
                SurviveRexburg.getEndUser().getBackpack().getApples().setQuantityInStock(newQuantityApples);
                
                String applesString = SurviveRexburg.getEndUser().getBackpack().getApples().getItemName();
                SurviveRexburg.getItemControl().setDisplayItemName(applesString);
                break;
            case 2://Canned Beans
                int oldQuantityCannedBeans = SurviveRexburg.getEndUser().getBackpack().getCannedBeans().getQuantityInStock();
                int newQuantityCannedBeans = oldQuantityCannedBeans + 1;
                SurviveRexburg.getEndUser().getBackpack().getCannedBeans().setQuantityInStock(newQuantityCannedBeans);
                
                String beansString = SurviveRexburg.getEndUser().getBackpack().getCannedBeans().getItemName();
                SurviveRexburg.getItemControl().setDisplayItemName(beansString);
                break;
            case 3://Canned Tuna
                int oldQuantityCannedTuna = SurviveRexburg.getEndUser().getBackpack().getCannedTuna().getQuantityInStock();
                int newQuantityCannedTuna = oldQuantityCannedTuna + 1;
                SurviveRexburg.getEndUser().getBackpack().getCannedTuna().setQuantityInStock(newQuantityCannedTuna);
                
                String tunaString = SurviveRexburg.getEndUser().getBackpack().getCannedTuna().getItemName();
                SurviveRexburg.getItemControl().setDisplayItemName(tunaString);
                break;
            case 4://Cereal
                int oldQuantityCereal = SurviveRexburg.getEndUser().getBackpack().getCereal().getQuantityInStock();
                int newQuantityCereal = oldQuantityCereal + 1;
                SurviveRexburg.getEndUser().getBackpack().getCereal().setQuantityInStock(newQuantityCereal);
                
                String cerealString = SurviveRexburg.getEndUser().getBackpack().getCereal().getItemName();
                SurviveRexburg.getItemControl().setDisplayItemName(cerealString);
                break;
            case 5://Chocolate
                int oldQuantityChocolate = SurviveRexburg.getEndUser().getBackpack().getChocolate().getQuantityInStock();
                int newQuantityChocolate = oldQuantityChocolate + 1;
                SurviveRexburg.getEndUser().getBackpack().getChocolate().setQuantityInStock(newQuantityChocolate);
                
                String chocolateString = SurviveRexburg.getEndUser().getBackpack().getChocolate().getItemName();
                SurviveRexburg.getItemControl().setDisplayItemName(chocolateString);
                break;
            case 6://TopRamen
                int oldQuantityTopRamen = SurviveRexburg.getEndUser().getBackpack().getTopRamen().getQuantityInStock();
                int newQuantityTopRamen = oldQuantityTopRamen + 1;
                SurviveRexburg.getEndUser().getBackpack().getTopRamen().setQuantityInStock(newQuantityTopRamen);
                
                String topRamenString = SurviveRexburg.getEndUser().getBackpack().getTopRamen().getItemName();
                SurviveRexburg.getItemControl().setDisplayItemName(topRamenString);
                break;
            case 7://Potatoes
                int oldQuantityPotatoes = SurviveRexburg.getEndUser().getBackpack().getPotatoes().getQuantityInStock();
                int newQuantityPotatoes = oldQuantityPotatoes + 1;
                SurviveRexburg.getEndUser().getBackpack().getPotatoes().setQuantityInStock(newQuantityPotatoes);
                
                String potatoesString = SurviveRexburg.getEndUser().getBackpack().getPotatoes().getItemName();
                SurviveRexburg.getItemControl().setDisplayItemName(potatoesString);
                break;
            case 8://Bread
                int oldQuantityBread = SurviveRexburg.getEndUser().getBackpack().getBread().getQuantityInStock();
                int newQuantityBread = oldQuantityBread + 1;
                SurviveRexburg.getEndUser().getBackpack().getBread().setQuantityInStock(newQuantityBread);
                
                String breadString = SurviveRexburg.getEndUser().getBackpack().getBread().getItemName();
                SurviveRexburg.getItemControl().setDisplayItemName(breadString);
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
                case '2':
                    MeleeWeapons sledgeHammer = SurviveRexburg.getCurrentGame().getMeleeWeaponsList()[Constants.SLEDGE_HAMMER];
                    SurviveRexburg.getEndUser().setMeleeWeapon(sledgeHammer);
                    break;
                case '3':
                    MeleeWeapons hammer = SurviveRexburg.getCurrentGame().getMeleeWeaponsList()[Constants.HAMMER];
                    SurviveRexburg.getEndUser().setMeleeWeapon(hammer);
                    break;
                case '4':
                    MeleeWeapons golfClub = SurviveRexburg.getCurrentGame().getMeleeWeaponsList()[Constants.GOLF_CLUB];
                    SurviveRexburg.getEndUser().setMeleeWeapon(golfClub);
                    break;
                case '5':
                    MeleeWeapons steakKnife = SurviveRexburg.getCurrentGame().getMeleeWeaponsList()[Constants.STEAK_KNIFE];
                    SurviveRexburg.getEndUser().setMeleeWeapon(steakKnife);
                    break;
                case '6':
                    MeleeWeapons tennisRacket = SurviveRexburg.getCurrentGame().getMeleeWeaponsList()[Constants.TENNIS_RACKET];
                    SurviveRexburg.getEndUser().setMeleeWeapon(tennisRacket);
                    break;
            }
        }
        
        
        
        
    }
   
    public static void eatApples(){
        int originalQantity = SurviveRexburg.getEndUser().getBackpack().getApples().getQuantityInStock();
        
        if (originalQantity > 0){
            
            int newQuantity = originalQantity - 1;
            SurviveRexburg.getEndUser().getBackpack().getApples().setQuantityInStock(newQuantity);
            
            GameControl.increaseHealth();
            GameControl.increaseHunger();
        } 
    }
    public static void eatCannedBeans(){
        int originalQantity = SurviveRexburg.getEndUser().getBackpack().getCannedBeans().getQuantityInStock();
        
        if (originalQantity > 0){
            
            int newQuantity = originalQantity - 1;
            SurviveRexburg.getEndUser().getBackpack().getCannedBeans().setQuantityInStock(newQuantity);
            
            GameControl.increaseHealth();
            GameControl.increaseHunger();
        }
    }
    public static void eatCannedTuna(){
        int originalQantity = SurviveRexburg.getEndUser().getBackpack().getCannedTuna().getQuantityInStock();
        
        if (originalQantity > 0){
            
            int newQuantity = originalQantity - 1;
            SurviveRexburg.getEndUser().getBackpack().getCannedTuna().setQuantityInStock(newQuantity);
            GameControl.increaseHealth();
            GameControl.increaseHunger();
        }
    }
    public static void eatCereal(){
        int originalQantity = SurviveRexburg.getEndUser().getBackpack().getCereal().getQuantityInStock();
        
        if (originalQantity > 0){
            
            int newQuantity = originalQantity - 1;
            SurviveRexburg.getEndUser().getBackpack().getCereal().setQuantityInStock(newQuantity);
            GameControl.increaseHealth();
            GameControl.increaseHunger();
        }
    }
    public static void eatChocolate(){
        int originalQantity = SurviveRexburg.getEndUser().getBackpack().getChocolate().getQuantityInStock();
        
        if (originalQantity > 0){
            
            int newQuantity = originalQantity - 1;
            SurviveRexburg.getEndUser().getBackpack().getChocolate().setQuantityInStock(newQuantity);
            GameControl.increaseHealth();
            GameControl.increaseHunger();
        }
    }
    public static void eatTopRamen(){
        int originalQantity = SurviveRexburg.getEndUser().getBackpack().getTopRamen().getQuantityInStock();
        
        if (originalQantity > 0){
            
            int newQuantity = originalQantity - 1;
            SurviveRexburg.getEndUser().getBackpack().getTopRamen().setQuantityInStock(newQuantity);
            GameControl.increaseHealth();
            GameControl.increaseHunger();
        }
    }
    public static void eatPotatoes(){
        int originalQantity = SurviveRexburg.getEndUser().getBackpack().getPotatoes().getQuantityInStock();
        
        if (originalQantity > 0){
            
            int newQuantity = originalQantity - 1;
            SurviveRexburg.getEndUser().getBackpack().getPotatoes().setQuantityInStock(newQuantity);
            GameControl.increaseHealth();
            GameControl.increaseHunger();
        }
    }
    public static void eatBread(){
        int originalQantity = SurviveRexburg.getEndUser().getBackpack().getBread().getQuantityInStock();
        
        if (originalQantity > 0){
            
            int newQuantity = originalQantity - 1;
            SurviveRexburg.getEndUser().getBackpack().getBread().setQuantityInStock(newQuantity);
            GameControl.increaseHealth();
            GameControl.increaseHunger();
        }
    }
    public static void loseRandomItem(){
        int applesQuantity      = SurviveRexburg.getEndUser().getBackpack().getApples().getQuantityInStock();
        int cannedBeansQuantity = SurviveRexburg.getEndUser().getBackpack().getCannedBeans().getQuantityInStock();
        int cannedTunaQuantity  = SurviveRexburg.getEndUser().getBackpack().getCannedTuna().getQuantityInStock();
        int cerealQuantity      = SurviveRexburg.getEndUser().getBackpack().getCereal().getQuantityInStock();
        int chocolateQuantity   = SurviveRexburg.getEndUser().getBackpack().getChocolate().getQuantityInStock();
        int topRamenQuantity    = SurviveRexburg.getEndUser().getBackpack().getTopRamen().getQuantityInStock();
        int potatoQuantity      = SurviveRexburg.getEndUser().getBackpack().getPotatoes().getQuantityInStock();
        int breadQuantity       = SurviveRexburg.getEndUser().getBackpack().getBread().getQuantityInStock();
        
        int totalQuantity = 
                  applesQuantity        + cannedBeansQuantity 
                + cannedTunaQuantity    + cerealQuantity 
                + chocolateQuantity     + topRamenQuantity 
                + potatoQuantity        + breadQuantity;
        if (totalQuantity > 0){
            if (applesQuantity > 0){
                int newApplesQuantity = applesQuantity - 1;
                SurviveRexburg.getEndUser().getBackpack().getApples().setQuantityInStock(newApplesQuantity);
            }
            else if (cannedBeansQuantity > 0){
                int newCannedBeansQuantity = cannedBeansQuantity - 1;
                SurviveRexburg.getEndUser().getBackpack().getCannedBeans().setQuantityInStock(newCannedBeansQuantity);
            }
            else if (cannedTunaQuantity > 0){
                int newCannedTunaQuantity = cannedTunaQuantity - 1;
                SurviveRexburg.getEndUser().getBackpack().getCannedTuna().setQuantityInStock(newCannedTunaQuantity);
            }
            else if (cerealQuantity > 0){
                int newCerealQuantity = cerealQuantity - 1;
                SurviveRexburg.getEndUser().getBackpack().getCereal().setQuantityInStock(newCerealQuantity);
            }
            else if (chocolateQuantity > 0){
                int newChocolateQuantity = chocolateQuantity - 1;
                SurviveRexburg.getEndUser().getBackpack().getCereal().setQuantityInStock(newChocolateQuantity);
            }
            else if (topRamenQuantity > 0){
                int newTopRamenQuantity = topRamenQuantity - 1;
                SurviveRexburg.getEndUser().getBackpack().getTopRamen().setQuantityInStock(newTopRamenQuantity);
            }
            else if (potatoQuantity > 0){
                int newPotatoQuantity = potatoQuantity - 1;
                SurviveRexburg.getEndUser().getBackpack().getTopRamen().setQuantityInStock(newPotatoQuantity);
            }
            else if (breadQuantity > 0){
                int newBreadQuantity = breadQuantity - 1;
                SurviveRexburg.getEndUser().getBackpack().getBread().setQuantityInStock(newBreadQuantity);
            }
        }
        
    }
    
    
    
}//end of class
