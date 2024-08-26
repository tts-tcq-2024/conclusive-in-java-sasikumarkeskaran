package TypewiseAlert;


import TypewiseAlert.BreachTypeChecker.BreachType;
import TypewiseAlert.BreachTypeChecker.CoolingType;
import TypewiseAlert.CheckAndAlert.AlertTarget;

public class TypewiseAlert 
{
   public static class BatteryCharacter {
        private CoolingType coolingType;
        private String brand;

        public BatteryCharacter(CoolingType coolingType, String brand) {
            this.coolingType = coolingType;
            this.brand = brand;
        }

        public CoolingType getCoolingType() {
            return coolingType;
        }

        public String getBrand() {
            return brand;
        }
    }

    public static void checkAndAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        BreachType breachType = BreachTypeChecker .classifyTemperatureBreach(batteryChar.getCoolingType(), temperatureInC);

        if (alertTarget == AlertTarget.TO_CONTROLLER) {
            CheckAndAlert.sendToController(breachType);
        } else if (alertTarget == AlertTarget.TO_EMAIL) {
            CheckAndAlert.sendToEmail(breachType);
        }
    }
}
