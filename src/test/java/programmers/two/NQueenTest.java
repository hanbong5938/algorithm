package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NQueenTest {

  @Test
  void test() {
    Assertions.assertEquals(2, solution(4));
  }

  public int solution(int n) {
    int[] cols = new int[n];
    return dfs(cols, 0, n);
  }

  int dfs(int[] cols, int row, int n) {
    if (row == n) {
      return 1;
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (this.isPossible(cols, i, row)) {
        cols[row] = i;
        count += dfs(cols, row + 1, n);
      }
    }
    return count;
  }

  boolean isPossible(int[] cols, int index, int row) {
    for (int i = 0; i < row; i++) {
      if (cols[i] == index || row - i == Math.abs(index - cols[i])) {
        return false;
      }
    }
    return true;
  }
}
