package OddsEngines;

/**
 * Filename: FractionalOddsEngine.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class is used to manage Fractional Odds conversions
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public class FractionalOddsEngine extends OddsEngine {

    private static FractionalOddsEngine oddsEngine;

    /**
     * Singleton design pattern
     *
     * @return the sole instance of FractionalOddsEngine
     */
    static FractionalOddsEngine getInstance() {
        if (oddsEngine == null) {
            oddsEngine = new FractionalOddsEngine();
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
        String[] parts = odds.split("/");
        int denominator = Integer.parseInt(parts[1]);
        return 1.0*denominator / (denominator + Integer.parseInt(parts[0]));
    }

    /**
     * Converts an implied probability into odds
     *
     * @param impliedProbability the probability to convert to american odds
     * @return the odds in the specific sub-class format
     */
    @Override
    public String convertToOdds(double impliedProbability) {
        long o = Math.round(100*(1.0/impliedProbability - 1.0));
        long divisor = gcd(o, 100);
        return o / divisor + "/" + 100 / divisor;
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
            return odds.contains("/") && !odds.contains(".") && Double.parseDouble(odds.split("/")[0]) >= 1 && Double.parseDouble(odds.split("/")[1]) >= 1;
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
        return "Fractional";
    }

    /**
     *
     * @param a the first number
     * @param b the second number
     * @return the greatest common divisor of a and b
     */
    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
