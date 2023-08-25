package programmers.two;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SelectTangerineTest {

  @Test
  void test() {
    Assertions.assertEquals(3, solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
    Assertions.assertEquals(2, solution(4, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
    Assertions.assertEquals(1, solution(2, new int[] {1, 1, 1, 1, 2, 2, 2, 3}));
  }

  public int solution(int k, int[] tangerine) {
    int answer = 0;
    int[] count = new int[10000000];
    for (int j : tangerine) {
      count[j]++;
    }
    Arrays.sort(count);
    int temp = 0;
    for (int i = 0; i < count.length; i++) {
      temp += count[count.length - 1 - i];
      answer++;
      if (temp >= k) {
        break;
      }
    }
    return answer;
  }
}
