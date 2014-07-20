/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

/**
 *
 * @author carissa888
 */
public class Backpack implements Serializable {

    /*public static String size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void add(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void remove(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    

    
    //class instance variables
    private int maxWeight;
    private int loadedWeight;
    
    private Food cannedTuna;
    private Food cannedBeans;
    private Food mangos;
    private Food cannedChicken;
    private Food cannedBeefStew;
    private Food apples;
    private Food bananas;
    private Food saltineCrackers;
    private Food cannedChickenSoup;
    private Food milk;
    private Food potatoes;
    private Food bread;
    private Food cheese;
    private Food cereal;
    private Food eggs;
    private Food topRamen;
    private Food chocolate;
    private Food soda;
    
    
    

    public Backpack() {
    }
    
    
    //getter and setter
    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getLoadedWeight() {
        return loadedWeight;
    }

    public void setLoadedWeight(int loadedWeight) {
        this.loadedWeight = loadedWeight;
    }

    public Food getApples() {
        return apples;
    }

    public void setApples(Food apples) {
        this.apples = apples;
    }

    public Food getCannedTuna() {
        return cannedTuna;
    }

    public void setCannedTuna(Food cannedTuna) {
        this.cannedTuna = cannedTuna;
    }

    public Food getCannedBeans() {
        return cannedBeans;
    }

    public void setCannedBeans(Food cannedBeans) {
        this.cannedBeans = cannedBeans;
    }

    public Food getMangos() {
        return mangos;
    }

    public void setMangos(Food mangos) {
        this.mangos = mangos;
    }

    public Food getCannedChicken() {
        return cannedChicken;
    }

    public void setCannedChicken(Food cannedChicken) {
        this.cannedChicken = cannedChicken;
    }

    public Food getCannedBeefStew() {
        return cannedBeefStew;
    }

    public void setCannedBeefStew(Food cannedBeefStew) {
        this.cannedBeefStew = cannedBeefStew;
    }

    public Food getBananas() {
        return bananas;
    }

    public void setBananas(Food bananas) {
        this.bananas = bananas;
    }

    public Food getSaltineCrackers() {
        return saltineCrackers;
    }

    public void setSaltineCrackers(Food saltineCrackers) {
        this.saltineCrackers = saltineCrackers;
    }

    public Food getCannedChickenSoup() {
        return cannedChickenSoup;
    }

    public void setCannedChickenSoup(Food cannedChickenSoup) {
        this.cannedChickenSoup = cannedChickenSoup;
    }

    public Food getMilk() {
        return milk;
    }

    public void setMilk(Food milk) {
        this.milk = milk;
    }

    public Food getPotatoes() {
        return potatoes;
    }

    public void setPotatoes(Food potatoes) {
        this.potatoes = potatoes;
    }

    public Food getBread() {
        return bread;
    }

    public void setBread(Food bread) {
        this.bread = bread;
    }

    public Food getCheese() {
        return cheese;
    }

    public void setCheese(Food cheese) {
        this.cheese = cheese;
    }

    public Food getCereal() {
        return cereal;
    }

    public void setCereal(Food cereal) {
        this.cereal = cereal;
    }

    public Food getEggs() {
        return eggs;
    }

    public void setEggs(Food eggs) {
        this.eggs = eggs;
    }

    public Food getTopRamen() {
        return topRamen;
    }

    public void setTopRamen(Food topRamen) {
        this.topRamen = topRamen;
    }

    public Food getChocolate() {
        return chocolate;
    }

    public void setChocolate(Food chocolate) {
        this.chocolate = chocolate;
    }

    public Food getSoda() {
        return soda;
    }

    public void setSoda(Food soda) {
        this.soda = soda;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.maxWeight;
        hash = 79 * hash + this.loadedWeight;
        hash = 79 * hash + Objects.hashCode(this.cannedTuna);
        hash = 79 * hash + Objects.hashCode(this.cannedBeans);
        hash = 79 * hash + Objects.hashCode(this.mangos);
        hash = 79 * hash + Objects.hashCode(this.cannedChicken);
        hash = 79 * hash + Objects.hashCode(this.cannedBeefStew);
        hash = 79 * hash + Objects.hashCode(this.apples);
        hash = 79 * hash + Objects.hashCode(this.bananas);
        hash = 79 * hash + Objects.hashCode(this.saltineCrackers);
        hash = 79 * hash + Objects.hashCode(this.cannedChickenSoup);
        hash = 79 * hash + Objects.hashCode(this.milk);
        hash = 79 * hash + Objects.hashCode(this.potatoes);
        hash = 79 * hash + Objects.hashCode(this.bread);
        hash = 79 * hash + Objects.hashCode(this.cheese);
        hash = 79 * hash + Objects.hashCode(this.cereal);
        hash = 79 * hash + Objects.hashCode(this.eggs);
        hash = 79 * hash + Objects.hashCode(this.topRamen);
        hash = 79 * hash + Objects.hashCode(this.chocolate);
        hash = 79 * hash + Objects.hashCode(this.soda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Backpack other = (Backpack) obj;
        if (this.maxWeight != other.maxWeight) {
            return false;
        }
        if (this.loadedWeight != other.loadedWeight) {
            return false;
        }
        if (!Objects.equals(this.cannedTuna, other.cannedTuna)) {
            return false;
        }
        if (!Objects.equals(this.cannedBeans, other.cannedBeans)) {
            return false;
        }
        if (!Objects.equals(this.mangos, other.mangos)) {
            return false;
        }
        if (!Objects.equals(this.cannedChicken, other.cannedChicken)) {
            return false;
        }
        if (!Objects.equals(this.cannedBeefStew, other.cannedBeefStew)) {
            return false;
        }
        if (!Objects.equals(this.apples, other.apples)) {
            return false;
        }
        if (!Objects.equals(this.bananas, other.bananas)) {
            return false;
        }
        if (!Objects.equals(this.saltineCrackers, other.saltineCrackers)) {
            return false;
        }
        if (!Objects.equals(this.cannedChickenSoup, other.cannedChickenSoup)) {
            return false;
        }
        if (!Objects.equals(this.milk, other.milk)) {
            return false;
        }
        if (!Objects.equals(this.potatoes, other.potatoes)) {
            return false;
        }
        if (!Objects.equals(this.bread, other.bread)) {
            return false;
        }
        if (!Objects.equals(this.cheese, other.cheese)) {
            return false;
        }
        if (!Objects.equals(this.cereal, other.cereal)) {
            return false;
        }
        if (!Objects.equals(this.eggs, other.eggs)) {
            return false;
        }
        if (!Objects.equals(this.topRamen, other.topRamen)) {
            return false;
        }
        if (!Objects.equals(this.chocolate, other.chocolate)) {
            return false;
        }
        if (!Objects.equals(this.soda, other.soda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Backpack{" + "maxWeight=" + maxWeight + ", loadedWeight=" + loadedWeight + ", cannedTuna=" + cannedTuna + ", cannedBeans=" + cannedBeans + ", mangos=" + mangos + ", cannedChicken=" + cannedChicken + ", cannedBeefStew=" + cannedBeefStew + ", apples=" + apples + ", bananas=" + bananas + ", saltineCrackers=" + saltineCrackers + ", cannedChickenSoup=" + cannedChickenSoup + ", milk=" + milk + ", potatoes=" + potatoes + ", bread=" + bread + ", cheese=" + cheese + ", cereal=" + cereal + ", eggs=" + eggs + ", topRamen=" + topRamen + ", chocolate=" + chocolate + ", soda=" + soda + '}';
    }
    
    
    
    
   

    

    

    

    
    
    
    
}//end of class
