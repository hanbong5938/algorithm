package programmers.two;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefenceGameTest {

  @Test
  void test() {
    Assertions.assertEquals(5, solution(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1}));
    Assertions.assertEquals(4, solution(2, 4, new int[] {3, 3, 3, 3}));
  }

  public int solution(int n, int k, int[] enemy) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int i = 0; i < enemy.length; i++) {
      int current = enemy[i];
      priorityQueue.add(current);
      if (priorityQueue.size() > k) {
        n -= priorityQueue.poll();
      }
      if (n < 0) {
        return i;
      }
    }
    return enemy.length;
  }
}
