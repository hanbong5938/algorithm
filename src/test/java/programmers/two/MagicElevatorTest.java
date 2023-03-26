
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MagicElevatorTest {

    @Test
    void test() {
        Assertions.assertEquals(6, solution(16));
        Assertions.assertEquals(16, solution(2554));
        Assertions.assertEquals(7, solution(116));
        Assertions.assertEquals(6, solution(95));
    }

    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int current = storey % 10;
            if (current > 5 || (current == 5 && (storey / 10) % 10 >= 5)) {
                int push = 10 - current;
                storey += push;
                answer += push;
            } else {
                answer += current;

            }
            storey /= 10;
        }
        return answer;
    }
}
