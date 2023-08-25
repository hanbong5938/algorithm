package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberBlockTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(new int[] {0, 1, 1, 2, 1, 3, 1, 4, 3, 5}, solution(1, 10));
  }

  public int[] solution(long begin, long end) {
    int[] answer = new int[(int) (end - begin + 1)];
    int idx = 0;

    for (int i = (int) begin; i <= end; i++) {
      boolean isPrime = true;
      if (i == 1) {
        answer[idx++] = 0;
        continue;
      }

      for (int j = 2; j * j <= i; j++) {
        if (i % j == 0 && i / j <= 10000000) {
          answer[idx++] = i / j;
          isPrime = false;
          break;
        }
      }

      if (isPrime) {
        answer[idx++] = 1;
      }
    }

    return answer;
  }
}
