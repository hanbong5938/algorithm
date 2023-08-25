package programmers.one;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FailureRateTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(
        new int[] {3, 4, 2, 1, 5}, solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
    Assertions.assertArrayEquals(new int[] {4, 1, 2, 3}, solution(4, new int[] {4, 4, 4, 4, 4}));
  }

  public int[] solution(int N, int[] stages) {
    int[] answer = new int[N];
    Map<Integer, Double> failureRate = new HashMap<>();

    for (int i = 1; i <= N; i++) {
      int reach = 0;
      int notClear = 0;
      for (int stage : stages) {
        if (stage >= i) {
          reach++;
        }
        if (stage == i) {
          notClear++;
        }
      }
      failureRate.put(i, reach == 0 ? 0 : (double) notClear / reach);
    }

    List<Map.Entry<Integer, Double>> list = new ArrayList<>(failureRate.entrySet());
    list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i).getKey();
    }
    return answer;
  }
}
