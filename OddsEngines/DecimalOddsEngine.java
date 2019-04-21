package OddsEngines;

/**
 * Filename: DecimalOddsEngine.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class is used to manage Decimal Odds conversions
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public class DecimalOddsEngine implements OddsEngine {

    private static DecimalOddsEngine oddsEngine;

    /**
     * Singleton design pattern
     *
     * @return the sole instance of DecimalOddsEngine
     */
    public static DecimalOddsEngine getInstance() {
        if (oddsEngine == null) {
            oddsEngine = new DecimalOddsEngine();
        }
        return oddsEngine;
    }

    /**
     * Converts odds into implied probability format
     *
     * @param odds the input odds
     * @return the odds in implied probability format
     */
    @Override
    public double convertToImpliedProbability(String odds) {
        return 1 / Double.parseDouble(odds);
    }

    /**
     * Converts an implied probability into odds
     *
     * @param impliedProbability the probability to convert to american odds
     * @return the odds in the specific sub-class format
     */
    @Override
    public String convertToOdds(double impliedProbability) {
        return Double.toString(Math.round(100.0*(1.0 / impliedProbability))/100.0);
    }

    /**
     * Checks if the odds entered by a user are valid
     *
     * @param odds the odds entered by the user
     * @return true if the odds are valid, false otherwise
     */
    @Override
    public boolean oddsValid(String odds) {
        try {
            return Double.parseDouble(odds) >= 1.0;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    /**
     * Returns the ID for this OddsEngine
     *
     * @return the String ID for this OddsEngine
     */
    @Override
    public String getId() {
        return "Decimal";
    }
}
