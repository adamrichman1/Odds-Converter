package Core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Filename: InputVerifierTests.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains tests for InputVerifier.java
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
class InputVerifierTests {
    private InputVerifier inputVerifier = new InputVerifier();

    /**
     * Tests that oddsFormatSelectionValid() works
     */
    @Test
    void testOddsFormatSelectionValid() {
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
    void testRunAgainInputValid() {
        assertTrue(inputVerifier.runAgainInputValid("yes"));
        assertTrue(inputVerifier.runAgainInputValid("no"));
        assertFalse(inputVerifier.runAgainInputValid("yer"));
    }
}
