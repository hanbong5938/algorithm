package programmers.two;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TableHashTest {

  @Test
  void test() {
    Assertions.assertEquals(
        4,
        solution(
            new int[][] {
              {2, 2, 6},
              {1, 5, 10},
              {4, 2, 9},
              {3, 8, 3}
            },
            2,
            2,
            3));
  }

  public int solution(int[][] data, int col, int row_begin, int row_end) {
    int answer = 0;

    Arrays.sort(
        data,
        (o1, o2) -> {
          if (o1[col - 1] == o2[col - 1]) {
            return o2[0] - o1[0];
          }
          return o1[col - 1] - o2[col - 1];
        });

    for (int i = row_begin; i <= row_end; i++) {
      int sum = 0;
      int temp = i - 1;
      for (int j = 0; j < data[temp].length; j++) {
        sum += data[temp][j] % i;
      }
      answer ^= sum;
    }

    return answer;
  }
}
