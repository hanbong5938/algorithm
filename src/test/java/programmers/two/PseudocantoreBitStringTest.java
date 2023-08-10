package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PseudocantoreBitStringTest {

    @Test
    void test() {
        Assertions.assertEquals(8, solution(4, 4, 17));
        Assertions.assertEquals(1, solution(2, 10, 15));
    }

    public int solution(int n, long l, long r) {
        int answer = 0;

        for (l--; l < r; l++) {
            if (isOne(l)) {
                answer++;
            }
        }

        return answer;
    }

    boolean isOne(long l) {
        if (l < 5 && l != 2) {
            return true;
        }
        if ((l - 2) % 5 == 0) {
            return false;
        }

        return isOne(l / 5);
    }
}
