package programmers.two;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxNumTest {
  @Test
  void test() {
    Assertions.assertEquals(60420, solution("100-200*300-500+20"));
    Assertions.assertEquals(300, solution("50*6-3*2"));
  }

  public long solution(String expression) {
    long answer = 0;
    String[] operators = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};
    for (String operator : operators) {
      answer = Math.max(answer, Math.abs(calculate(expression, operator)));
    }
    return answer;
  }

  private long calculate(final String expression, final String queue) {

    List<Long> numbers = new ArrayList<>();
    String[] values = expression.split("[+\\-*]");
    for (String token : values) {
      numbers.add(Long.parseLong(token));
    }
    List<String> operators = new ArrayList<>(Arrays.asList(expression.split("[0-9]+")));

    String[] order = queue.split("");
    for (String current : order) {
      int i = 0;
      while (i < operators.size()) {
        if (operators.get(i).equals("")) {
          operators.remove(i);
          continue;
        }
        if (operators.get(i).equals(current)) {
          long result =
              switch (current) {
                case "*" -> numbers.get(i) * numbers.get(i + 1);
                case "+" -> numbers.get(i) + numbers.get(i + 1);
                case "-" -> numbers.get(i) - numbers.get(i + 1);
                default -> 0;
              };
          numbers.set(i, result);
          numbers.remove(i + 1);
          operators.remove(i);
        } else {
          i++;
        }
      }
    }
    return numbers.get(0);
  }
}
