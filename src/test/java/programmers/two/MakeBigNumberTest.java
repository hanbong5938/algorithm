package programmers.two;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MakeBigNumberTest {

  @Test
  void test() {
    Assertions.assertEquals("94", solution("1924", 2));
    Assertions.assertEquals("3234", solution("1231234", 3));
    Assertions.assertEquals("775841", solution("4177252841", 4));
    Assertions.assertEquals("234", solution("01234", 2));
    Assertions.assertEquals("432", solution("4321", 1));
  }

  public String solution(String number, int k) {
    StringBuilder answer = new StringBuilder();
    int idx = 0;
    for (int i = 0; i < number.length() - k; i++) {

      char max = 0;
      for (int j = idx; j <= i + k; j++) {
        char current = number.charAt(j);
        if (max < current) {
          max = current;
          idx = j + 1;
        }
      }
      answer.append(max);
    }

    return answer.toString();
  }
}
