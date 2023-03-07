
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NGameTest {

    @Test
    void test() {
        Assertions.assertEquals("0111", solution(2, 4, 2, 1));
        Assertions.assertEquals("02468ACE11111111", solution(16, 16, 2, 1));
        Assertions.assertEquals("13579BDF01234567", solution(16, 16, 2, 2));
    }

    private static final String[] arr = {"A", "B", "C", "D", "E", "F"};

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        String s = getStr(n, t, m);
        int current = 1;
        for (int i = 0; i < s.length(); i++) {
            if (answer.length() == t) {
                break;
            }
            if (current > m) {
                current = 1;
            }

            if (current == p) {
                answer.append(s.charAt(i));
            }
            current++;
        }
        return answer.toString();
    }

    private String getStr(int n, int t, int m) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= t * m; i++) {
            stringBuilder.append(Integer.toString(i, n));
        }
        return stringBuilder.toString().toUpperCase();
    }


}
