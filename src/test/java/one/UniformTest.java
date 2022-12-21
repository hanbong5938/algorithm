package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniformTest {

    @Test
    void test() {
        Assertions.assertEquals(5, solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        Assertions.assertEquals(4, solution(5, new int[]{2, 4}, new int[]{3}));
        Assertions.assertEquals(2, solution(3, new int[]{3}, new int[]{1}));

    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = 1;
        }

        for (int lo : lost) {
            arr[lo]--;
        }

        for (int re : reserve) {
            arr[re]++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (i > 1 && arr[i - 1] == 2) {
                    arr[i - 1]--;
                    arr[i]++;
                } else if (i + 1 < arr.length && arr[i + 1] == 2) {
                    arr[i + 1]--;
                    arr[i]++;
                }
            }
            if (arr[i] > 0) {
                answer++;
            }
        }

        return answer;
    }

}
