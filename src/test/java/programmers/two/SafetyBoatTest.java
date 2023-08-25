package programmers.two;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SafetyBoatTest {

  @Test
  void test() {
    Assertions.assertEquals(3, solution(new int[] {70, 50, 80, 50}, 100));
    Assertions.assertEquals(3, solution(new int[] {70, 80, 50}, 100));
    Assertions.assertEquals(2, solution(new int[] {90, 40, 50, 10}, 100));
    Assertions.assertEquals(2, solution(new int[] {40, 50, 150, 160}, 200));
    Assertions.assertEquals(3, solution(new int[] {100, 500, 500, 900, 950}, 1000));
  }

  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);
    Deque<Integer> deque = new ArrayDeque<>();
    for (int person : people) {
      deque.add(person);
    }

    while (!deque.isEmpty()) {
      if (deque.size() == 1) {
        answer++;
        break;
      }

      int max = deque.pollLast();
      int min = deque.peekFirst();
      if (max + min <= limit) {
        deque.pollFirst();
      }
      answer++;
    }

    return answer;
  }
}
