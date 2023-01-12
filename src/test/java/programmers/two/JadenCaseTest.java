
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class JadenCaseTest {

    @Test
    void test() {
        Assertions.assertEquals("3people Unfollowed Me", solution("3people unFollowed me"));
        Assertions.assertEquals("For The Last Week", solution("for the last week"));
        Assertions.assertEquals("For The Last Week ", solution("for the last week "));
        Assertions.assertEquals("For The  Last Week ", solution("for the  last week "));
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || (s.charAt(i - 1) == ' ' && s.charAt(i) != ' ')) {
                answer.append(String.valueOf(s.charAt(i)).toUpperCase());
            } else {
                answer.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }
        return answer.toString();
    }
}
