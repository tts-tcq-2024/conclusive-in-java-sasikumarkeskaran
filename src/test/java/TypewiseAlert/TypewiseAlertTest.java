package TypewiseAlert;

import static org.junit.Assert.*;
import org.junit.Test;
import TypewiseAlert.BreachTypeChecker.BreachType;
import TypewiseAlert.BreachTypeChecker.CoolingType;
import TypewiseAlert.CheckAndAlert.AlertTarget;
import TypewiseAlert.TypewiseAlert.BatteryCharacter;

public class TypewiseAlertTest {

    @Test
    public void testInferBreachTooLow() {
        BreachType breachType = BreachTypeChecker.inferBreach(10, 20, 30);
        assertEquals(BreachType.TOO_LOW, breachType);
    }

    @Test
    public void testInferBreachTooHigh() {
        BreachType breachType = BreachTypeChecker.inferBreach(40, 20, 30);
        assertEquals(BreachType.TOO_HIGH, breachType);
    }

    @Test
    public void testInferBreachNormal() {
        BreachType breachType = BreachTypeChecker.inferBreach(25, 20, 30);
        assertEquals(BreachType.NORMAL, breachType);
    }

    @Test
    public void testTempBreachForPassiveCooling() {
        BreachType breachType = BreachTypeChecker.classifyTemperatureBreach(CoolingType.PASSIVE_COOLING, 36);
        assertEquals(BreachType.TOO_HIGH, breachType);
    }

    @Test
    public void testTempBreachForHiActiveCooling() {
        BreachType breachType = BreachTypeChecker.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING, 46);
        assertEquals(BreachType.TOO_HIGH, breachType);
    }

    @Test
    public void testTempBreachForMedActiveCooling() {
        BreachType breachType = BreachTypeChecker.classifyTemperatureBreach(CoolingType.MED_ACTIVE_COOLING, 41);
        assertEquals(BreachType.TOO_HIGH, breachType);
    }

    @Test
    public void testCheckAndAlertToController() {
        BatteryCharacter batteryChar = new TypewiseAlert.BatteryCharacter(CoolingType.PASSIVE_COOLING, "BrandX");
        TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER, batteryChar, 36);
    }

    @Test
    public void testCheckAndAlertToEmail() {
        BatteryCharacter batteryChar = new TypewiseAlert.BatteryCharacter(CoolingType.PASSIVE_COOLING, "BrandX");
        TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL, batteryChar, 36);
    }
}
