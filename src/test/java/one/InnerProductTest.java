package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

class InnerProductTest {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}));
        Assertions.assertEquals(-2, solution(new int[]{-1, 0, 1}, new int[]{1, 0, -1}));
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
