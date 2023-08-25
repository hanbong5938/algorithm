package programmers.two;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CollectBlockTest {

  @Test
  void test() {
    Assertions.assertTrue(solution("()()"));
    Assertions.assertTrue(solution("(())()"));
    Assertions.assertFalse(solution(")()("));
    Assertions.assertFalse(solution("(()("));
    Assertions.assertTrue(solution2("()()"));
    Assertions.assertTrue(solution2("(())()"));
    Assertions.assertFalse(solution2(")()("));
    Assertions.assertFalse(solution2("(()("));
  }

  boolean solution(String s) {
    Stack<Character> stack = new Stack<>();
    char[] arr = s.toCharArray();
    for (char c : arr) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        } else {
          stack.pop();
        }
      }
    }
    return stack.isEmpty();
  }

  boolean solution2(String s) {
    int count = 0;
    char[] arr = s.toCharArray();
    for (char c : arr) {
      if (c == '(') {
        count++;
      } else {
        count--;
      }
      if (count < 0) {
        return false;
      }
    }
    return count == 0;
  }
}
