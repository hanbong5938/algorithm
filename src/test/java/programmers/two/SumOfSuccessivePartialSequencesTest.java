
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumOfSuccessivePartialSequencesTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{2, 3}, solution(new int[]{1, 2, 3, 4, 5}, 7));
        Assertions.assertArrayEquals(new int[]{6, 6}, solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5));
        Assertions.assertArrayEquals(new int[]{0, 2}, solution(new int[]{2, 2, 2, 2, 2}, 6));
    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length - 1};
        int start = 0;
        int end = 1;
        int sum = sequence[start];
        while (start < end) {
            if (sum == k) {
                int length = end - start;
                if (length == 0) {
                    return new int[]{start, end};
                }
                if (length - 1 < answer[1] - answer[0]) {
                    answer[0] = start;
                    answer[1] = end - 1;
                }
                sum -= sequence[start++];
            } else if (sum > k) {
                sum -= sequence[start++];
            } else {
                if (end < sequence.length) {
                    sum += sequence[end++];
                } else {
                    break;
                }
            }
        }
        return answer;
    }

}
