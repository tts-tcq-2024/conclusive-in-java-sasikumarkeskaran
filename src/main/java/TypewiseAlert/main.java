package TypewiseAlert;

public class Main {
    public static void main(String[] args) {
        BatteryCharacter batteryChar = new BatteryCharacter(CoolingTypeLimits.CoolingType.PASSIVE_COOLING, "BrandX");
        AlertTarget alertTarget = new EmailAlert();
        CheckAndAlert checkAndAlert = new CheckAndAlert();
        
        checkAndAlert.checkAndAlert(alertTarget, batteryChar, 30.0);
    }
}
