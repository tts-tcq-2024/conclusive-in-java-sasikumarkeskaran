package TypewiseAlert;

public class BreachTypeChecker {

    public static class BreachType {
        public static final BreachType NORMAL = new BreachType("NORMAL");
        public static final BreachType TOO_LOW = new BreachType("TOO_LOW");
        public static final BreachType TOO_HIGH = new BreachType("TOO_HIGH");

        private String breachLevel;

        private BreachType(String breachLevel) {
            this.breachLevel = breachLevel;
        }

        public String getBreachLevel() {
            return breachLevel;
        }

        @Override
        public String toString() {
            return breachLevel;
        }
    }

    public static class CoolingType {
        public static final CoolingType PASSIVE_COOLING = new CoolingType(0, 35);
        public static final CoolingType HI_ACTIVE_COOLING = new CoolingType(0, 45);
        public static final CoolingType MED_ACTIVE_COOLING = new CoolingType(0, 40);

        private int lowerLimit;
        private int upperLimit;

        private CoolingType(int lowerLimit, int upperLimit) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        public int getLowerLimit() {
            return lowerLimit;
        }

        public int getUpperLimit() {
            return upperLimit;
        }
    }

    public static BreachType inferBreach(double value, int lowerLimit, int upperLimit) {
        if (value < lowerLimit) {
            return BreachType.TOO_LOW;
        }
        if (value > upperLimit) {
            return BreachType.TOO_HIGH;
        }
        return BreachType.NORMAL;
    }

    public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
        return inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }
}
