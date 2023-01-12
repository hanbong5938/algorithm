
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinNumAndMaxNumTest {

    @Test
    void test() {
        Assertions.assertEquals("1 4", solution("1 2 3 4"));
        Assertions.assertEquals("-4 -1", solution("-1 -2 -3 -4"));
        Assertions.assertEquals("-1 -1", solution("-1 -1"));
    }

    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String str : arr) {
            int temp = Integer.parseInt(str);
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        return min + " " + max;
    }
}
