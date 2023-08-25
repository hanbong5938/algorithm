package programmers.one;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SecretTest {

  @Test
  void test() {
    Assertions.assertEquals("happy", solution("aukks", "wbqd", 5));
  }

  public String solution(String s, String skip, int index) {
    StringBuilder answer = new StringBuilder();
    List<String> list = new LinkedList<>();
    for (int i = 0; i < 26; i++) {
      String str = String.valueOf((char) (i + 'a'));
      if (!skip.contains(str)) {
        list.add(str);
      }
    }

    for (char c : s.toCharArray()) {
      answer.append(list.get((list.indexOf(String.valueOf(c)) + index) % list.size()));
    }
    return answer.toString();
  }
}
