package programmers.two;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PickMineralTest {

  @Test
  void test() {
    Assertions.assertEquals(
        12,
        solution(
            new int[] {1, 3, 2},
            new String[] {
              "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"
            }));
    Assertions.assertEquals(
        50,
        solution(
            new int[] {0, 1, 1},
            new String[] {
              "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron",
              "iron", "diamond"
            }));
  }

  public int solution(int[] picks, String[] minerals) {
    int answer = 0;

    int pickCount = 0;
    for (int pick : picks) {
      pickCount += pick;
    }

    PriorityQueue<List<Integer>> mineralGroupQueue =
        new PriorityQueue<>(
            Comparator.comparingInt(
                    (List<Integer> group) -> group.stream().mapToInt(Integer::intValue).sum())
                .reversed());

    List<Integer> mineralGroup = new ArrayList<>();
    for (int i = 0; i < minerals.length; i++) {
      if (mineralGroupQueue.size() == pickCount) {
        break;
      }

      if (i > 0 && i % 5 == 0) {
        mineralGroupQueue.add(mineralGroup);
        mineralGroup = new ArrayList<>();
      }

      switch (minerals[i]) {
        case "diamond" -> mineralGroup.add(25);
        case "iron" -> mineralGroup.add(5);
        case "stone" -> mineralGroup.add(1);
      }
    }

    if (mineralGroupQueue.size() < pickCount) {
      mineralGroupQueue.add(mineralGroup);
    }

    while (!mineralGroupQueue.isEmpty()) {
      List<Integer> list = mineralGroupQueue.poll();
      for (int i = 0; i < picks.length; i++) {
        if (picks[i] > 0) {
          switch (i) {
            case 0 -> answer += list.size();
            case 1 -> {
              for (Integer integer : list) {
                if (integer == 25) {
                  answer += 5;
                } else {
                  answer += 1;
                }
              }
            }
            case 2 -> {
              for (Integer integer : list) {
                answer += integer;
              }
            }
          }
          picks[i]--;
          break;
        }
      }
    }

    return answer;
  }
}
