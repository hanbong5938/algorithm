package programmers.one;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringSortTest {

  @Test
  void solution() {
    String s = "Zbcdefg";
    StringBuilder answer = new StringBuilder();
    char[] arr = s.toCharArray();
    Arrays.sort(arr);
    for (char c : arr) {
      answer.insert(0, c);
    }

    Assertions.assertEquals("gfedcbZ", answer.toString());
  }
}
