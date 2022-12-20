package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumCommonDivisorAndMinimumCommonMultipleTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{3, 12}, this.solution(3, 12));
        Assertions.assertArrayEquals(new int[]{1, 10}, this.solution(2, 5));
    }

    private int getMaximumCommonDivisor(int num1, int num2) {
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        return min == 0 ? max : getMaximumCommonDivisor(min, max % min);
    }

    private int getMinimumCommonMultiple(int num1, int num2) {
        return num1 * num2 / getMaximumCommonDivisor(num1, num2);
    }

    public int[] solution(int n, int m) {
        return new int[]{getMaximumCommonDivisor(n, m), getMinimumCommonMultiple(n, m)};
    }
}
