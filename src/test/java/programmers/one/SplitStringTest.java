package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SplitStringTest {

  @Test
  void test() {
    Assertions.assertEquals(3, solution("banana"));
    Assertions.assertEquals(6, solution("abracadabra"));
    Assertions.assertEquals(3, solution("aaabbaccccabba"));
    Assertions.assertEquals(1, solution("a"));
  }

  public int solution(String s) {
    if (s.length() == 1) {
      return 1;
    }

    int answer = 0;
    int x = 0;
    int y = 0;
    char c = s.charAt(0);
    x++;

    for (int i = 1; i < s.length(); i++) {
      if (c == s.charAt(i)) {
        x++;
      } else {
        y++;
      }

      if (x == y) {
        answer++;
        x = 0;
        y = 0;
        c = s.charAt(Math.min(s.length() - 1, i + 1));
      } else if (s.length() - 1 == i) {
        answer++;
      }
    }
    return answer;
  }
}
