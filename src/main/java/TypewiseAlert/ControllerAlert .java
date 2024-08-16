package TypewiseAlert;

public interface AlertTarget {
    void sendAlert(BreachTypeChecker.BreachType breachType);
}

public class ControllerAlert implements AlertTarget {
    @Override
    public void sendAlert(BreachTypeChecker.BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%x : %s\n", header, breachType);
    }
}

public class EmailAlert implements AlertTarget {
    private static final String RECEIVER_EMAIL = "a.b@c.com";

    @Override
    public void sendAlert(BreachTypeChecker.BreachType breachType) {
        switch (breachType) {
            case TOO_LOW:
                System.out.printf("To: %s\n", RECEIVER_EMAIL);
                System.out.println("Hi, the temperature is too low\n");
                break;
            case TOO_HIGH:
                System.out.printf("To: %s\n", RECEIVER_EMAIL);
                System.out.println("Hi, the temperature is too high\n");
                break;
            default:
                break;
        }
    }
}
