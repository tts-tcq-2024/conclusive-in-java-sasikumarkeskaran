package TypewiseAlert;

public class TemperatureClassifier {

    private final BreachTypeChecker breachTypeChecker = new BreachTypeChecker();

    public BreachTypeChecker.BreachType classifyTemperatureBreach(
            CoolingTypeLimits.CoolingType coolingType, double temperatureInC) {
        return breachTypeChecker.inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }
}
