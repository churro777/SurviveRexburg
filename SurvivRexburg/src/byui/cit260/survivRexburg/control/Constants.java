/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

/**
 *
 * @author arturoaguila
 */
public class Constants {
    //Characters and their stats
    public final static int NUMBER_OF_CHARACTERS = 4;
    
    public static final int BEN = 0;
    
    public final static int BING = 1;
    
    public final static int HAYLEY = 2;
    
    public final static int MEGAN = 3;
    
    //Map
    public final static int MAP_ROW_COUNT = 8;
    public final static int MAP_COLUMN_COUNT = 8;
    
    //Locations
    public final static int GUNSTORE = 0;
    public final static int JAMBA_JUICE = 1;
    public final static int BROULIMS = 2;
    public final static int FIRE_STATION = 3;
    public final static int TACOBELL = 4;
    public final static int BIKE_STORE = 5;
    public final static int INSURANCE_OFFICE = 6;
    public final static int MAVERICKS = 7;
    public final static int DOMINOS = 8;
    public final static int SALON = 9;
    public final static int MELALUCA = 10;
    public final static int DONUTS = 11;
    public final static int GRINGOS = 12;
    public final static int KEYBANK = 13;
    public final static int PORTER_PARK_FIELD = 14;
    public final static int NIELSONS = 15;
    public final static int ABANDONED_HOUSE_1 = 16;
    public final static int LA_JOLLA = 17;
    public final static int LITTLE_CAESARS = 18;
    public final static int EYE_DOCTOR = 19;
    public final static int PINNACLE_SECURITY_OFFICE = 20;
    public final static int PORTER_PARK_PLAYGROUND = 21;
    public final static int KIWI_LOCO = 22;
    public final static int WILLOWS = 23;
    public final static int CONSTRUCTION = 24;
    public final static int POST_OFFICE = 25;
    public final static int VIKING_VILLAGE = 26;
    public final static int EMPTY_LOT = 27;
    public final static int TACOTIME = 28;
    public final static int BIRCHWOOD_WEST = 29;
    public final static int BIRCHWOOD_EAST = 30;
    public final static int STADIUM = 31;
    public final static int SNOW_BUILDING = 32;
    public final static int KIRKHAM_BUILDING = 33;
    public final static int CRESTWOOD = 34;
    public final static int EMPTY_FIELD = 35;
    public final static int ABANDONED_HOUSE_2 = 36;
    public final static int ROYAL_CREST = 37;
    public final static int HART_BUILDING = 38;
    public final static int SPORI_BUILDING = 39;
    public final static int CLARK_BUILDING = 40;
    public final static int ABANDONED_HOUSE_3 = 41;
    public final static int NEW_FONGS = 42;
    public final static int BROOKLYN = 43;
    public final static int BUNKHOUSE = 44;
    public final static int ALLEYWAY = 45;
    public final static int LIBRARY = 46;
    public final static int SMITH_BUILDING = 47;
    public final static int NORTH_DORMS = 48;
    public final static int TACO_BUS = 49;
    public final static int SUBWAY = 50;
    public final static int SHAKE_OUT = 51;
    public final static int ICENTER = 52;
    public final static int MC_WEST = 53;
    public final static int MC_EAST = 54;
    public final static int SOUTH_DORMS = 55;
    
    
    //items
    public final static int NUMBER_OF_ITEMS = 47;
    
    //food
    public final static int CANNED_TUNA         = 0;
    public final static int CANNED_BEANS        = 1;
    public final static int MANGOS              = 2;
    public final static int CANNED_CHICKEN      = 3;
    public final static int CANED_BEEF_STEW     = 4;
    public final static int APPLES              = 5;
    public final static int BANANAS             = 6;
    public final static int SALTINE_CRACKERS    = 7;
    public final static int CANNED_CHICKEN_SOUP = 8;
    public final static int MILK                = 9;
    public final static int POTATOES            = 10;
    public final static int BREAD               = 11;
    public final static int CHEESE              = 12;
    public final static int CEREAL              = 13;
    public final static int EGGS                = 14;
    public final static int TOP_RAMEN           = 15;
    public final static int CHOCOLATE           = 16;
    public final static int SODA                = 17;
    
