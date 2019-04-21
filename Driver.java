import OddsEngines.OddsEngineFactory;

import java.util.HashMap;

/**
 * Filename: Driver.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class drives the program
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
public class Driver {

    private static IOController ioController;

    /**
     * Drives the main program
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Save IOController via static access modifier
        setIoController(new IOController(new InputVerifier()));

        // Run program
        do {
            String selection = ioController.requestInputOddsFormat();
            convertToAllFormats(convertToImpliedProbability(selection, ioController.requestOdds(selection)));
        } while (ioController.runAgain());
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
     * Static access modifier for IOController
     *
     * @param ioController the new IO Controller
     */
    private static void setIoController(IOController ioController) {
        Driver.ioController = ioController;
    }
}
