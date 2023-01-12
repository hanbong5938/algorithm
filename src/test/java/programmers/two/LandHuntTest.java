
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LandHuntTest {

    @Test
    void test() {
        Assertions.assertEquals(16, solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
        Assertions.assertEquals(107, solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 100}, {4, 3, 2, 1}}));
        Assertions.assertEquals(16, solution2(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
        Assertions.assertEquals(107, solution2(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 100}, {4, 3, 2, 1}}));
    }

    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0) {
                    dp[i][j] = land[i][j];
                } else {
                    int max = 0;
                    for (int k = 0; k < 4; k++) {
                        if (k == j) {
                            continue;
                        }
                        max = Math.max(max, dp[i - 1][k]);
                        dp[i][j] = max + land[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }
        return answer;
    }

    int solution2(int[][] land) {
        int answer = 0;
        for (int i = 0; i < land.length - 1; i++) {
            land[i + 1][0] += Math.max(land[i][1], Math.max(land[i][2], land[i][3]));
            land[i + 1][1] += Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
            land[i + 1][2] += Math.max(land[i][0], Math.max(land[i][1], land[i][3]));
            land[i + 1][3] += Math.max(land[i][0], Math.max(land[i][1], land[i][2]));
        }
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }
}
