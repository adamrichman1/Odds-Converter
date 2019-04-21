package OddsEngines;

/**
 * Filename: AmericanOddsEngine.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class is used to manage American Odds conversions
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public class AmericanOddsEngine extends OddsEngine {

    private static AmericanOddsEngine oddsEngine;

    /**
     * Singleton design pattern
     *
     * @return the sole instance of AmericanOddsEngine
     */
    static AmericanOddsEngine getInstance() {
        if (oddsEngine == null) {
            oddsEngine = new AmericanOddsEngine();
        }
        return oddsEngine;
    }

    /**
     * Converts American odds into implied probability format
     *
     * @param odds the American odds to convert to an implied probability
     * @return the odds in implied probability format
     */
    @Override
    public double convertToImpliedProbability(String odds) {
        int o = Integer.parseInt(odds.substring(1));
        if (odds.substring(0, 1).equals("+")) return 100.0 / (o + 100.0);
        else return o / (o + 100.0);
    }

    /**
     * Used to convert a probability to american odds
     *
     * @param impliedProbability the probability to convert to american odds
     * @return the equivalent odds string in american odds format
     */
    @Override
    public String convertToOdds(double impliedProbability) {
        if (impliedProbability >= 0.5) {
            return Long.toString(Math.round((-100.0 * impliedProbability) / (1.0 - impliedProbability)));
        }
        return "+" + Math.round(100.0 * (1.0 - impliedProbability) / impliedProbability);
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
            return odds.contains("+") || odds.contains("-") && Integer.parseInt(odds.substring(1)) >= 100;
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
        return "American";
    }
}
