package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumNumberTest {

  @Test
  void test() {
    Assertions.assertEquals(9, solution(new int[] {4, 7, 12}, new boolean[] {true, false, true}));
    Assertions.assertEquals(0, solution(new int[] {1, 2, 3}, new boolean[] {false, false, true}));
  }

  public int solution(int[] absolutes, boolean[] signs) {
    int answer = 0;
    for (int i = 0; i < absolutes.length; i++) {
      answer += signs[i] ? absolutes[i] : -absolutes[i];
    }
    return answer;
  }
}
