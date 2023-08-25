package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeTilingTest {

  @Test
  void test() {
    Assertions.assertEquals(1, solution(0));
    Assertions.assertEquals(0, solution(1));
    Assertions.assertEquals(3, solution(2));
    Assertions.assertEquals(0, solution(3));
    Assertions.assertEquals(11, solution(4));
    Assertions.assertEquals(0, solution(5));
    Assertions.assertEquals(41, solution(6));
    Assertions.assertEquals(0, solution(7));
    Assertions.assertEquals(153, solution(8));
    Assertions.assertEquals(0, solution(9));
    Assertions.assertEquals(571, solution(10));
    Assertions.assertEquals(0, solution(11));
    Assertions.assertEquals(2131, solution(12));
    Assertions.assertEquals(0, solution(13));
    Assertions.assertEquals(7953, solution(14));
  }

  public int solution(int n) {
    if (n % 2 == 1) {
      return 0;
    }
    long answer;
    int before = 1;
    int current = 1;

    for (int i = 2; i <= n; i += 2) {
      answer = ((current * 4L) - before) % 1000000007;
      before = current;
      current = (int) answer;
    }
    return current < 0 ? current + 1000000007 : current;
  }
}
