package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FatigueTest {

  int answer = -1;

  @Test
  void test() {
    Assertions.assertEquals(3, solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
  }

  public int solution(int k, int[][] dungeons) {
    boolean[] visited = new boolean[dungeons.length];
    dfs(k, dungeons, visited, 0);
    return answer;
  }

  private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
    for (int i = 0; i < dungeons.length; i++) {
      if (!visited[i] && k >= dungeons[i][0]) {
        visited[i] = true;
        dfs(k - dungeons[i][1], dungeons, visited, count + 1);
        visited[i] = false;
      }
    }
    answer = Math.max(count, answer);
  }
}
