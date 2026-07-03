package automaticBike;

public class AutomaticBike {
    private boolean isOn;
    private int gear = 1;
    private int speed;

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public int getGear() {
        return gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void accelerate() {
        if (gear == 1) {
            speed = speed + 1;
            if (speed > 20) gear = 2;
        } else if (gear == 2) {
            speed = speed + 2;
            if (speed > 30) gear = 3;
        } else if (gear == 3) {
            speed = speed + 3;
            if  (speed > 40) gear = 4;
        } else {
            speed = speed + 4;
        }
    }

    public void decelerate() {
        if (speed > 0) {
            if (gear == 1)
                speed = speed - 1;
            else if (gear == 2) {
                speed = speed - 2;
                if (speed < 21) gear = 1;
            } else if (gear == 3) {
                speed = speed - 3;
                if (speed < 31) gear = 2;
            } else if (gear == 4) {
                speed = speed - 4;
                if (speed < 41) gear = 3;
            }
        }
    }
}
