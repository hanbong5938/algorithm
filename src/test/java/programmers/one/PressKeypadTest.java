package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class PressKeypadTest {

    @Test
    void test() {
        Assertions.assertEquals("LRLLLRLLRRL", solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        Assertions.assertEquals("LRLLRRLLLRR", solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        Assertions.assertEquals("LLRLLRLLRL", solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }


    int[][] keyPad = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -2}
    };

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] left = findPosition(-1); // *
        int[] right = findPosition(-2); // #
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                left = findPosition(num);
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                right = findPosition(num);
            } else {
                int[] position = findPosition(num);
                int leftDistance = Math.abs(left[0] - position[0]) + Math.abs(left[1] - position[1]);
                int rightDistance = Math.abs(right[0] - position[0]) + Math.abs(right[1] - position[1]);
                if (leftDistance < rightDistance) {
                    answer.append("L");
                    left = position;
                } else if (leftDistance > rightDistance) {
                    answer.append("R");
                    right = position;
                } else {
                    if (Objects.equals(hand, "right")) {
                        answer.append("R");
                        right = position;
                    } else {
                        answer.append("L");
                        left = position;
                    }
                }


            }
        }
        return answer.toString();
    }

    private int[] findPosition(int num) {
        for (int i = 0; i < keyPad.length; i++) {
            for (int j = 0; j < keyPad[i].length; j++) {
                if (keyPad[i][j] == num) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
