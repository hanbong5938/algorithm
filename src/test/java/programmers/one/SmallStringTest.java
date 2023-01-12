package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SmallStringTest {

    @Test
    void test() {
        Assertions.assertEquals(2, solution("3141592", "271"));
        Assertions.assertEquals(8, solution("500220839878", "7"));
        Assertions.assertEquals(3, solution("10203", "15"));
    }

    public int solution(String t, String p) {
        int answer = 0;
        long pNum = Long.parseLong(p);
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            int index = i + p.length();
            if (Long.parseLong(t.substring(i, i + p.length())) <= pNum) {
                answer++;
            }
        }
        return answer;
    }
}
