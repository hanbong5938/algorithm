package programmers.two;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CutRollCakeTest {

  @Test
  void test() {
    Assertions.assertEquals(2, solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2}));
    Assertions.assertEquals(0, solution(new int[] {1, 2, 3, 1, 4}));
  }

  public int solution(int[] topping) {
    int answer = 0;
    Set<Integer> old = new HashSet<>();
    Map<Integer, Integer> young = new HashMap<>();
    for (int top : topping) {
      young.put(top, young.getOrDefault(top, 0) + 1);
    }

    for (int key : topping) {
      int value = young.get(key);
      old.add(key);
      if (value == 1) {
        young.remove(key);
      } else {
        young.put(key, value - 1);
      }

      if (old.size() == young.size()) {
        answer++;
      }
    }
    return answer;
  }
}
