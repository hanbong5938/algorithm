package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeNotationTest {

  @Test
  void test() {
    Assertions.assertEquals(7, solution(45));
    Assertions.assertEquals(229, solution(125));
  }

  public int solution(int n) {
    int answer = 0;
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      sb.append(n % 3);
      n /= 3;
    }

    return Integer.parseInt(sb.toString(), 3);
  }
}
