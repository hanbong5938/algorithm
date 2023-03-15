
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class CompressTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{11, 1, 27, 15}, solution("KAKAO"));
        Assertions.assertArrayEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}, solution("TOBEORNOTTOBEORTOBEORNOT"));
        Assertions.assertArrayEquals(new int[]{1, 2, 27, 29, 28, 31, 30}, solution("ABABABABABABABAB"));
    }

    public int[] solution(String msg) {
        List<String> alphabet = new ArrayList<>(List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
        List<String> additional = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = msg.length() - 1; i >= 0; i--) {
            stack.push(String.valueOf(msg.charAt(i)));
        }
        while (!stack.isEmpty()) {
            StringBuilder pop = new StringBuilder(stack.pop());
            if (additional.isEmpty()) {
                add(additional, stack, pop.toString());
                answer.add(alphabet.indexOf(pop.toString()) + 1);
            } else {
                while (!stack.isEmpty() && additional.contains(pop + stack.peek())) {
                    pop.append(stack.pop());
                }
                add(additional, stack, pop.toString());
                answer.add(pop.length() == 1 ? alphabet.indexOf(pop.toString()) + 1 : additional.indexOf(pop.toString()) + 27);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void add(List<String> additional, Stack<String> stack, String pop) {
        if (!stack.isEmpty()) {
            additional.add(pop + stack.peek());
        }
    }
}
