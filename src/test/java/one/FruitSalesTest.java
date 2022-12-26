package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

class FruitSalesTest {

    @Test
    void test() {
        Assertions.assertEquals(8, solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        Assertions.assertEquals(33, solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        int index = 0;
        int length = score.length;
        while (length - (m * (index + 1)) >= 0) {
            answer += score[length - (m * (index + 1))] * m;
            index++;
        }


        return answer;
    }
}
