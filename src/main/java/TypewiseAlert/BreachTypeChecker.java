package TypewiseAlert;

public class BreachTypeChecker {
    
    public enum BreachType {
        NORMAL,
        TOO_LOW,
        TOO_HIGH
    }

    public BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
        if (value < lowerLimit) {
            return BreachType.TOO_LOW;
        }
        if (value > upperLimit) {
            return BreachType.TOO_HIGH;
        }
        return BreachType.NORMAL;
    }
}
