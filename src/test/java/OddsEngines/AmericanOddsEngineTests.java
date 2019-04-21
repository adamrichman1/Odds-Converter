package OddsEngines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Filename: AmericanOddsEngineTests.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains tests for AmericanOddsEngine.java
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
class AmericanOddsEngineTests {
    private AmericanOddsEngine oddsEngine = new AmericanOddsEngine();

    /**
     * Tests convertToImpliedProbability()
     */
    @Test
    void testConvertToImpliedProbability() {
        assertEquals(0.50, oddsEngine.convertToImpliedProbability("-100"));
        assertEquals(.75, oddsEngine.convertToImpliedProbability("-300"));
        assertEquals(.25, oddsEngine.convertToImpliedProbability("+300"));
        assertEquals(.99, oddsEngine.convertToImpliedProbability("-9900"));
        assertEquals(.80, oddsEngine.convertToImpliedProbability("-400"));
        assertEquals(.40, oddsEngine.convertToImpliedProbability("+150"));
        assertEquals(.02, oddsEngine.convertToImpliedProbability("+4900"));
        assertEquals(.01, oddsEngine.convertToImpliedProbability("+9900"));
    }

    /**
     * Tests convertToOdds()
     */
    @Test
    void testConvertToOdds() {
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
    void testOddsValid() {
        assertTrue(oddsEngine.oddsValid("-300"));
        assertTrue(oddsEngine.oddsValid("+400"));
        assertFalse(oddsEngine.oddsValid("300"));
        assertFalse(oddsEngine.oddsValid("-99"));
    }

    /**
     * Tests getId()
     */
    @Test
    void testGetId() {
        assertEquals("American", oddsEngine.getId());
    }
}
