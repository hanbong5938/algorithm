package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BudgetTest {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(new int[]{1, 3, 2, 5, 4}, 9));
        Assertions.assertEquals(4, solution(new int[]{2, 2, 3, 3}, 10));

    }

    public int solution(int[] d, int budget) {
        int answer = 0;
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length - 1; j++) {
                if (d[i] < d[j]) {
                    int temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }

        int used = 0;
        for (int j : d) {
            used += j;
            if (used > budget) {
                break;
            }
            answer++;
        }
        return answer;
    }

}
