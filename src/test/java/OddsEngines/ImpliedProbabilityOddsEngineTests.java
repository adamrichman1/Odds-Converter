package OddsEngines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Filename: ImpliedProbabilityOddsEngineTests.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains tests for ImpliedProbabilityOddsEngine.java
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
class ImpliedProbabilityOddsEngineTests {
    private ImpliedProbabilityOddsEngine oddsEngine = new ImpliedProbabilityOddsEngine();

    /**
     * Tests convertToImpliedProbability()
     */
    @Test
    void testConvertToImpliedProbability() {
        assertEquals(.20, oddsEngine.convertToImpliedProbability(".20"), 0);
        assertEquals(.60, oddsEngine.convertToImpliedProbability(".60"), 0);
        assertEquals(.75, oddsEngine.convertToImpliedProbability(".75"), 0);
        assertEquals(.40, oddsEngine.convertToImpliedProbability(".40"), 0);
    }

    /**
     * Tests convertToOdds()
     */
    @Test
    void testConvertToOdds() {
        assertEquals("0.2", oddsEngine.convertToOdds(.20));
        assertEquals("0.6", oddsEngine.convertToOdds(.60));
        assertEquals("0.75", oddsEngine.convertToOdds(.75));
        assertEquals("0.4", oddsEngine.convertToOdds(.40));
    }

    /**
     * Tests oddsValid()
     */
    @Test
    void testOddsValid() {
        assertTrue(oddsEngine.oddsValid("3.0"));
        assertTrue(oddsEngine.oddsValid("0.45"));
        assertFalse(oddsEngine.oddsValid("hey"));
        assertFalse(oddsEngine.oddsValid("-.05"));
    }

    /**
     * Tests getId()
     */
    @Test
    void testGetId() {
        assertEquals("Implied Probability", oddsEngine.getId());
    }
}
