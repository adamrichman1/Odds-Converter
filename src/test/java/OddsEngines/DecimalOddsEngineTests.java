package OddsEngines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Filename: DecimalOddsEngineTests.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains tests for DecimalOddsEngine.java
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
class DecimalOddsEngineTests {
    private DecimalOddsEngine oddsEngine = new DecimalOddsEngine();

    /**
     * Tests convertToImpliedProbability()
     */
    @Test
    void testConvertToImpliedProbability() {
        assertEquals(0.50, oddsEngine.convertToImpliedProbability("2.0"), 0);
        assertEquals(.25, oddsEngine.convertToImpliedProbability("4.0"), 0);
        assertEquals(.80, oddsEngine.convertToImpliedProbability("1.25"), 0);
        assertEquals(.40, oddsEngine.convertToImpliedProbability("2.5"), 0);
    }

    /**
     * Tests convertToOdds()
     */
    @Test
    void testConvertToOdds() {
        assertEquals(2.0, Double.parseDouble(oddsEngine.convertToOdds(.50)), 0);
        assertEquals(1.33, Double.parseDouble(oddsEngine.convertToOdds(.75)), 0);
        assertEquals(33.33, Double.parseDouble(oddsEngine.convertToOdds(.03)), 0);
        assertEquals(4.0, Double.parseDouble(oddsEngine.convertToOdds(.25)), 0);
        assertEquals(1.01, Double.parseDouble(oddsEngine.convertToOdds(.99)), 0);
        assertEquals(1.25, Double.parseDouble(oddsEngine.convertToOdds(.80)), 0);
        assertEquals(2.5, Double.parseDouble(oddsEngine.convertToOdds(.40)), 0);
    }

    /**
     * Tests oddsValid()
     */
    @Test
    void testOddsValid() {
        assertTrue(oddsEngine.oddsValid("4.0"));
        assertTrue(oddsEngine.oddsValid("3.0"));
        assertFalse(oddsEngine.oddsValid(".99"));
        assertFalse(oddsEngine.oddsValid("-4.0"));
    }

    /**
     * Tests getId()
     */
    @Test
    void testGetId() {
        assertEquals("Decimal", oddsEngine.getId());
    }
}
