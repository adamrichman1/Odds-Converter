import OddsEngines.OddsEngineFactory;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Filename: Driver.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class drives the program
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public class Driver {
    /**
     * Drives the main program
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        do {
            String selection = requestInputOddsFormat();
            convertToAllFormats(convertToImpliedProbability(selection, requestOdds(selection)));
        } while (runAgain());
    }

    /**
     * Converts odds to implied probability format
     *
     * @param selection the odds format selection by the user
     * @param odds the odds input from the user
     * @return the odds in implied probability format
     */
    private static double convertToImpliedProbability(String selection, String odds) {
        return OddsEngineFactory.createOddsEngine(selection).convertToImpliedProbability(odds);
    }

    /**
     * Requests a user for odds in the desired format
     *
     * @param selection the odds format selection from the user
     * @return the odds from the user
     */
    private static String requestOdds(String selection) {
        String input;
        do {
            System.out.println("\nEnter the odds in " + OddsEngineFactory.createOddsEngine(selection).getId() + " format:");
        }
        while (oddsInvalid(selection, (input = readInput())));
        return input;
    }

    /**
     * Checks if odds are invalid
     *
     * @param selection the odds format selection from the user
     * @param odds the odds input from the user
     * @return true if odds are invalid, false otherwise
     */
    private static boolean oddsInvalid(String selection, String odds) {
        return !OddsEngineFactory.createOddsEngine(selection).oddsValid(odds);
    }

    /**
     * Requests the user for an input odds format
     */
    private static String requestInputOddsFormat() {
        String selection;
        do {
            System.out.println("\nEnter desired input odds format (either 1, 2, 3, or 4):\n1. Implied Probability\n2. Decimal\n3. Fractional\n4. American");
        }
        while (!oddsFormatSelectionValid(selection = readInput()));
        return selection;
    }

    /**
     * Checks if a selection is valid
     *
     * @param selection the name of the file provided by the user
     * @return true if the filename is valid, false otherwise
     */
    private static boolean oddsFormatSelectionValid(String selection) {
        return selection.equals("1") ||
                selection.equals("2") ||
                selection.equals("3") ||
                selection.equals("4");
    }

    /**
     * Converts an implied probability to all odds formats
     *
     * @param impliedProbability the odds in implied probability format
     */
    private static void convertToAllFormats(double impliedProbability) {
        HashMap<String, String> convertedOdds = OddsEngineFactory.convertOdds(impliedProbability);
        System.out.println();
        convertedOdds.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    /**
     * Checks if the user wants to run the program again
     *
     * @return true if the user wants to run the program again, false otherwise
     */
    private static boolean runAgain() {
        String selection;
        do {
            System.out.println("\nConvert again? Enter either 'yes' or 'no'.");
        }
        while (!runAgainInputValid(selection = readInput()));
        return selection.equalsIgnoreCase("yes");
    }

    /**
     * Checks if a selection is valid
     *
     * @param userInput the user's input
     * @return true if the user's input is either 'yes' or 'no', false otherwise
     */
    private static boolean runAgainInputValid(String userInput) {
        return userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no");
    }

    /**
     * Reads input from the user
     *
     * @return the user's input
     */
    private static String readInput() {
        return new Scanner(System.in).nextLine();
    }
}
