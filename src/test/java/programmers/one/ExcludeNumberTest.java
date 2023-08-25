package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExcludeNumberTest {

  @Test
  void test() {
    Assertions.assertEquals(14, solution(new int[] {1, 2, 3, 4, 6, 7, 8, 0}));
    Assertions.assertEquals(6, solution(new int[] {5, 8, 4, 0, 6, 7, 9}));
  }

  public int solution(int[] numbers) {
    int answer = 0;
    int[] arr = new int[10];
    for (int number : numbers) {
      arr[number] = 1;
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        answer += i;
      }
    }
    return answer;
  }
}
