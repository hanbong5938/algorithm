
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class NumberOfConsecutiveSubsequenceAgreementsTest {

    @Test
    void test() {
        Assertions.assertEquals(18, solution(new int[]{7, 9, 1, 1, 4}));
    }

    public int solution(int[] elements) {
        Set<Integer> ans = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    int idx = (j + k) % elements.length;
                    sum += elements[idx];
                }
                ans.add(sum);
            }
        }
        return ans.size();
    }
}
