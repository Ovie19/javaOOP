package chapterEight;

import org.junit.jupiter.api.Test;

public class TimeTest {

    @Test
    public void nonsenseTest() {
        Time time;
        try{
            time = new Time(37, 43, 56);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            time = new Time(0, 0, 0);
        }
    }
}
