package TypewiseAlert;

public class CheckAndAlert {

    private final TemperatureClassifier temperatureClassifier = new TemperatureClassifier();

    public void checkAndAlert(
            AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        BreachTypeChecker.BreachType breachType = temperatureClassifier.classifyTemperatureBreach(
                batteryChar.coolingType, temperatureInC);
        alertTarget.sendAlert(breachType);
    }
}
