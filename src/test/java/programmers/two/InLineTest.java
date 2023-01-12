
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class InLineTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{3, 1, 2}, solution(3, 5));
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> human = new ArrayList<>();
        long numberOfCase = 1;
        for (int i = 1; i <= n; i++) {
            numberOfCase *= i;
            human.add(i);
        }

        k--;
        int idx = 0;
        while (n > 0) {
            numberOfCase /= n;
            int current = (int) (k / numberOfCase);
            answer[idx] = human.get(current);
            human.remove(current);
            k %= numberOfCase;
            idx++;
            n--;
        }
        return answer;
    }
}
