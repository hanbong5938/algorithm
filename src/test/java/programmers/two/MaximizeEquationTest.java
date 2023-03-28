
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MaximizeEquationTest {

    @Test
    void test() {
        Assertions.assertEquals(60420, solution("100-200*300-500+20"));
        Assertions.assertEquals(300, solution("50*6-3*2"));
    }

    public long solution(String expression) {
        long answer = 0;

        String[] numbers = expression.split("[^0-9]");
        String[] operators = {"+", "-", "*"};
        boolean[] visited = new boolean[operators.length];
        List<String> operatorPermutations = new ArrayList<>();
        permutation(operators, operatorPermutations, visited, 0, operators.length, "");

        for (String operatorPermutation : operatorPermutations) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < numbers.length; i++) {
                stack.push(numbers[i]);
                if (i < numbers.length - 1) {
                    stack.push(String.valueOf(operatorPermutation.charAt(i)));
                }
            }
            for (int i = 0; i < operators.length; i++) {
                Stack<String> temp = new Stack<>();
                while (!stack.isEmpty()) {
                    String s = stack.pop();
                    if (s.equals(String.valueOf(operatorPermutation.charAt(i)))) {
                        long a = Long.parseLong(temp.pop());
                        long b = Long.parseLong(stack.pop());
                        switch (s) {
                            case "+" -> temp.push(String.valueOf(a + b));
                            case "-" -> temp.push(String.valueOf(a - b));
                            case "*" -> temp.push(String.valueOf(a * b));
                        }
                    } else {
                        temp.push(s);
                    }
                }
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(stack.pop())));
        }

        return answer;
    }

    private void permutation(String[] operators, List<String> operatorPermutations, boolean[] visited, int i, int length, String s) {
        if (i == length) {
            operatorPermutations.add(s);
            return;
        }
        for (int j = 0; j < operators.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                permutation(operators, operatorPermutations, visited, i + 1, length, s + operators[j]);
                visited[j] = false;
            }
        }
    }


}
