package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaesarCyperTest {

    @Test
    void test() {
        Assertions.assertEquals("BC", solution("AB", 1));
        Assertions.assertEquals("a", solution("z", 1));
        Assertions.assertEquals("e F d", solution("a B z", 4));

    }

    public String solution(String s, int n) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }

            for (int j = 1; j <= n; j++) {
                char c = arr[i];
                if (c == 'z') {
                    arr[i] = 'a';
                    continue;
                } else if (c == 'Z') {
                    arr[i] = 'A';
                    continue;
                }
                arr[i] = (char) (c + 1);
            }

        }
        return new String(arr);
    }
}
