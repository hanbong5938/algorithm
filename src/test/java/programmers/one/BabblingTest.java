package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BabblingTest {

  @Test
  void test() {
    Assertions.assertEquals(1, solution(new String[] {"aya", "yee", "u", "maa"}));
    Assertions.assertEquals(
        2, solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    Assertions.assertEquals(1, solution(new String[] {"ayayeayaayaa", "ayayeaya"}));
  }

  public int solution(String[] babbling) {
    String[] arr = new String[] {"aya", "ye", "woo", "ma"};
    int answer = 0;
    for (String word : babbling) {
      for (String str : arr) {
        if (word.contains(str + str)) {
          break;
        }
        word = word.replaceAll(str, " ");

        if (word.isBlank()) {
          answer++;
          break;
        }
      }
    }
    return answer;
  }
}
