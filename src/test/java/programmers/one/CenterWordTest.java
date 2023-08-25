package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CenterWordTest {

  @Test
  void solution() {
    final String s = "abcde";
    int index = s.length() / 2;

    Assertions.assertEquals(
        "c",
        s.length() % 2 == 0
            ? s.charAt(index - 1) + "" + s.charAt(index)
            : String.valueOf(s.charAt(index)));
  }
}
