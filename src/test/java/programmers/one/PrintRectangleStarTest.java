package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrintRectangleStarTest {

  @Test
  void test() {
    Assertions.assertEquals("*****\n*****\n*****", solution(5, 3));
  }

  public String solution(int a, int b) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < b; i++) {
      if (i != 0) {
        stringBuilder.append("\n");
      }
      stringBuilder.append("*".repeat(Math.max(0, a)));
    }
    return stringBuilder.toString();
  }
}
