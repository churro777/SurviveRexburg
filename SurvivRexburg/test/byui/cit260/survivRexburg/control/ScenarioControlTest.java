/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.survivRexburg.control;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arturoaguila
 */
public class ScenarioControlTest {
    
    public ScenarioControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of chooseScenarioValue method, of class ScenarioControl.
     */
    @Test
    public void testChooseScenarioValue() {
        System.out.println("chooseScenarioValue");
        int charLuckValue = 8;
        ScenarioControl instance = new ScenarioControl();
        int result = instance.chooseScenarioValue(charLuckValue);
        assertTrue(result > 0 && result < 109);
        
    }
    
}
