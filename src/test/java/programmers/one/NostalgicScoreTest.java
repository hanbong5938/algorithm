package programmers.one;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NostalgicScoreTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(
        new int[] {19, 15, 6},
        solution(
            new String[] {"may", "kein", "kain", "radi"},
            new int[] {5, 10, 1, 3},
            new String[][] {
              {"may", "kein", "kain", "radi"},
              {"may", "kein", "brin", "deny"},
              {"kon", "kain", "may", "coni"}
            }));
    Assertions.assertArrayEquals(
        new int[] {67, 0, 55},
        solution(
            new String[] {"kali", "mari", "don"},
            new int[] {11, 1, 55},
            new String[][] {
              {"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}
            }));
    Assertions.assertArrayEquals(
        new int[] {5, 15, 0},
        solution(
            new String[] {"may", "kein", "kain", "radi"},
            new int[] {5, 10, 1, 3},
            new String[][] {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}}));
  }

  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    int[] answer = new int[photo.length];
    Map<String, Integer> score = new HashMap<>();
    for (int i = 0; i < name.length; i++) {
      score.put(name[i], yearning[i]);
    }

    for (int i = 0; i < photo.length; i++) {
      String[] p = photo[i];
      int sum = 0;
      for (String str : p) {
        if (score.containsKey(str)) {
          sum += score.get(str);
        }
      }
      answer[i] = sum;
    }
    return answer;
  }
}
