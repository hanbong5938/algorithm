
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

    //비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
    //
    //기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
    //부분 수열의 합은 k입니다.
    //합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
    //길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
    //수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요. 이때 수열의 인덱스는 0부터 시작합니다.
    //[1, 2, 3, 4, 5]	7	[2, 3]
    //[1, 1, 1, 2, 3, 4, 5]	5	[6, 6]
    //[2, 2, 2, 2, 2]	6	[0, 2]
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
