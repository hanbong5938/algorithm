
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class DiscountTest {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        Assertions.assertEquals(0, solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> original = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
            original.put(want[i], number[i]);
        }


        for (int i = 0; i < discount.length; i++) {
            if (i >= 10) {
                String key = discount[i - 10];
                if (map.containsKey(key) && map.get(key) < original.get(key)) {
                    map.put(key, map.get(key) + 1);
                }
            }

            String key = discount[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) - 1);
            }

            if (map.values().stream().allMatch(v -> v <= 0)) {
                answer++;
            }
        }

        return answer;
    }

}
