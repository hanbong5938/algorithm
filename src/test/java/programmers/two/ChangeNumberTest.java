package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChangeNumberTest {

  @Test
  void test() {
    Assertions.assertEquals(2, solution(10, 40, 5));
    Assertions.assertEquals(1, solution(10, 40, 30));
    Assertions.assertEquals(-1, solution(2, 5, 4));
  }

  public int solution(int x, int y, int n) {
    int[] dp = new int[y + 1];

    for (int i = x + 1; i < y + 1; i++) {
      int a = getDivide(x, dp, i, 2);
      int b = getDivide(x, dp, i, 3);
      int c = aboveUnderX(x, i - n) ? dp[i - n] : Integer.MAX_VALUE;
      int d = Math.min(Math.min(a, b), c);

      dp[i] = d == Integer.MAX_VALUE ? Integer.MAX_VALUE : d + 1;
    }
    return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
  }

  private int getDivide(int x, int[] dp, int i, int divide) {
    return (i / divide > 0 && i % divide == 0) && aboveUnderX(x, i / divide)
        ? dp[i / divide]
        : Integer.MAX_VALUE;
  }

  private boolean aboveUnderX(int x, int num) {
    return x <= num;
  }
}
