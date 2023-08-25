package programmers.two;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumDistanceTest {

  @Test
  void test() {
    Assertions.assertEquals(
        11,
        solution(
            new int[][] {
              {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
            }));
    Assertions.assertEquals(
        -1,
        solution(
            new int[][] {
              {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}
            }));
  }

  public int solution(int[][] maps) {
    int answer = 0;
    Queue<int[]> queue = new LinkedList<>();
    int n = maps.length;
    int m = maps[0].length;
    int[][] visited = new int[n][m];
    queue.add(new int[] {0, 0});
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];

      if (x == n - 1 && y == m - 1) {
        answer = visited[x][y] + 1;
        break;
      }

      int left = x - 1;
      int right = x + 1;
      int top = y + 1;
      int bottom = y - 1;
      if (left >= 0 && maps[left][y] == 1 && visited[left][y] == 0) {
        visited[left][y] = visited[x][y] + 1;
        queue.add(new int[] {left, y});
      }
      if (right < n && maps[right][y] == 1 && visited[right][y] == 0) {
        visited[right][y] = visited[x][y] + 1;
        queue.add(new int[] {right, y});
      }
      if (top < m && maps[x][top] == 1 && visited[x][top] == 0) {
        visited[x][top] = visited[x][y] + 1;
        queue.add(new int[] {x, top});
      }
      if (bottom >= 0 && maps[x][bottom] == 1 && visited[x][bottom] == 0) {
        visited[x][bottom] = visited[x][y] + 1;
        queue.add(new int[] {x, bottom});
      }
    }
    return answer == 0 ? -1 : answer;
  }
}
