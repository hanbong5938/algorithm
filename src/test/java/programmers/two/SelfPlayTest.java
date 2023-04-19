
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SelfPlayTest {

    @Test
    void test() {
        Assertions.assertEquals(12, solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
    }

    public int solution(int[] cards) {
        int length = cards.length;
        int[] boxSize = new int[length];
        boolean[] visited = new boolean[length + 1];
        int index = 0;
        for (int card : cards) {
            if (!visited[card]) {
                dfs(index, card, cards, boxSize, visited);
                index++;
            }
        }

        Arrays.sort(boxSize);
        return boxSize[length - 1] * boxSize[length - 2];
    }

    private void dfs(int index, int card, int[] cards, int[] boxSize, boolean[] visited) {
        if (visited[card]) {
            return;
        }
        boxSize[index]++;
        visited[card] = true;
        dfs(index, cards[card - 1], cards, boxSize, visited);
    }
}
