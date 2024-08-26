package TypewiseAlert;
import TypewiseAlert.BreachTypeChecker.BreachType;
public class CheckAndAlert  {
    public static class AlertTarget {
        public static final AlertTarget TO_CONTROLLER = new AlertTarget("TO_CONTROLLER");
        public static final AlertTarget TO_EMAIL = new AlertTarget("TO_EMAIL");

        private String target;

        private AlertTarget(String target) {
            this.target = target;
        }

        public String getTarget() {
            return target;
        }

        @Override
        public String toString() {
            return target;
        }
    }

    public static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%x : %s\n", header, breachType);
    }

    public static void sendToEmail(BreachType breachType) {
        String recepient = "a.b@c.com";
        System.out.printf("To: %s\n", recepient);
        if (breachType == BreachType.TOO_LOW) {
            System.out.println("Hi, the temperature is too low\n");
        } else if (breachType == BreachType.TOO_HIGH) {
            System.out.println("Hi, the temperature is too high\n");
        }
    }
}
