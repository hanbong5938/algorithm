
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class OverPaintingTest {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(8, 4, new int[]{2, 3, 6}));
        Assertions.assertEquals(1, solution(5, 4, new int[]{1, 3}));
        Assertions.assertEquals(4, solution(4, 1, new int[]{1, 2, 3, 4}));
        Assertions.assertEquals(3, solution(8, 2, new int[]{2, 6}));
    }

    public int solution(int n, int m, int[] section) {
        int start = section[0];
        int count = 1;
        for (int i = 1; i < section.length; i++) {
            if (start + m - 1 < section[i]) {
                count++;
                start = section[i];
            }
        }
        return count;
    }
}
