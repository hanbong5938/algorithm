package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraySliceTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(new int[] {3, 2, 2, 3}, solution(3, 2, 5));
    Assertions.assertArrayEquals(new int[] {4, 3, 3, 3, 4, 4, 4, 4}, solution(4, 7, 14));
  }
  public int[] solution(int n, long left, long right) {
    int[] answer = new int[(int) (right + 1 - left)];
    for(int i = 0; i < answer.length; i++) {
      int y = (int)(left / n + 1);
      int x = (int)(left % n + 1);
      left++;
      answer[i] = Math.max(y, x);
    }
    return answer;
  }
}
