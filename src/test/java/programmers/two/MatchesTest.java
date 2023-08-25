package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatchesTest {

  @Test
  void test() {
    Assertions.assertEquals(3, solution(8, 4, 7));
  }

  public int solution(int n, int a, int b) {
    int answer = 0;
    while (a != b) {
      a = (a + 1) / 2;
      b = (b + 1) / 2;
      answer++;
    }
    return answer;
  }
}
