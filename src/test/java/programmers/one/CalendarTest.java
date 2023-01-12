package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalendarTest {

    @Test
    void solution() {
        int a = 5;
        int b = 24;

        final int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final String[] weeks = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int answer = 0;
        for (int i = 0; i < a; i++) {
            answer += days[i];
        }

        final int index = ((answer + b) % weeks.length) - 1;

        Assertions.assertSame("TUE", weeks[index == -1 ? 6 : index]);
    }
}
