package Core;

import OddsEngines.OddsEngineFactory;

/**
 * Filename: InputVerifier.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains methods that check the validity of user input
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
class InputVerifier {
    /**
     * Checks if a selection is valid
     *
     * @param selection the name of the file provided by the user
     * @return true if the filename is valid, false otherwise
     */
    boolean oddsFormatSelectionValid(String selection) {
        return selection.equals("1") ||
                selection.equals("2") ||
                selection.equals("3") ||
                selection.equals("4");
    }

    /**
     * Checks if a selection is valid
     *
     * @param userInput the user's input
     * @return true if the user's input is either 'yes' or 'no', false otherwise
     */
    boolean runAgainInputValid(String userInput) {
        return userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no");
    }

    /**
     * Checks if odds are invalid
     *
     * @param selection the odds format selection from the user
     * @param odds the odds input from the user
     * @return true if odds are invalid, false otherwise
     */
    boolean oddsInvalid(String selection, String odds) {
        return !OddsEngineFactory.createOddsEngine(selection).oddsValid(odds);
    }
}
