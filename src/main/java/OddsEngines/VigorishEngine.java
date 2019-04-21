package OddsEngines;

/**
 * Filename: VigorishEngine.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class is used to require sub-classes to implement a method to find the Vigorish of a probability
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
interface VigorishEngine {
    /**
     * Finds the vigorish applied to the odds
     *
     * @param probability the implied probability to get vigorish info from
     * @return the vigorish applied to the odds
     */
    double getVigorishInfo(double probability);
}
