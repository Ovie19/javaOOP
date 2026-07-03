package chapterEight;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        validate(hour, minute, second);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    private void validate(int hour, int minute, int second) {
        validateHour(hour);
        validateMinute(minute);
        validateSecond(second);
    }

    private void validateSecond(int second) {
        boolean isInvalidSecond = second < 0 || second > 59;
        if (isInvalidSecond) throw new IllegalArgumentException("Seconds is invalid");
    }

    private static void validateMinute(int minute) {
        boolean isInvalidMinute = minute < 0 || minute > 59;
        if (isInvalidMinute) throw new IllegalArgumentException("Minutes is invalid");
    }

    private void validateHour(int hour) {
        boolean isInvalidHour = hour < 0 || hour > 23;
        if (isInvalidHour) throw new IllegalArgumentException("Hour is invalid");
    }

    public void setMinute(int minute) {
        validateMinute(minute);
        this.minute = minute;
    }

    public void setHour(int hour) {
        validateHour(hour);
        this.hour = hour;
    }

    public void setSecond(int second) {
        validateSecond(second);
        this.second = second;
    }
}
