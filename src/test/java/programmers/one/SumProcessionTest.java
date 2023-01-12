package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumProcessionTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[][]{{4, 6}, {7, 9}}, this.solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}}));
        Assertions.assertArrayEquals(new int[][]{{4, 6}}, this.solution(new int[][]{{1, 2}}, new int[][]{{3, 4}}));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
