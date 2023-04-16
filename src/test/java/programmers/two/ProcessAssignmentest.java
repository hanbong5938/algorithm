
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class ProcessAssignmentest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new String[]{"korean", "english", "math"},
                solution(new String[][]{
                        {"korean", "11:40", "30"},
                        {"english", "12:10", "20"},
                        {"math", "12:30", "40"}}));
        Assertions.assertArrayEquals(new String[]{"science", "history", "computer", "music"},
                solution(new String[][]{
                        {"science", "12:40", "50"},
                        {"music", "12:20", "40"},
                        {"history", "14:00", "30"},
                        {"computer", "12:30", "100"}}));
        Assertions.assertArrayEquals(new String[]{"bbb", "ccc", "aaa"},
                solution(new String[][]{
                        {"aaa", "12:00", "20"},
                        {"bbb", "12:10", "30"},
                        {"ccc", "12:40", "10"}}));

    }

    public String[] solution(String[][] plans) {

        PriorityQueue<Plan> plan = new PriorityQueue<>(Comparator.comparingInt(a -> a.startTime));
        Stack<Plan> stack = new Stack<>();

        for (String[] row : plans) {
            plan.add(new Plan(row));
        }

        String[] answer = new String[plans.length];
        int index = 0;

        int currTime = 0;

        while (!plan.isEmpty() || !stack.isEmpty()) {
            if (plan.isEmpty()) {
                answer[index++] = stack.pop().subject;
            } else {
                final Plan peek = plan.peek();
                int startTime = peek.startTime;
                int remainTime = peek.remainTime;
                if (stack.isEmpty()) {
                    currTime = startTime;
                    stack.push(plan.poll());
                } else if (startTime < currTime + remainTime) {
                    stack.peek().remainTime -= startTime - currTime;
                    currTime = startTime;
                    stack.push(plan.poll());
                } else {
                    currTime += remainTime;
                    answer[index++] = stack.pop().subject;
                }
            }
        }
        return answer;
    }

    private static class Plan {

        private final String subject;
        private final int startTime;
        private int remainTime;

        public Plan(String[] info) {
            this.subject = info[0];
            String[] split = info[1].split(":");
            this.startTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            this.remainTime = Integer.parseInt(info[2]);
        }
    }
}
