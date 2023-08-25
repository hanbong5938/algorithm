package programmers.two;

import java.util.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InterceptorSystemTest {

  @Test
  void test() {
    Assertions.assertEquals(
        3, solution(new int[][] {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
  }

  public int solution(int[][] targets) {
    int answer = 0;
    PriorityQueue<int[]> pq =
        new PriorityQueue<>(
            (o1, o2) -> {
              if (o1[1] == o2[1]) return o1[0] - o2[0];
              else return o1[1] - o2[1];
            });

    for (int[] target : targets) {
      pq.add(target);
    }

    int end = 0;
    while (!pq.isEmpty()) {
      int[] target = pq.poll();
      if (target[0] >= end) {
        end = target[1];
        answer++;
      }
    }

    return answer;
  }
}
