package OddsEngines;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Filename: AmericanOddsEngineTests.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains tests for AmericanOddsEngine.java
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public class AmericanOddsEngineTests {
    private AmericanOddsEngine oddsEngine = new AmericanOddsEngine();

    /**
     * Tests convertToImpliedProbability()
     */
    @Test
    public void testConvertToImpliedProbability() {
        assertEquals(0.50, oddsEngine.convertToImpliedProbability("-100"), 0);
        assertEquals(.75, oddsEngine.convertToImpliedProbability("-300"), 0);
        assertEquals(.25, oddsEngine.convertToImpliedProbability("+300"), 0);
        assertEquals(.99, oddsEngine.convertToImpliedProbability("-9900"), 0);
        assertEquals(.80, oddsEngine.convertToImpliedProbability("-400"), 0);
        assertEquals(.40, oddsEngine.convertToImpliedProbability("+150"), 0);
        assertEquals(.02, oddsEngine.convertToImpliedProbability("+4900"), 0);
        assertEquals(.01, oddsEngine.convertToImpliedProbability("+9900"), 0);
    }

    /**
     * Tests convertToOdds()
     */
    @Test
    public void testConvertToOdds() {
        assertEquals("-100", oddsEngine.convertToOdds(.50));
        assertEquals("-300", oddsEngine.convertToOdds(.75));
        assertEquals("+3233", oddsEngine.convertToOdds(.03));
        assertEquals("+300", oddsEngine.convertToOdds(.25));
        assertEquals("-9900", oddsEngine.convertToOdds(.99));
        assertEquals("-400", oddsEngine.convertToOdds(.80));
        assertEquals("+150", oddsEngine.convertToOdds(.40));
        assertEquals("+4900", oddsEngine.convertToOdds(.02));
        assertEquals("+9900", oddsEngine.convertToOdds(.01));
    }

    /**
     * Tests oddsValid()
     */
    @Test
    public void testOddsValid() {
        assertTrue(oddsEngine.oddsValid("-300"));
        assertTrue(oddsEngine.oddsValid("+400"));
        assertFalse(oddsEngine.oddsValid("300"));
        assertFalse(oddsEngine.oddsValid("-99"));
    }

    /**
     * Tests getId()
     */
    @Test
    public void testGetId() {
        assertEquals("American", oddsEngine.getId());
    }
}
