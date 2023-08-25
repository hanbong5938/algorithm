package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NextBigNumberTest {

  @Test
  void test() {
    Assertions.assertEquals(83, solution(78));
    Assertions.assertEquals(23, solution(15));
    Assertions.assertEquals(83, solution2(78));
    Assertions.assertEquals(23, solution2(15));
  }

  public int solution(int n) {
    int count = Integer.bitCount(n);
    for (int i = n + 1; i <= 1000000; i++) {
      if (count == Integer.bitCount(i)) {
        return i;
      }
    }
    return 0;
  }

  public int solution2(int n) {
    int postPattern = n & -n;
    int smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
    return n + postPattern | smallPattern;
  }
}
