package programmers.two;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DivideGridTest {
  @Test
  void test() {
    Assertions.assertEquals(
        3,
        solution(9, new int[][] {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    Assertions.assertEquals(0, solution(4, new int[][] {{1, 2}, {2, 3}, {3, 4}}));
    Assertions.assertEquals(
        1, solution(7, new int[][] {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    Assertions.assertEquals(
        0, solution(8, new int[][] {{1, 2}, {1, 3}, {1, 4}, {4, 5}, {5, 6}, {6, 7}, {6, 8}}));
    Assertions.assertEquals(1, solution(3, new int[][] {{1, 2}, {2, 3}}));
  }

  public int solution(int n, int[][] wires) {
    int answer = Integer.MAX_VALUE;
    // 자를 배열
    for (int i = 0; i < wires.length; i++) {
      // 연결 노드 표현
      Set<Integer> node1 = new HashSet<>();
      Set<Integer> node2 = new HashSet<>();
      node1.add(wires[i][0]);
      node2.add(wires[i][1]);

      Queue<Integer> queue = new LinkedList<>();
      queue.add(wires[i][0]);
      while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int j = 0; j < wires.length; j++) {
          if (i == j) {
            continue;
          }
          int[] current = wires[j];
          if (current[0] == node && !node1.contains(current[1])) {
            queue.add(current[1]);
            node1.add(current[1]);
          } else if (current[1] == node && !node1.contains(current[0])) {
            queue.add(current[0]);
            node1.add(current[0]);
          }
        }
      }
      for(int j = 0; j < n; j++) {
        if (!node1.contains(j + 1)) {
          node2.add(j + 1);
        }
      }

      answer = Math.min(answer, Math.abs(node1.size() - node2.size()));
    }
    return answer;
  }
}
