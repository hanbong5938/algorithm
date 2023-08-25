package programmers.two;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RicochetRobotTest {

  private static final int[] dx = {-1, 1, 0, 0};
  private static final int[] dy = {0, 0, -1, 1};

  @Test
  void test() {
    Assertions.assertEquals(
        7, solution(new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    Assertions.assertEquals(-1, solution(new String[] {".D.R", "....", ".G..", "...D"}));
  }

  public int solution(String[] board) {
    int answer = -1;
    Target robot = null;
    Target goal = null;
    for (int i = 0; i < board.length; i++) {
      if (robot == null) {
        int x = board[i].indexOf("R");
        if (x > -1) {
          robot = new Target(x, i, 0);
        }
      }

      if (goal == null) {
        int x = board[i].indexOf("G");
        if (x > -1) {
          goal = new Target(x, i, 0);
        }
      }
      if (robot != null && goal != null) {
        break;
      }
    }

    Queue<Target> queue = new LinkedList<>();
    queue.add(robot);
    boolean[][] visited = new boolean[board.length][board[0].length()];
    visited[robot.y][robot.x] = true;

    while (!queue.isEmpty()) {
      Target current = queue.poll();
      if (current.x == goal.x && current.y == goal.y) {
        return current.count;
      }

      for (int i = 0; i < dx.length; i++) {
        int x = current.x;
        int y = current.y;
        while (x >= 0 && y >= 0 && x < board[0].length() && y < board.length) {
          if (board[y].charAt(x) == 'D') {
            break;
          }
          x += dx[i];
          y += dy[i];
        }

        x -= dx[i];
        y -= dy[i];

        if (visited[y][x]) {
          continue;
        }

        visited[y][x] = true;
        queue.add(new Target(x, y, current.count + 1));
      }
    }

    return answer;
  }

  private static class Target {
    int x;
    int y;
    int count;

    public Target(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }
}
