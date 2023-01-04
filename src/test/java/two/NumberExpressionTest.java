
package two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberExpressionTest {

    @Test
    void test() {
        Assertions.assertEquals(4, solution(15));
        Assertions.assertEquals(2, solution(3));
        Assertions.assertEquals(4, solution2(15));
        Assertions.assertEquals(2, solution2(3));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int num = 0;
            for (int j = i; j <= n; j++) {
                num += j;
                if (num == n) {
                    answer++;
                    break;
                } else if (num > n) {
                    break;
                }
            }

        }
        return answer;
    }

    public int solution2(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % 2 == 1 && n % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}
