
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class PostBoxTest {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(new int[]{4, 3, 1, 2, 5}));
        Assertions.assertEquals(5, solution(new int[]{5, 4, 3, 2, 1}));
    }

    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subContainer = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            int target = order[answer];
            if (i == target) {
                answer = check(answer, subContainer, order);
            } else if (!subContainer.isEmpty() && subContainer.peek() == target) {
                subContainer.pop();
                answer = check(answer, subContainer, order);
            } else if (subContainer.isEmpty() || i < target) {
                subContainer.push(i);
            } else {
                break;
            }
        }
        return answer;
    }

    private int check(int answer, Stack<Integer> subContainer, int[] order) {
        answer++;
        while (!subContainer.isEmpty() && order[answer] == subContainer.peek()) {
            subContainer.pop();
            answer++;
        }
        return answer;
    }

}
