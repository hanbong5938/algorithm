package programmers.two;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindBigNumBehindTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(new int[] {3, 5, 5, -1}, solution(new int[] {2, 3, 3, 5}));
    Assertions.assertArrayEquals(
        new int[] {-1, 5, 6, 6, -1, -1}, solution(new int[] {9, 1, 5, 3, 6, 2}));
  }

  public int[] solution(int[] numbers) {
    int length = numbers.length;
    int[] answer = new int[length];

    Stack<Integer> stack = new Stack<>();
    for (int i = length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
        stack.pop();
      }
      answer[i] = !stack.isEmpty() ? stack.peek() : -1;
      stack.push(numbers[i]);
    }
    return answer;
  }
}
