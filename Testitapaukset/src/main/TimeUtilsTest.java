package main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeUtilsTest {
    TimeUtils tu = new TimeUtils();

    @ParameterizedTest(name = "{0} sekuntia on yhtä kuin {1}")
    @CsvSource({
            "-60, Invalid argument",
            "0, 0:00:00",
            "60, 0:01:00",
            "59, 0:00:59",
            "3600, 1:00:00",
            "3599, 0:59:59",
            "1000000, 277:46:40",
            "61, 0:01:01",
            "3601, 1:00:01",
            "3661, 1:01:01"
    })
    public void testSecToTime(int sec, String time) {
        if(sec >= 0) {
            String msg = sec + " väärin!";
            assertEquals(time, TimeUtils.secToTime(sec), msg);
        } else {
            assertThrows(IllegalArgumentException.class, () -> {
                TimeUtils.secToTime(sec);
            });
        }
    }
}
