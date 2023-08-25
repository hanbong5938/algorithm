package programmers.one;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortUpToMeTest {

  @Test
  void solution() {
    String[] strings = {"sun", "bed", "car"};
    int n = 1;
    String[] returnValue = {"car", "bed", "sun"};

    Arrays.sort(strings);
    Arrays.sort(strings, Comparator.comparingInt(s -> s.charAt(n)));

    for (int i = 0; i < strings.length; i++) {
      Assertions.assertEquals(returnValue[i], strings[i]);
    }
  }
}
