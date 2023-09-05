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

class JumpTest {

  @Test
  void test() {
    Assertions.assertEquals(2, solution(5));
    Assertions.assertEquals(2, solution(6));
    Assertions.assertEquals(5, solution(5000));
  }

  public int solution(int n) {
    int ans = 0;
    while (n > 0) {
      if (n % 2 == 0) {
        n /= 2;
      } else {
        n -= 1;
        ans++;
      }
    }
    return ans;
  }
}
