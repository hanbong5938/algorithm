package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NotEnoughMoneyTest {

    @Test
    void test() {
        Assertions.assertEquals(10, solution(3, 20, 4));
    }

    public long solution(int price, int money, int count) {
        long answer = 0;
        for (int i = 1; i <= count; i++) {
            answer += (long) price * (i);
        }

        return answer > money ? answer - money : 0;
    }
}
