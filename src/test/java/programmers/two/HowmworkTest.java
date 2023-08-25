package programmers.two;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeworkTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(
        new String[] {"korean", "english", "math"},
        solution(
            new String[][] {
              {"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}
            }));
    Assertions.assertArrayEquals(
        new String[] {"science", "history", "computer", "music"},
        solution(
            new String[][] {
              {"science", "12:40", "50"},
              {"music", "12:20", "40"},
              {"history", "14:00", "30"},
              {"computer", "12:30", "100"}
            }));
    Assertions.assertArrayEquals(
        new String[] {"bbb", "ccc", "aaa"},
        solution(
            new String[][] {
              {"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}
            }));
  }

  public String[] solution(String[][] plans) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    List<String> answer = new ArrayList<>();
    PriorityQueue<String[]> queue =
        new PriorityQueue<>(
            (o1, o2) -> {
              String time1 = o1[1];
              String time2 = o2[1];
              return time1.compareTo(time2);
            });

    for (String[] plan : plans) {
      queue.add(plan);
    }

    Stack<String[]> stack = new Stack<>();

    while (!queue.isEmpty()) {
      String[] plan = queue.poll();
      processHomework(queue, stack, plan, answer);
    }

    while (!stack.isEmpty()) {
      String[] pop = stack.pop();
      answer.add(pop[0]);
    }

    return answer.toArray(new String[0]);
  }

  private int calculateTimeDifference(String startTime, String endTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime localStartTime = LocalTime.parse(startTime, formatter);
    LocalTime localEndTime = LocalTime.parse(endTime, formatter);
    Duration duration = Duration.between(localStartTime, localEndTime);
    return (int) duration.toMinutes();
  }

  private String addTime(String startTime, int minutesToAdd) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime localStartTime = LocalTime.parse(startTime, formatter);
    LocalTime newTime = localStartTime.plusMinutes(minutesToAdd);
    return newTime.format(formatter);
  }

  private void processHomework(
      PriorityQueue<String[]> queue, Stack<String[]> stack, String[] plan, List<String> answer) {
    String subject = plan[0];
    String startTime = plan[1];
    String time = plan[2];

    if (!queue.isEmpty()) {
      String[] nextPlan = queue.peek();
      String nextStartTime = nextPlan[1];
      int diff = calculateTimeDifference(nextStartTime, startTime);
      int remainTime = diff - Integer.parseInt(time);

      if (remainTime > 0) {
        answer.add(subject);
        if (!stack.isEmpty()) {
          String[] pop = stack.pop();
          processHomework(
              queue,
              stack,
              new String[] {pop[0], addTime(startTime, Integer.parseInt(time)), pop[2]},
              answer);
        }
      } else if (remainTime < 0) {
        stack.push(new String[] {subject, startTime, String.valueOf(Math.abs(remainTime))});
      } else {
        answer.add(subject);
      }
    } else {
      answer.add(subject);
    }
  }
}
