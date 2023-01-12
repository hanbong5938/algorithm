package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MakePrimeNumberTest {

    @Test
    void test() {
        Assertions.assertEquals(1, solution(new int[]{1, 2, 3, 4}));
        Assertions.assertEquals(4, solution(new int[]{1, 2, 7, 6, 4}));

    }

    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (this.isMinority(nums[i], nums[j], nums[k])) {
                        answer++;
                    }
                }
            }

        }
        return answer;
    }

    private boolean isMinority(int a, int b, int c) {
        int sum = a + b + c;
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }

}
