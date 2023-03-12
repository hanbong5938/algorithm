
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class RotatingParenthesesTest {

    @Test
    void test() {
        Assertions.assertEquals(3, solution("[](){}"));
        Assertions.assertEquals(2, solution("}]()[{"));
        Assertions.assertEquals(0, solution("[)(]"));
        Assertions.assertEquals(0, solution("}}}"));
    }


    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            String temp = s.substring(i) + s.substring(0, i);
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < length; j++) {
                char c = temp.charAt(j);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        break;
                    }
                    char pop = stack.pop();
                    if ((c == ')' && pop != '(') || (c == '}' && pop != '{') || (c == ']' && pop != '[')) {
                        break;
                    }
                }
                if (j == length - 1 && stack.isEmpty()) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
