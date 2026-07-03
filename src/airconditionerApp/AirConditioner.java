package airconditionerApp;

public class AirConditioner {

    private boolean isOn;
    private int temperature = 24;

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public int getTemperature() {
        return temperature;
    }

    public void increaseTemperature() {
        boolean temperatureLesserThanThirty = temperature < 30;
        if (temperatureLesserThanThirty) temperature = temperature + 1;
    }

    public void reduceTemperature() {
        boolean temperatureGreaterThanSixteen = temperature > 16;
        if (temperatureGreaterThanSixteen) temperature = temperature - 1;
    }
}
