
package two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

class MinNumTest {

    @Test
    void test() {
        Assertions.assertEquals(29, solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        Assertions.assertEquals(10, solution(new int[]{1, 2}, new int[]{3, 4}));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];
        }

        return answer;
    }
}
