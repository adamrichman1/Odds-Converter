package Core;

import OddsEngines.OddsEngineFactory;

import java.util.Scanner;

/**
 * Filename: IOController.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class controls I/O with the user
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
class IOController {

    private InputVerifier inputVerifier;

    /**
     * Used to create an Core.IOController - dependency injection
     *
     * @param inputVerifier the Core.InputVerifier to use
     */
    IOController(InputVerifier inputVerifier) {
        this.inputVerifier = inputVerifier;
    }

    /**
     * Requests a user for odds in the desired format
     *
     * @param selection the odds format selection from the user
     * @return the odds from the user
     */
    String requestOdds(String selection) {
        String input;
        do {
            System.out.println("\nEnter the odds in " + OddsEngineFactory.createOddsEngine(selection).getId() + " format:");
        }
        while (inputVerifier.oddsInvalid(selection, (input = readInput())));
        return input;
    }

    /**
     * Checks if the user wants to run the program again
     *
     * @return true if the user wants to run the program again, false otherwise
     */
    boolean runAgain() {
        String selection;
        do {
            System.out.println("\nConvert again? Enter either 'yes' or 'no'.");
        }
        while (!inputVerifier.runAgainInputValid(selection = readInput()));
        return selection.equalsIgnoreCase("yes");
    }

    /**
     * Requests the user for an input odds format
     */
    String requestInputOddsFormat() {
        String selection;
        do {
            System.out.println("\nEnter desired input odds format (either 1, 2, 3, or 4):\n1. Implied Probability (ex: 0.45)\n2. Decimal (ex: 2.5)\n3. Fractional (ex: 5/1)\n4. American (ex: +300)");
        }
        while (!inputVerifier.oddsFormatSelectionValid(selection = readInput()));
        return selection;
    }

    /**
     * Reads input from the user
     *
     * @return the user's input
     */
    private String readInput() {
        return new Scanner(System.in).nextLine();
    }
}
