
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciNumberTest {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(3));
        Assertions.assertEquals(5, solution(5));
    }

    public int solution(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        int index = 2;
        while (index <= n) {
            arr[index] = (arr[index - 1] + arr[index - 2]) % 1234567;
            index++;
        }
        return arr[n];
    }
}
