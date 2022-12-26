package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

class HallOfFrameTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{10, 10, 10, 20, 20, 100, 100},
                solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}));
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300},
                solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}));
    }

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> rank = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            int s = score[i];
            if (rank.size() < k) {
                rank.add(s);
                answer[i] = rank.peek();
            } else {
                if (rank.peek() < s) {
                    rank.poll();
                    rank.add(s);
                }
                answer[i] = rank.peek();
            }
        }
        return answer;
    }
}