    //spoiled food
    public final static int ROTTEN_EGGS     = 18;
    public final static int MOLDY_CHEESE    = 19;
    public final static int SOUR_MILK       = 20;
    public final static int MOLDY_BREAD     = 21;
    public final static int ROTTEN_MANGO    = 22;
    public final static int ROTTEN_APPLE    = 23;
    public final static int ROTTEN_BANANA   = 24;
    
    //melee weapons
    public final static int BASEBALL_BAT    = 25;
    public final static int SLEDGE_HAMMER   = 26;
    public final static int HAMMER          = 27;
    public final static int GOLF_CLUB       = 28;
    public final static int STEAK_KNIFE     = 29;
    public final static int TENNIS_RACKET   = 30;
    
    //ranged weapons
    public final static int SHOTGUN         = 31;
    public final static int HUNTING_RIFLE   = 32;
    public final static int HANDGUN         = 33;
    public final static int BOW_AND_ARROW   = 34;
    
    //random items
    public final static int LAPTOP          = 35;
    public final static int TEXTBOOK        = 36;
    public final static int BOOTS           = 37;
    public final static int STUFFED_ANIMALS = 38;
    public final static int FRYING_PAN      = 39;
    public final static int SOCCER_BALL     = 40;
    public final static int BASKETBALL      = 41;
    public final static int NOTEBOOK        = 42;
    public final static int TV_REMOTE       = 43;
    public final static int KEYS            = 44;
    public final static int FISHING_ROD     = 45;
    public final static int TENNIS_BALL     = 46;
    
    
    
    
    
    //Scenarios
    public final static int SCENARIOS_COUNT = 23;
    //Always happen
    public final static int DAY_STARTS = 0;
    public final static int DAY_ENDS = 1;
    //OUTCOMES - StartDay > Stay In Location CHOICE
    public final static int NOTHING_HAPPENS = 2;
    public final static int SURVIVORS_OFFER_HELP = 3;
    public final static int SURVIVORS_ASK_HELP = 4;
    public final static int SURVIVORS_ATTACK = 5;
    public final static int ZOMBIES_ATTACK = 6;
    
    //OUTCOMES - Survivors Offer Help > Accept Help CHOICE
    public final static int SURVIVORS_GIVE_YOU_ITEM = 7;
    public final static int TRICKED_ATTACKED_AFTER_OFFERING_HELP = 8;
    
    //OUTCOMES - Survivors Offer Help > Accept Help CHOICE
    //         > Survivors Give Item >  Accept Item CHOICE
    public final static int DAY_ENDS_ACCEPT_HELP_ACCEPT_ITEM = 9;
    
    //OUTCOMES - Survivors Offer Help > Accept Help CHOICE
    //         > Survivors Give Item >  Deny Item CHOICE
    public final static int DAY_ENDS_ACCEPT_HELP_DENY_ITEM = 10;
    
    //OUTCOMES - Survivors Offer Help > Accept Help CHOICE
    //         > Survivors Attack You > Run CHOICE
    public final static int ESCAPE_TO_LOCATION_DAY_ENDS = 11;
    public final static int CAPTURED_AND_INJURED_DAY_ENDS = 12;
    public final static int CAPTURED_INJURED_ROBBED_DAY_ENDS = 13;
    public final static int CAPTURED_AND_DEAD = 14;
    
    //OUTCOMES - Survivors Offer Help > Accept Help CHOICE
    //         > Survivors Attack You > Negotiate CHOICE
    public final static int SURVIVORS_LISTEN_TO_NEGOTIATION = 15;
    public final static int SURVIVORS_DONT_LISTEN_TO_NEGOTIATION = 16;
    
    //OUTCOMES - Survivors Offer Help > Accept Help CHOICE
    //         > Survivors Attack You > Fight CHOICE
    public final static int WIN_FIGHT_GAIN_SUPPLIES_DAY_ENDS = 17;
    public final static int WIN_FIGHT_DAY_ENDS = 18;
    public final static int LOSE_FIGHT_INJURED_DAY_ENDS = 19;
    public final static int LOSE_FIGHT_DEAD = 20;
    
    //OUTCOMES - Surivors Offer Help > Accept Help CHOICE
    //         > Survivors Attack You > Negotiate CHOICE
    public final static int TAKE_OFFER_AND_LEAVE_DAY_ENDS = 21;
    public final static int DONT_TAKE_OFFER_AND_ATTACK = 22;
    
    
    
    
    
    
    
    
            
}
