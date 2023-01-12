package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountPrimeNumberTest {

    @Test
    void test() {
        Assertions.assertEquals(4, solution(10));
        Assertions.assertEquals(3, solution(5));

    }

    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        arr[1] = 0;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i * 2; j < arr.length; j+=i) {
                arr[j] = 0;
            }
        }

        for(int num : arr) {
            if (num != 0) {
                answer ++;
            }
        }
        return answer;
    }
}
