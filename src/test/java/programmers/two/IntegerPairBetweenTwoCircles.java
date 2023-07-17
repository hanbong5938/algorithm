
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerPairBetweenTwoCircles {

    @Test
    void test() {
        Assertions.assertEquals(40, solution(2, 4));
        Assertions.assertEquals(20, solution(2, 3));
        Assertions.assertEquals(1008, solution(9, 20));
        Assertions.assertEquals(952, solution(10, 20));
        Assertions.assertEquals(6281440, solution(999999, 1000000));
    }

    public long solution(int r1, int r2) {
        long answer = 0;
        for (int x = 1; x <= r2; x++) {
            double y2 = (int) Math.floor(Math.sqrt((long) Math.pow(r2, 2) - (long) Math.pow(x, 2)));
            double y1 = Math.ceil(Math.sqrt((long) Math.pow(r1, 2) - (long) Math.pow(x, 2)));
            if (Double.isNaN(y1)) {
                y1 = 0;
            }
            answer += y2 - y1 + 1;
        }
        return answer * 4;
    }
}
