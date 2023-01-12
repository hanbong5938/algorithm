
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongJumpTest {

    @Test
    void test() {
        Assertions.assertEquals(5, solution(4));
        Assertions.assertEquals(3, solution(3));
        Assertions.assertEquals(8, solution(5));
        Assertions.assertEquals(13, solution(6));
        Assertions.assertEquals(21, solution(7));
        Assertions.assertEquals(34, solution(8));
        Assertions.assertEquals(55, solution(9));
        Assertions.assertEquals(89, solution(10));
        Assertions.assertEquals(144, solution(11));
        Assertions.assertEquals(233, solution(12));
    }

    public long solution(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        return dp[n];
    }
}
