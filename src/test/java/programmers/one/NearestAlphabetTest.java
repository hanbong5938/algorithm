package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NearestAlphabetTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(new int[] {-1, -1, -1, 2, 2, 2}, solution("banana"));
    Assertions.assertArrayEquals(new int[] {-1, -1, 1, -1, -1, -1}, solution("foobar"));
  }

  public int[] solution(String s) {
    int[] answer = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      answer[i] = -1;
    }

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (i != j && chars[i] == chars[j]) {
          answer[i] = i - j;
          break;
        }
      }
    }

    return answer;
  }
}
