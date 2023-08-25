package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoTilingTest {

  @Test
  void test() {
    Assertions.assertEquals(1, solution(1));
    Assertions.assertEquals(2, solution(2));
    Assertions.assertEquals(3, solution(3));
    Assertions.assertEquals(5, solution(4));
    Assertions.assertEquals(8, solution(5));
  }

  public int solution(int n) {
    int answer = 0;

    if (n == 1 || n == 2) {
      return n;
    }

    int before = 1;
    int current = 2;
    for (int i = 1; i < n - 1; i++) {
      answer = (before + current) % 1000000007;
      before = current;
      current = answer;
    }
    return answer;
  }
}
