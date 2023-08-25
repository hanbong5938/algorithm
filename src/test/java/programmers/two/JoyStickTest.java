package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JoyStickTest {

  @Test
  void test() {
    Assertions.assertEquals(11, solution("JAZ"));
    Assertions.assertEquals(56, solution("JEROEN"));
    Assertions.assertEquals(23, solution("JAN"));
    Assertions.assertEquals(6, solution("BBAAAB"));
    Assertions.assertEquals(16, solution("AAAAABBAAAAAAABAAA"));
  }

  public int solution(String name) {
    int answer = 0;
    int length = name.length();

    for (int i = 0; i < name.length(); i++) {
      answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
    }

    int move = length - 1;

    for (int i = 0; i < name.length(); i++) {
      int index = i + 1;
      while (index < length && name.charAt(index) == 'A') {
        index++;
      }

      move = Math.min(Math.min(move, i * 2 + length - index), (length - index) * 2 + i);
    }

    return answer + move;
  }
}
