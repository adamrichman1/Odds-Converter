package OddsEngines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Filename: FractionalOddsEngineTests.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains tests for FractionalOddsEngine.java
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
class FractionalOddsEngineTests {
    private FractionalOddsEngine oddsEngine = new FractionalOddsEngine();

    /**
     * Tests convertToImpliedProbability()
     */
    @Test
    void testConvertToImpliedProbability() {
        assertEquals(.20, oddsEngine.convertToImpliedProbability("4/1"), 0);
        assertEquals(.60, oddsEngine.convertToImpliedProbability("2/3"), 0);
        assertEquals(.75, oddsEngine.convertToImpliedProbability("1/3"), 0);
        assertEquals(.40, oddsEngine.convertToImpliedProbability("3/2"), 0);
    }

    /**
     * Tests convertToOdds()
     */
    @Test
    void testConvertToOdds() {
        assertEquals("4/1", oddsEngine.convertToOdds(.20));
        assertEquals("67/100", oddsEngine.convertToOdds(.60));
        assertEquals("33/100", oddsEngine.convertToOdds(.75));
        assertEquals("3/2", oddsEngine.convertToOdds(.40));
    }

    /**
     * Tests oddsValid()
     */
    @Test
    void testOddsValid() {
        assertTrue(oddsEngine.oddsValid("5/3"));
        assertTrue(oddsEngine.oddsValid("20/30"));
        assertFalse(oddsEngine.oddsValid("5.0"));
        assertFalse(oddsEngine.oddsValid("3.0/99"));
        assertFalse(oddsEngine.oddsValid("3/.99"));
    }

    /**
     * Tests getId()
     */
    @Test
    void testGetId() {
        assertEquals("Fractional", oddsEngine.getId());
    }
}
