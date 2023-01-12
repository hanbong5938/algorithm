package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class MakeHamburgerTest {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        Assertions.assertEquals(2, solution2(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        Assertions.assertEquals(0, solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
        Assertions.assertEquals(0, solution2(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int j : ingredient) {
            stack.push(j);
            int size = stack.size();
            if (stack.size() > 3 && stack.get(size - 4) == 1 && stack.get(size - 3) == 2 && stack.get(size - 2) == 3 && stack.get(size - 1) == 1) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                answer++;
            }
        }
        return answer;
    }

    public int solution2(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int index = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[index++] = i;
            if (index >= 3 && stack[index - 1] == 1
                    && stack[index - 2] == 3
                    && stack[index - 3] == 2
                    && stack[index - 4] == 1) {
                index -= 4;
                answer++;
            }
        }
        return answer;
    }
}
