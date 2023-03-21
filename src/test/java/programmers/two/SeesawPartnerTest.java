package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class SeesawPartnerTest {

    @Test
    void test() {
        Assertions.assertEquals(1, solution(new int[]{100, 100}));
        Assertions.assertEquals(3, solution(new int[]{100, 100, 100}));
        Assertions.assertEquals(6, solution(new int[]{100, 100, 100, 100}));
        Assertions.assertEquals(10, solution(new int[]{100, 100, 100, 100, 100}));
        Assertions.assertEquals(4, solution(new int[]{100, 180, 360, 100, 270}));
        Assertions.assertEquals(3, solution(new int[]{180, 240, 360}));
        Assertions.assertEquals(0, solution(new int[]{180, 190}));
        Assertions.assertEquals(15, solution(new int[]{100, 100, 100, 200, 200, 200}));
    }

    public long solution(int[] weights) {
        long answer = 0;

        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);

        for (double weight : weights) {
            answer += count(weight, map);
        }

        return answer;
    }

    public long count(double weight, Map<Double, Integer> map) {
        long answer = 0;

        double d2 = (weight * 2) / 3.0;
        double d3 = weight / 2.0;
        double d4 = (weight * 3) / 4.0;

        if (map.containsKey(weight)) {
            answer += map.get(weight);
        }
        if (map.containsKey(d2)) {
            answer += map.get(d2);
        }
        if (map.containsKey(d3)) {
            answer += map.get(d3);
        }
        if (map.containsKey(d4)) {
            answer += map.get(d4);
        }

        map.put(weight, map.getOrDefault(weight, 0) + 1);
        return answer;
    }
}
