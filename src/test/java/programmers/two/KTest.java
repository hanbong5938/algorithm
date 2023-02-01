
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KTest {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(437674, 3));
        Assertions.assertEquals(2, solution(110011, 10));
    }

    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        String[] arr = str.split("0");
        for (String s : arr) {
            if (s.equals("")) {
                continue;
            }
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }


}
