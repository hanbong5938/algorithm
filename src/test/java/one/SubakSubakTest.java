package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubakSubakTest {

    @Test
    void test() {
        Assertions.assertEquals("수박수", solution(3));
        Assertions.assertEquals("수박수박", solution(4));

    }

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                answer.append("수");
            }else {
                answer.append("박");
            }
        }
        return answer.toString();
    }
}
