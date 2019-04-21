package OddsEngines;

public class ImpliedProbabilityOddsEngine implements OddsEngine {

    private static ImpliedProbabilityOddsEngine oddsEngine;

    /**
     * Singleton design pattern
     *
     * @return the sole instance of ImpliedProbabilityOddsEngine
     */
    static ImpliedProbabilityOddsEngine getInstance() {
        if (oddsEngine == null) {
            oddsEngine = new ImpliedProbabilityOddsEngine();
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
        return Double.parseDouble(odds);
    }

    /**
     * Converts an implied probability into odds
     *
     * @param impliedProbability the probability to convert to american odds
     * @return the odds in the specific sub-class format
     */
    @Override
    public String convertToOdds(double impliedProbability) {
        return Double.toString(impliedProbability);
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
            return Double.parseDouble(odds) <= 1.0 && Double.parseDouble(odds) >= 0.0;
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
        return "Implied Probability";
    }
}
