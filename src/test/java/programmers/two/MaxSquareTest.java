
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxSquareTest {

    @Test
    void test() {
        Assertions.assertEquals(9, solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        Assertions.assertEquals(4, solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }

    public int solution(int[][] board) {
        int answer = 0;
        int[][] dp = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]) + 1;
                    if (dp[i + 1][j + 1] > answer) {
                        answer = dp[i + 1][j + 1];
                    }
                }
            }
        }
        return answer * answer;
    }
}
