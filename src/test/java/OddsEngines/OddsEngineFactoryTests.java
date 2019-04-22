package OddsEngines;

import java.util.HashMap;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Filename: OddsEngineFactoryTests.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains tests for OddsEngineFactory.java
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public class OddsEngineFactoryTests {

    /**
     * Tests createOddsEngine()
     */
    @Test
    public void testCreateOddsEngine() {
        assertTrue(OddsEngineFactory.createOddsEngine("1") instanceof ImpliedProbabilityOddsEngine);
        assertTrue(OddsEngineFactory.createOddsEngine("2") instanceof DecimalOddsEngine);
        assertTrue(OddsEngineFactory.createOddsEngine("3") instanceof FractionalOddsEngine);
        assertTrue(OddsEngineFactory.createOddsEngine("4") instanceof AmericanOddsEngine);
        assertThrows(IllegalArgumentException.class, () -> OddsEngineFactory.createOddsEngine("5"));
    }

    /**
     * Tests convertOdds()
     */
    @Test
    public void testConvertOdds() {
        HashMap<String, String> convertedOdds = OddsEngineFactory.convertOdds(.40);
        assertEquals(5, convertedOdds.size());
        assertTrue(convertedOdds.containsKey("Implied Probability"));
        assertTrue(convertedOdds.containsKey("Fractional"));
        assertTrue(convertedOdds.containsKey("Decimal"));
        assertTrue(convertedOdds.containsKey("American"));
        assertTrue(convertedOdds.containsKey("Vigorish"));
    }
}
