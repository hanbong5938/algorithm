
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class TupleTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{2, 1, 3, 4}, solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        Assertions.assertArrayEquals(new int[]{2, 1, 3, 4}, solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
        Assertions.assertArrayEquals(new int[]{111, 20}, solution("{{20,111},{111}}"));
        Assertions.assertArrayEquals(new int[]{123}, solution("{{123}}"));
        Assertions.assertArrayEquals(new int[]{3, 2, 4, 1}, solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }

    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        String[] str = s.replace("{", "").split("},");
        for (String st : str) {
            String[] st2 = st.split(",");
            for (String st3 : st2) {
                Integer num = Integer.parseInt(st3.replace("}", ""));
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int[] answer = new int[map.size()];
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}
