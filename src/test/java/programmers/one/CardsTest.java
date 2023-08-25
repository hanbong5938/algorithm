package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardsTest {

  @Test
  void test() {
    Assertions.assertEquals(
        "Yes",
        solution(
            new String[] {"i", "drink", "water"},
            new String[] {"want", "to"},
            new String[] {"i", "want", "to", "drink", "water"}));
    Assertions.assertEquals(
        "No",
        solution(
            new String[] {"i", "water", "drink"},
            new String[] {"want", "to"},
            new String[] {"i", "want", "to", "drink", "water"}));
  }

  public String solution(String[] cards1, String[] cards2, String[] goal) {
    int card1Index = 0;
    int card2Index = 0;
    int goalIndex = 0;

    while (goalIndex < goal.length) {
      if (card1Index < cards1.length && goal[goalIndex].equals(cards1[card1Index])) {
        card1Index++;
      } else if (card2Index < cards2.length && goal[goalIndex].equals(cards2[card2Index])) {
        card2Index++;
      } else {
        return "No";
      }
      goalIndex++;
    }
    return "Yes";
  }
}
