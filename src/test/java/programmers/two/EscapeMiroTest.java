package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class EscapeMiroTest {

    @Test
    void test() {
        Assertions.assertEquals(16, solution(new String[]{
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"}));
        Assertions.assertEquals(-1, solution(new String[]{
                "LOOXS",
                "OOOOX",
                "OOOOO",
                "OOOOO",
                "EOOOO"}));
    }

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        int[] start = new int[3];
        int[] end = new int[2];
        int[] lever = new int[3];


        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                map[i][j] = c;
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                    start[2] = 0;
                } else if (c == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (c == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                    lever[2] = 0;
                }
            }
        }

        int leverCount = execute('L', start, map);
        if (leverCount == 0) {
            return -1;
        }
        int endCount = execute('E', lever, map);
        if (endCount == 0) {
            return -1;
        }
        return leverCount + endCount;
    }

    private int execute(char target, int[] point, char[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(point);

        boolean visit[][] = new boolean[map.length][map[0].length];
        visit[point[0]][point[1]] = true;

        int answer = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];
            int count = poll[2];

            if (map[pollX][pollY] == target) {
                if (answer == 0) {
                    answer = count;
                } else {
                    answer = Math.min(answer, count);
                }
            }

            for (int[] ints : dir) {
                int x = pollX + ints[0];
                int y = pollY + ints[1];

                if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || visit[x][y] || map[x][y] == 'X') {
                    continue;
                }


                visit[x][y] = true;
                queue.offer(new int[]{x, y, count + 1});
            }
        }

        return answer;
    }


}
