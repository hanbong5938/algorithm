package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepeatBinaryTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(new int[] {3, 8}, solution("110010101001"));
    Assertions.assertArrayEquals(new int[] {3, 3}, solution("01110"));
    Assertions.assertArrayEquals(new int[] {4, 1}, solution("1111111"));
  }

  public int[] solution(String s) {
    int count = 0;
    int zeroCount = 0;

    while (!s.equals("1")) {
      int originalLength = s.length();
      int removeLength = s.replace("0", "").length();
      zeroCount += originalLength - removeLength;
      s = Integer.toBinaryString(removeLength);
      count++;
    }

    return new int[] {count, zeroCount};
  }
}
