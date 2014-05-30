/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arturoaguila
 */
public class GameControlTest {
    
    public GameControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of increaseDailyDifficulty method, of class GameControl.
     */
    @Test
    public void testIncreaseDailyDifficulty() {
        System.out.println("increaseDailyDifficulty");
        int scenarioValue = 54;
        int daysPassed = 10;
        GameControl instance = new GameControl();
        int expResult = 44;
        int result = instance.increaseDailyDifficulty(scenarioValue, daysPassed);
        assertEquals(expResult, result);
    }

    /**
     * Test of decreaseCharHunger method, of class GameControl.
     */
    @Test
    public void testDecreaseCharHunger() {
        System.out.println("decreaseCharHunger");
        int charHungerValue = 100;
        GameControl instance = new GameControl();
        int result = instance.decreaseCharHunger(charHungerValue);
        assertTrue(result > 0 && result < 100);
    }
    
}
