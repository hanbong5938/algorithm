package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class ClawMachineGameTest {

    @Test
    void test() {
        Assertions.assertEquals(4,
                solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                        new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int[] ints : board) {
                int doll = ints[move - 1];
                if (doll == 0) {
                    continue;
                } else if (!stack.empty() && doll == stack.peek()) {
                    stack.pop();
                    answer += 2;
                } else if (ints[move - 1] != 0) {
                    stack.push(doll);
                }
                ints[move - 1] = 0;
                break;
            }
        }
        return answer;
    }

}
