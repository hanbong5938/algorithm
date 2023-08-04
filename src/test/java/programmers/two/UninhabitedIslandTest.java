package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class UninhabitedIslandTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1, 1, 27}, solution(new String[]{
                "X591X",
                "X1X5X",
                "X231X",
                "1XXX1"}));
        Assertions.assertArrayEquals(new int[]{-1}, solution(new String[]{
                "XXX",
                "XXX",
                "XXX"}));
    }


    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        Queue<int[]> islands = new LinkedList<>();
        int[][] map = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                    islands.offer(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        while (!islands.isEmpty()) {
            int temp = bfs(maps, islands.poll(), visited, map);
            if (temp != 0) {
                answer.add(temp);
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(String[] maps, int[] start, boolean[][] visited, int[][] map) {
        if (visited[start[0]][start[1]]) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int answer = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            answer += map[y][x];
            for (int[] direction : DIRECTIONS) {
                int nextY = y + direction[0];
                int nextX = x + direction[1];
                if (nextX < 0 || nextY < 0 || nextY >= maps.length || nextX >= maps[0].length()
                        || visited[nextY][nextX] || map[nextY][nextX] == -1) {
                    continue;
                }
                visited[nextY][nextX] = true;
                queue.offer(new int[]{nextY, nextX});
            }
        }
        return answer;
    }


}
