package OddsEngines;

/**
 * Filename: OddsEngine.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class is used to require sub-class OddsEngines to implement methods
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public interface OddsEngine {
    /**
     * Converts odds into implied probability format
     *
     * @param odds the input odds
     * @return the odds in implied probability format
     */
    double convertToImpliedProbability(String odds);

    /**
     * Converts an implied probability into odds
     *
     * @param impliedProbability the probability to convert to american odds
     * @return the odds in the specific sub-class format
     */
    String convertToOdds(double impliedProbability);

    /**
     * Checks if the odds entered by a user are valid
     *
     * @param odds the odds entered by the user
     * @return true if the odds are valid, false otherwise
     */
    boolean oddsValid(String odds);

    /**
     * Returns the ID for this OddsEngine
     *
     * @return the String ID for this OddsEngine
     */
    String getId();
}