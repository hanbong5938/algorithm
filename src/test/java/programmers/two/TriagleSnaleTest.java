package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TriagleSnaleTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(new int[] {1, 2, 9, 3, 10, 8, 4, 5, 6, 7}, solution(4));
    Assertions.assertArrayEquals(
        new int[] {1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9}, solution(5));
    Assertions.assertArrayEquals(
        new int[] {1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11},
        solution(6));
  }

  // 아래, 오른쪽, 대각선 위
  private static final int[] dx = {0, 1, -1};
  private static final int[] dy = {1, 0, -1};

  public int[] solution(int n) {
    int[][] point = new int[n][n];
    int value = 1;
    int x = 0;
    int y = 0;
    int direction = 0;
    boolean isContinue = true;
    while (true) {
      point[y][x] = value++;
      int nx = x + dx[direction];
      int ny = y + dy[direction];
      if (isChangeDirection(n, nx, ny, point)) {
        direction = (direction + 1) % 3;
        nx = x + dx[direction];
        ny = y + dy[direction];
        if (isChangeDirection(n, nx, ny, point)) {
          break;
        }
      }
      x = nx;
      y = ny;
    }
    int[] result = new int[value - 1];
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        result[index++] = point[i][j];
      }
    }
    return result;
  }

  private boolean isChangeDirection(final int n, final int nx, final int ny, final int[][] point) {
    return nx == n || ny == n || point[ny][nx] != 0;
  }
}
