package Core;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Filename: InputVerifierTests.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains tests for InputVerifier.java
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public class InputVerifierTests {
    private InputVerifier inputVerifier = new InputVerifier();

    /**
     * Tests that oddsFormatSelectionValid() works
     */
    @Test
    public void testOddsFormatSelectionValid() {
        assertTrue(inputVerifier.oddsFormatSelectionValid("1"));
        assertTrue(inputVerifier.oddsFormatSelectionValid("2"));
        assertTrue(inputVerifier.oddsFormatSelectionValid("3"));
        assertTrue(inputVerifier.oddsFormatSelectionValid("4"));
        assertFalse(inputVerifier.oddsFormatSelectionValid("5"));
    }

    /**
     * Tests that runAgainInputValid() works
     */
    @Test
    public void testRunAgainInputValid() {
        assertTrue(inputVerifier.runAgainInputValid("yes"));
        assertTrue(inputVerifier.runAgainInputValid("no"));
        assertFalse(inputVerifier.runAgainInputValid("yer"));
    }
}
