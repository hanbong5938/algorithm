package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumSquareTest {


    @Test
    void test() {
        Assertions.assertEquals(4000, solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        Assertions.assertEquals(120, solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        Assertions.assertEquals(133, solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }

    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        for (int[] size : sizes) {
            int tempX = Math.max(size[0], size[1]);
            int tempY = Math.min(size[0], size[1]);
            x = Math.max(x, tempX);
            y = Math.max(y, tempY);
        }

        return x * y;
    }
}
