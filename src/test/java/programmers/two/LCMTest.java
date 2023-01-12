
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class LCMTest {

    @Test
    void test() {
        Assertions.assertEquals(168, solution(new int[]{2, 6, 8, 14}));
        Assertions.assertEquals(6, solution(new int[]{1, 2, 3}));
        Assertions.assertEquals(144, solution(new int[]{3, 4, 9, 16}));
    }

    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd;
        }
        return answer;
    }

    private int gcd(int gcd, int i) {
        if (i == 0) {
            return gcd;
        }
        return gcd(i, gcd % i);
    }

}
