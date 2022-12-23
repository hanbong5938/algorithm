package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeBroTest {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(new int[]{-2, 3, 0, 2, -5}));
        Assertions.assertEquals(5, solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        Assertions.assertEquals(0, solution(new int[]{-1, 1, -1, 1}));
    }

    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
