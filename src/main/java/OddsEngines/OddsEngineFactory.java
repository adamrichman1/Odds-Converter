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

    private static ImpliedProbabilityOddsEngine probabilityOddsEngine = ImpliedProbabilityOddsEngine.getInstance();
    private static DecimalOddsEngine decimalOddsEngine = DecimalOddsEngine.getInstance();
    private static FractionalOddsEngine fractionalOddsEngine = FractionalOddsEngine.getInstance();
    private static AmericanOddsEngine americanOddsEngine = AmericanOddsEngine.getInstance();

    /**
     * Uses Factory design pattern to creates OddsEngine objects
     *
     * @param selection the odds format selection from a user
     * @return the OddsEngine corresponding to the odds format selection from a user
     */
    public static OddsEngine createOddsEngine(String selection) {
        switch(Integer.parseInt(selection)) {
            case(1):
                return probabilityOddsEngine;
            case(2):
                return decimalOddsEngine;
            case(3):
                return fractionalOddsEngine;
            case(4):
                return americanOddsEngine;
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
        HashMap<String, String> converted = new HashMap<>();
        converted.put(probabilityOddsEngine.getId(), probabilityOddsEngine.convertToOdds(probability));
        converted.put(decimalOddsEngine.getId(), decimalOddsEngine.convertToOdds(probability));
        converted.put(fractionalOddsEngine.getId(), fractionalOddsEngine.convertToOdds(probability));
        converted.put(americanOddsEngine.getId(), americanOddsEngine.convertToOdds(probability));
        converted.put("Vigorish", Double.toString(probabilityOddsEngine.getVigorishInfo(probability)));
        return converted;
    }
}
