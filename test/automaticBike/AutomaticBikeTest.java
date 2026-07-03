package automaticBike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutomaticBikeTest {

    private AutomaticBike automaticBike;

    @BeforeEach
    void setup() {
        automaticBike = new AutomaticBike();
    }

    @Test
    public void ITurnBikeOn_bikeIsOn() {
        assertFalse(automaticBike.isOn());

        automaticBike.turnOn();

        assertTrue(automaticBike.isOn());
    }

    @Test
    public void ITurnBikeOff_bikeIsOff() {
        automaticBike.turnOn();
        assertTrue(automaticBike.isOn());

        automaticBike.turnOff();

        assertFalse(automaticBike.isOn());
    }

    @Test
    public void gearIs1_IAccelerateBikeSpeedIncreasesBy1() {
        automaticBike.turnOn();
        assertTrue(automaticBike.isOn());
        assertEquals(1, automaticBike.getGear());

        assertEquals(0, automaticBike.getSpeed());
        automaticBike.accelerate();

        assertEquals(1, automaticBike.getSpeed());
    }

    @Test
    public void gearIs1_IAccelerateTillBikeSpeedIs21_gearIs2() {
        automaticBike.turnOn();
        assertTrue(automaticBike.isOn());
        assertEquals(1, automaticBike.getGear());

        assertEquals(0, automaticBike.getSpeed());
        incrementBikeSpeed(21);

        assertEquals(21, automaticBike.getSpeed());
        assertEquals(2, automaticBike.getGear());
    }

    @Test
    public void gearIs2_IAccelerateBikeSpeedIncreasesBy2() {
        automaticBike.turnOn();
        assertTrue(automaticBike.isOn());
        incrementBikeSpeed(21);

        assertEquals(2, automaticBike.getGear());
        int speed = automaticBike.getSpeed();

        automaticBike.accelerate();
        assertEquals(speed + 2, automaticBike.getSpeed());
    }

    @Test
    public void gearIs2_IAccelerateTillBikeSpeedIs31_gearIs3() {
        automaticBike.turnOn();
        assertTrue(automaticBike.isOn());
        incrementBikeSpeed(21);
        assertEquals(2, automaticBike.getGear());

        incrementBikeSpeed(5);

        assertEquals(31, automaticBike.getSpeed());
        assertEquals(3, automaticBike.getGear());
    }

    @Test
    public void gearIs3_IAccelerateBikeSpeedIncreasesBy3() {
        automaticBike.turnOn();
        assertTrue(automaticBike.isOn());
        incrementBikeSpeed(26);

        assertEquals(3, automaticBike.getGear());

        int speed = automaticBike.getSpeed();
        automaticBike.accelerate();

        assertEquals(speed + 3, automaticBike.getSpeed());
    }

    @Test
    public void gearIs3_IAccelerateTillBikeSpeedIsGreaterThan40_gearIs4() {
        automaticBike.turnOn();
        assertTrue(automaticBike.isOn());
        incrementBikeSpeed(26);

        assertEquals(3, automaticBike.getGear());
        incrementBikeSpeed(4);

        assertTrue(automaticBike.getSpeed() > 40);
        assertEquals(4, automaticBike.getGear());
    }

    @Test
    public void gearIs4_IAccelerateBikeSpeedIncreasesBy4() {
        automaticBike.turnOn();
        assertTrue(automaticBike.isOn());
        incrementBikeSpeed(30);

        assertEquals(4, automaticBike.getGear());

        int speed = automaticBike.getSpeed();
        automaticBike.accelerate();

        assertEquals(speed + 4, automaticBike.getSpeed());
    }

    @Test
    public void speedIsZeroIDecelerate_speedRemainsZero() {
        automaticBike.turnOn();
        assertEquals(0, automaticBike.getSpeed());

        automaticBike.decelerate();

        assertEquals(0, automaticBike.getSpeed());
    }

    @Test
    public void gearIs1_IDecelerate_speedReducesBy1() {
        incrementBikeSpeed(5);

        assertEquals(5, automaticBike.getSpeed());
        assertEquals(1, automaticBike.getGear());

        automaticBike.decelerate();

        assertEquals(4, automaticBike.getSpeed());
    }

    @Test
    public void gearIs2_IDecelerateBikeSpeedReducesBy2() {
        incrementBikeSpeed(24);
        assertEquals(2, automaticBike.getGear());

        int speed = automaticBike.getSpeed();

        automaticBike.decelerate();

        assertEquals(speed - 2, automaticBike.getSpeed());
    }

    @Test
    public void gearIs2_IDecelerateTillBikeSpeedIsLesserThan21_gearIs1() {
        incrementBikeSpeed(21);
        assertEquals(2, automaticBike.getGear());

        automaticBike.decelerate();

        assertTrue(automaticBike.getSpeed() < 21);
        assertEquals(1, automaticBike.getGear());
    }

    @Test
    public void gearIs3_IDecelerateBikeSpeedReducesBy3() {
        incrementBikeSpeed(28);
        assertEquals(3, automaticBike.getGear());

        int speed = automaticBike.getSpeed();

        automaticBike.decelerate();

        assertEquals(speed - 3, automaticBike.getSpeed());
    }

    @Test
    public void gearIs3_IDecelerateTillBikeSpeedIsLesserThan31_gearIs2() {
        incrementBikeSpeed(26);
        assertEquals(3, automaticBike.getGear());

        automaticBike.decelerate();

        assertTrue(automaticBike.getSpeed() < 31);
        assertEquals(2, automaticBike.getGear());
    }

    @Test
    public void gearIs4_IDecelerateBikeSpeedReducesBy4() {
        incrementBikeSpeed(34);
        assertEquals(4, automaticBike.getGear());

        int speed = automaticBike.getSpeed();

        automaticBike.decelerate();

        assertEquals(speed - 4, automaticBike.getSpeed());
    }

    @Test
    public void gearIs4_IDecelerateTillBikeSpeedIsLesserThan41_gearIs3() {
        incrementBikeSpeed(30);
        assertEquals(4, automaticBike.getGear());

        automaticBike.decelerate();

        assertTrue(automaticBike.getSpeed() < 41);
        assertEquals(3, automaticBike.getGear());
    }

    public void incrementBikeSpeed(int speed) {
        for (int increment = 0; increment < speed; increment++) {
            automaticBike.accelerate();
        }
    }
}
