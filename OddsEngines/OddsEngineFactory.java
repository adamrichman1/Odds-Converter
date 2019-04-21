package OddsEngines;

import java.util.HashMap;

/**
 * Filename: OddsEngineFactory.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class follows the Factory design pattern by hiding object implementation details
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public class OddsEngineFactory {
    /**
     * Uses Factory design pattern to creates OddsEngine objects
     *
     * @param selection the odds format selection from a user
     * @return the OddsEngine corresponding to the odds format selection from a user
     */
    public static OddsEngine createOddsEngine(String selection) {
        switch(Integer.parseInt(selection)) {
            case(1):
                return ImpliedProbabilityOddsEngine.getInstance();
            case(2):
                return DecimalOddsEngine.getInstance();
            case(3):
                return FractionalOddsEngine.getInstance();
            case(4):
                return AmericanOddsEngine.getInstance();
            default:
                throw new IllegalArgumentException(">>> ERROR: Invalid odds selection provided by the user");
        }
    }

    /**
     * Converts odds to all other formats
     *
     * @param probability the odds in implied probability format
     * @return a HashMap mapping all supported odds formats to odds
     */
    public static HashMap<String, String> convertOdds(double probability) {
        OddsEngine e;
        HashMap<String, String> converted = new HashMap<>();
        converted.put("Implied Probability", Double.toString(probability));
        converted.put((e = createOddsEngine("2")).getId(), e.convertToOdds(probability));
        converted.put((e = createOddsEngine("3")).getId(), e.convertToOdds(probability));
        converted.put((e = createOddsEngine("4")).getId(), e.convertToOdds(probability));
        return converted;
    }
}
