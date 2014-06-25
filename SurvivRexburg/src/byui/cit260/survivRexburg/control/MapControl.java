/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import byui.cit260.surviveRexburg.model.Location;

/**
 *
 * @author arturoaguila
 */
class MapControl {

    static void moveActorToStartingLocation(int i, int i0) {
       System.out.println("***move actor to starting location function***");
    }
    
     private static Location[] createLocationList() {
        
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
        
        //16
        Location abandonedHouse1 = new Location();
        abandonedHouse1.setName("Abandoned House");
        abandonedHouse1.setRow(2);
        abandonedHouse1.setColumn(2);
        abandonedHouse1.setVisited(false);
        abandonedHouse1.setScenario(null);
        abandonedHouse1.setSurvivors(null);
        abandonedHouse1.setZombies(null);
        locations[Constants.ABANDONED_HOUSE_1] = abandonedHouse1;
        
        //17
        Location laJolla = new Location();
        laJolla.setName("La Jolla Apartments");
        laJolla.setRow(2);
        laJolla.setColumn(3);
        laJolla.setVisited(false);
        laJolla.setScenario(null);
        laJolla.setSurvivors(null);
        laJolla.setZombies(null);
        locations[Constants.LA_JOLLA] = laJolla;
        
        //18
        Location littleCaesars = new Location();
        littleCaesars.setName("Little Caesar's Pizza");
        littleCaesars.setRow(2);
        littleCaesars.setColumn(4);
        littleCaesars.setVisited(false);
        littleCaesars.setScenario(null);
        littleCaesars.setSurvivors(null);
        littleCaesars.setZombies(null);
        locations[Constants.LITTLE_CAESARS] = littleCaesars;
        
        //19
        Location eyeDoctor = new Location();
        eyeDoctor.setName("Eye Doctor");
        eyeDoctor.setRow(2);
        eyeDoctor.setColumn(5);
        eyeDoctor.setVisited(false);
        eyeDoctor.setScenario(null);
        eyeDoctor.setSurvivors(null);
        eyeDoctor.setZombies(null);
        locations[Constants.EYE_DOCTOR] = eyeDoctor;
        
        //20
        Location pinnacleSecurityOffice = new Location();
        pinnacleSecurityOffice.setName("Pinnacle Security Office");
        pinnacleSecurityOffice.setRow(2);
        pinnacleSecurityOffice.setColumn(6);
        pinnacleSecurityOffice.setVisited(false);
        pinnacleSecurityOffice.setScenario(null);
        pinnacleSecurityOffice.setSurvivors(null);
        pinnacleSecurityOffice.setZombies(null);
        locations[Constants.PINNACLE_SECURITY_OFFICE] = pinnacleSecurityOffice;
        
        //21
        Location porterParkPlayground = new Location();
        porterParkPlayground.setName("Porter Park Playground");
        porterParkPlayground.setRow(3);
        porterParkPlayground.setColumn(0);
        porterParkPlayground.setVisited(false);
        porterParkPlayground.setScenario(null);
        porterParkPlayground.setSurvivors(null);
        porterParkPlayground.setZombies(null);
        locations[Constants.PORTER_PARK_PLAYGROUND] = porterParkPlayground;
        
        //22
        Location kiwiLoco = new Location();
        kiwiLoco.setName("Kiwi Loco");
        kiwiLoco.setRow(3);
        kiwiLoco.setColumn(1);
        kiwiLoco.setVisited(false);
        kiwiLoco.setScenario(null);
        kiwiLoco.setSurvivors(null);
        kiwiLoco.setZombies(null);
        locations[Constants.KIWI_LOCO] = kiwiLoco;
        
        //23
        Location willows = new Location();
        willows.setName("Willows Apartments");
        willows.setRow(3);
        willows.setColumn(2);
        willows.setVisited(false);
        willows.setScenario(null);
        willows.setSurvivors(null);
        willows.setZombies(null);
        locations[Constants.WILLOWS] = willows;
        
        //24
        Location construction = new Location();
        construction.setName("Construction");
        construction.setRow(3);
        construction.setColumn(3);
        construction.setVisited(false);
        construction.setScenario(null);
        construction.setSurvivors(null);
        construction.setZombies(null);
        locations[Constants.CONSTRUCTION] = construction;
        
        //25
        Location postOffice = new Location();
        postOffice.setName("Post Office");
        postOffice.setRow(3);
        postOffice.setColumn(4);
        postOffice.setVisited(false);
        postOffice.setScenario(null);
        postOffice.setSurvivors(null);
        postOffice.setZombies(null);
        locations[Constants.POST_OFFICE] = postOffice;
        
        //26
        Location vikingVillage = new Location();
        vikingVillage.setName("Viking Village Apartments");
        vikingVillage.setRow(3);
        vikingVillage.setColumn(5);
        vikingVillage.setVisited(false);
        vikingVillage.setScenario(null);
        vikingVillage.setSurvivors(null);
        vikingVillage.setZombies(null);
        locations[Constants.VIKING_VILLAGE] = vikingVillage;
        
        //27
        Location emptyLot = new Location();
        emptyLot.setName("Empty Lot");
        emptyLot.setRow(3);
        emptyLot.setColumn(6);
        emptyLot.setVisited(false);
        emptyLot.setScenario(null);
        emptyLot.setSurvivors(null);
        emptyLot.setZombies(null);
        locations[Constants.EMPTY_LOT] = emptyLot;
        
        //28
        Location tacoTime = new Location();
        tacoTime.setName("Taco Time");
        tacoTime.setRow(4);
        tacoTime.setColumn(0);
        tacoTime.setVisited(false);
        tacoTime.setScenario(null);
        tacoTime.setSurvivors(null);
        tacoTime.setZombies(null);
        locations[Constants.TACOTIME] = tacoTime;
        
        //29
        Location birchWoodWest = new Location();
        birchWoodWest.setName("Birchwood Apartments West side");
        birchWoodWest.setRow(4);
        birchWoodWest.setColumn(1);
        birchWoodWest.setVisited(false);
        birchWoodWest.setScenario(null);
        birchWoodWest.setSurvivors(null);
        birchWoodWest.setZombies(null);
        locations[Constants.BIRCHWOOD_WEST] = birchWoodWest;
        
        //30
        Location birchWoodEast = new Location();
        birchWoodEast.setName("Birchwood Apartments East side");
        birchWoodEast.setRow(4);
        birchWoodEast.setColumn(2);
        birchWoodEast.setVisited(false);
        birchWoodEast.setScenario(null);
        birchWoodEast.setSurvivors(null);
        birchWoodEast.setZombies(null);
        locations[Constants.BIRCHWOOD_EAST] = birchWoodEast;
        
        //31
        Location stadium = new Location();
        stadium.setName("Stadium");
        stadium.setRow(4);
        stadium.setColumn(3);
        stadium.setVisited(false);
        stadium.setScenario(null);
        stadium.setSurvivors(null);
        stadium.setZombies(null);
        locations[Constants.STADIUM] = stadium;
        
        //32
        Location snowBuilding = new Location();
        snowBuilding.setName("Snow Building");
        snowBuilding.setRow(4);
        snowBuilding.setColumn(4);
        snowBuilding.setVisited(false);
        snowBuilding.setScenario(null);
        snowBuilding.setSurvivors(null);
        snowBuilding.setZombies(null);
        locations[Constants.SNOW_BUILDING] = snowBuilding;
        
        //33
        Location kirkhamBuilding = new Location();
        kirkhamBuilding.setName("Kirkham Building");
        kirkhamBuilding.setRow(4);
        kirkhamBuilding.setColumn(5);
        kirkhamBuilding.setVisited(false);
        kirkhamBuilding.setScenario(null);
        kirkhamBuilding.setSurvivors(null);
        kirkhamBuilding.setZombies(null);
        locations[Constants.KIRKHAM_BUILDING] = kirkhamBuilding;
        
        //34
        Location crestwood = new Location();
        crestwood.setName("Crestwood Apartments");
        crestwood.setRow(4);
        crestwood.setColumn(6);
        crestwood.setVisited(false);
        crestwood.setScenario(null);
        crestwood.setSurvivors(null);
        crestwood.setZombies(null);
        locations[Constants.CRESTWOOD] = crestwood;
        
        //35
        Location emptyField = new Location();
        emptyField.setName("Empty Field");
        emptyField.setRow(5);
        emptyField.setColumn(0);
        emptyField.setVisited(false);
        emptyField.setScenario(null);
        emptyField.setSurvivors(null);
        emptyField.setZombies(null);
        locations[Constants.EMPTY_FIELD] = emptyField;
        
        //36
        Location abandonedHouse2 = new Location();
        abandonedHouse2.setName("Abandoned House");
        abandonedHouse2.setRow(5);
        abandonedHouse2.setColumn(1);
        abandonedHouse2.setVisited(false);
        abandonedHouse2.setScenario(null);
        abandonedHouse2.setSurvivors(null);
        abandonedHouse2.setZombies(null);
        locations[Constants.ABANDONED_HOUSE_2] = abandonedHouse2;
        
        //37
        Location royalCrest = new Location();
        royalCrest.setName("Royal Crest Apartments");
        royalCrest.setRow(5);
        royalCrest.setColumn(2);
        royalCrest.setVisited(false);
        royalCrest.setScenario(null);
        royalCrest.setSurvivors(null);
        royalCrest.setZombies(null);
        locations[Constants.ROYAL_CREST] = royalCrest;
        
        //38
        Location hartBuilding = new Location();
        hartBuilding.setName("Hart Building");
        hartBuilding.setRow(5);
        hartBuilding.setColumn(3);
        hartBuilding.setVisited(false);
        hartBuilding.setScenario(null);
        hartBuilding.setSurvivors(null);
        hartBuilding.setZombies(null);
        locations[Constants.HART_BUILDING] = hartBuilding;
        
        //39
        Location sporiBuilding = new Location();
        sporiBuilding.setName("Spori Building");
        sporiBuilding.setRow(5);
        sporiBuilding.setColumn(4);
        sporiBuilding.setVisited(false);
        sporiBuilding.setScenario(null);
        sporiBuilding.setSurvivors(null);
        sporiBuilding.setZombies(null);
        locations[Constants.SPORI_BUILDING] = sporiBuilding;
        
        //40
        Location clarkBuilding = new Location();
        clarkBuilding.setName("Clark Building");
        clarkBuilding.setRow(5);
        clarkBuilding.setColumn(5);
        clarkBuilding.setVisited(false);
        clarkBuilding.setScenario(null);
        clarkBuilding.setSurvivors(null);
        clarkBuilding.setZombies(null);
        locations[Constants.CLARK_BUILDING] = clarkBuilding;
        
        //41
        Location abandonedHouse3 = new Location();
        abandonedHouse3.setName("Abandoned House");
        abandonedHouse3.setRow(5);
        abandonedHouse3.setColumn(6);
        abandonedHouse3.setVisited(false);
        abandonedHouse3.setScenario(null);
        abandonedHouse3.setSurvivors(null);
        abandonedHouse3.setZombies(null);
        locations[Constants.ABANDONED_HOUSE_3] = abandonedHouse3;
        
        //42
        Location newFongs = new Location();
        newFongs.setName("New Fongs");
        newFongs.setRow(6);
        newFongs.setColumn(0);
        newFongs.setVisited(false);
        newFongs.setScenario(null);
        newFongs.setSurvivors(null);
        newFongs.setZombies(null);
        locations[Constants.NEW_FONGS] = newFongs;
        
        //43
        Location brooklyn = new Location();
        brooklyn.setName("Brooklyn Apartments");
        brooklyn.setRow(6);
        brooklyn.setColumn(1);
        brooklyn.setVisited(false);
        brooklyn.setScenario(null);
        brooklyn.setSurvivors(null);
        brooklyn.setZombies(null);
        locations[Constants.BROOKLYN] = brooklyn;
        
        //44
        Location bunkhouse = new Location();
        bunkhouse.setName("Bunkhouse Apartments");
        bunkhouse.setRow(6);
        bunkhouse.setColumn(2);
        bunkhouse.setVisited(false);
        bunkhouse.setScenario(null);
        bunkhouse.setSurvivors(null);
        bunkhouse.setZombies(null);
        locations[Constants.BUNKHOUSE] = bunkhouse;
        
        //45
        Location alleyway = new Location();
        alleyway.setName("Alleyway");
        alleyway.setRow(6);
        alleyway.setColumn(3);
        alleyway.setVisited(false);
        alleyway.setScenario(null);
        alleyway.setSurvivors(null);
        alleyway.setZombies(null);
        locations[Constants.ALLEYWAY] = alleyway;
        
        //46
        Location library = new Location();
        library.setName("Library");
        library.setRow(6);
        library.setColumn(4);
        library.setVisited(false);
        library.setScenario(null);
        library.setSurvivors(null);
        library.setZombies(null);
        locations[Constants.LIBRARY] = library;
        
        //47
        Location smithBuilding = new Location();
        smithBuilding.setName("Smith Building");
        smithBuilding.setRow(6);
        smithBuilding.setColumn(5);
        smithBuilding.setVisited(false);
        smithBuilding.setScenario(null);
        smithBuilding.setSurvivors(null);
        smithBuilding.setZombies(null);
        locations[Constants.SMITH_BUILDING] = smithBuilding;
        
        //48
        Location northDorms = new Location();
        northDorms.setName("North Dorms");
        northDorms.setRow(6);
        northDorms.setColumn(6);
        northDorms.setVisited(false);
        northDorms.setScenario(null);
        northDorms.setSurvivors(null);
        northDorms.setZombies(null);
        locations[Constants.NORTH_DORMS] = northDorms;
        
        //49
        Location tacoBus = new Location();
        tacoBus.setName("Taco Bus");
        tacoBus.setRow(7);
        tacoBus.setColumn(0);
        tacoBus.setVisited(false);
        tacoBus.setScenario(null);
        tacoBus.setSurvivors(null);
        tacoBus.setZombies(null);
        locations[Constants.TACO_BUS] = tacoBus;
        
        //50
        Location subway = new Location();
        subway.setName("Subway");
        subway.setRow(7);
        subway.setColumn(1);
        subway.setVisited(false);
        subway.setScenario(null);
        subway.setSurvivors(null);
        subway.setZombies(null);
        locations[Constants.SUBWAY] = subway;

        //51
        Location shakeOut = new Location();
        shakeOut.setName("Shake Out");
        shakeOut.setRow(7);
        shakeOut.setColumn(2);
        shakeOut.setVisited(false);
        shakeOut.setScenario(null);
        shakeOut.setSurvivors(null);
        shakeOut.setZombies(null);
        locations[Constants.SHAKE_OUT] = shakeOut;
        
        //52
        Location iCenter = new Location();
        iCenter.setName("I-Center");
        iCenter.setRow(7);
        iCenter.setColumn(3);
        iCenter.setVisited(false);
        iCenter.setScenario(null);
        iCenter.setSurvivors(null);
        iCenter.setZombies(null);
        locations[Constants.ICENTER] = iCenter;
        
        //53
        Location mcWest = new Location();
        mcWest.setName("MC Building West Side");
        mcWest.setRow(7);
        mcWest.setColumn(4);
        mcWest.setVisited(false);
        mcWest.setScenario(null);
        mcWest.setSurvivors(null);
        mcWest.setZombies(null);
        locations[Constants.MC_WEST] = mcWest;
        
        //54
        Location mcEast = new Location();
        mcEast.setName("MC Building East Side");
        mcEast.setRow(7);
        mcEast.setColumn(5);
        mcEast.setVisited(false);
        mcEast.setScenario(null);
        mcEast.setSurvivors(null);
        mcEast.setZombies(null);
        locations[Constants.MC_EAST] = mcEast;
        
        //55
        Location southDorms = new Location();
        southDorms.setName("South Dorms");
        southDorms.setRow(7);
        southDorms.setColumn(6);
        southDorms.setVisited(false);
        southDorms.setScenario(null);
        southDorms.setSurvivors(null);
        southDorms.setZombies(null);
        locations[Constants.SOUTH_DORMS] = southDorms;
        
          
        return locations;
    }
    
    
    
    
}//end of class
