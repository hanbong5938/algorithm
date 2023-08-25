package programmers.two;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumQueueTest {

  @Test
  void test() {
    Assertions.assertEquals(2, solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1}));
    Assertions.assertEquals(7, solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2}));
    Assertions.assertEquals(-1, solution(new int[] {1, 1}, new int[] {1, 5}));
  }

  public int solution(int[] queue1, int[] queue2) {
    Queue<Integer> firstQueue = new LinkedList<>();
    Queue<Integer> secondQueue = new LinkedList<>();
    long firstSum = 0;
    long secondSum = 0;
    long sum = 0;
    int i = 0;
    while (i < queue1.length) {
      firstQueue.add(queue1[i]);
      secondQueue.add(queue2[i]);
      firstSum += queue1[i];
      secondSum += queue2[i];
      sum += firstSum + secondSum;
      i++;
    }

    int count = 0;
    int end = (firstQueue.size() + secondQueue.size()) * 2;
    while (firstSum != secondSum) {
      count++;
      if (firstSum > secondSum) {
        int first = firstQueue.poll();
        firstSum -= first;
        secondSum += first;
        secondQueue.offer(first);
      } else {
        int second = secondQueue.poll();
        firstSum += second;
        secondSum -= second;
        firstQueue.offer(second);
      }

      if (count > end) {
        return -1;
      }
    }

    return count;
  }
}
