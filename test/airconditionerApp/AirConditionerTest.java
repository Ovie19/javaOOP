package airconditionerApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {

    private AirConditioner airConditioner;

    @BeforeEach
    void setUp() {
        airConditioner = new AirConditioner();
    }

    @Test
    public void ITurnAirConditionerOn_airConditionerIsOn() {
        assertFalse(airConditioner.isOn());

        airConditioner.turnOn();

        assertTrue(airConditioner.isOn());
    }

    @Test
    public void ITurnAirConditionerOff_airConditionerIsOff() {
        airConditioner.turnOn();
        assertTrue(airConditioner.isOn());

        airConditioner.turnOff();

        assertFalse(airConditioner.isOn());
    }

    @Test
    public void I_IncreaseTemperature_airConditionerTemperatureIncreasesByOne() {
        airConditioner.turnOn();
        assertTrue(airConditioner.isOn());

        int airConditionerTemperature = airConditioner.getTemperature();
        airConditioner.increaseTemperature();

        int newAirConditionerTemperature = airConditioner.getTemperature();

        assertNotEquals(airConditionerTemperature, newAirConditionerTemperature);
        assertEquals(airConditionerTemperature + 1, newAirConditionerTemperature);
    }

    @Test
    public void I_DecreaseTemperature_airConditionerTemperatureDecreasesByOne() {
        airConditioner.turnOn();
        assertTrue(airConditioner.isOn());
        airConditioner.increaseTemperature();

        int airConditionerTemperature = airConditioner.getTemperature();

        airConditioner.reduceTemperature();
        int newAirConditionerTemperature = airConditioner.getTemperature();

        assertNotEquals(airConditionerTemperature, newAirConditionerTemperature);
        assertEquals(airConditionerTemperature - 1, newAirConditionerTemperature);
    }

    @Test
    public void I_IncreaseTemperatureBeyond30_airConditionerTemperatureRemains30() {
        airConditioner.turnOn();
        assertTrue(airConditioner.isOn());

        for (int increment = 0; increment < 31; increment++) {
            airConditioner.increaseTemperature();
        }

        assertEquals(30, airConditioner.getTemperature());
    }

    @Test
    public void I_DecreaseTemperatureBelow16_airConditionerTemperatureRemains16() {
        airConditioner.turnOn();
        assertTrue(airConditioner.isOn());

        for (int increment = 0; increment < 31; increment++) {
            airConditioner.increaseTemperature();
        }
        assertEquals(30, airConditioner.getTemperature());

        for (int decrement = 0; decrement < 31; decrement++) {
            airConditioner.reduceTemperature();
        }

        assertEquals(16, airConditioner.getTemperature());
    }
}
