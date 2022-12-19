package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MakeStrangeWordTest {

    @Test
    void test() {
        Assertions.assertEquals("TrY HeLlO WoRlD", solution("try hello world"));
        Assertions.assertEquals("AbC AbCd AbCdE", solution("abc abcd abcde"));
        Assertions.assertEquals("AbC  AbCd  AbCdE", solution("abc  abcd  abcde"));
        Assertions.assertEquals(" AbC  AbCd  AbCdE", solution(" abc  abcd  abcde"));
        Assertions.assertEquals("TrY HeLlO  WoRlD    ", solution("tRy hello  WORLD    "));
    }

    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        char[] arr = s.toCharArray();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                index = 0;
                builder.append(' ');
                continue;
            }

            if (index % 2 == 0) {
                builder.append(String.valueOf(arr[i]).toUpperCase());
                index++;
            } else {
                builder.append(String.valueOf(arr[i]).toLowerCase());
                index++;
            }
        }
        return builder.toString();
    }
}