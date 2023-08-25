package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DivisorNumCountAndSumTest {

  @Test
  void test() {
    Assertions.assertEquals(43, solution(13, 17));
    Assertions.assertEquals(52, solution(24, 27));
  }

  public int solution(int left, int right) {
    int answer = 0;
    for (int i = left; i <= right; i++) {
      if (i % Math.sqrt(i) == 0) {
        answer -= i;
      } else {
        answer += i;
      }
    }

    return answer;
  }
}
