package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmoticonDiscountTest {
  // 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
  // 2. 이모티콘 판매액을 최대한 늘리는 것.

  private static final int[] DISCOUNT = {10, 20, 30, 40};
  private static int EMOTICON_PLUS = 0;
  private static int TOTAL_SALES = 0;

  @Test
  void test() {
    Assertions.assertArrayEquals(
        new int[] {1, 5400},
        solution(new int[][] {{40, 10000}, {25, 10000}}, new int[] {7000, 9000}));
    Assertions.assertArrayEquals(
        new int[] {4, 13860},
        solution(
            new int[][] {
              {40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}
            },
            new int[] {1300, 1500, 1600, 4900}));
  }

  public int[] solution(int[][] users, int[] emoticons) {
    getPrices(emoticons, users, 0, new int[emoticons.length]);
    return new int[] {EMOTICON_PLUS, TOTAL_SALES};
  }

  private void getPrices(int[] emoticons, int[][] users, int cur, int[] discounts) {
    if (cur == emoticons.length) {
      updateAnswer(emoticons, users, discounts);
      return;
    }

    for (int discount : DISCOUNT) {
      discounts[cur] = discount;
      getPrices(emoticons, users, cur + 1, discounts);
    }
  }

  private void updateAnswer(int[] emoticons, int[][] users, int[] discount) {

    int emoticonPlus = 0;
    int totalExpense = 0;

    for (int[] user : users) {
      int expense = 0;
      int rate = user[0];
      int price = user[1];
      for (int i = 0; i < discount.length; i++) {
        if (discount[i] >= rate) {
          expense += emoticons[i] * (100 - discount[i]) / 100;
        }
        if (expense >= price) {
          emoticonPlus += 1;
          expense = 0;
          break;
        }
      }
      totalExpense += expense;
    }

    if (emoticonPlus > EMOTICON_PLUS) {
      EMOTICON_PLUS = emoticonPlus;
      TOTAL_SALES = totalExpense;
    } else if (emoticonPlus == EMOTICON_PLUS) {
      TOTAL_SALES = Math.max(totalExpense, TOTAL_SALES);
    }
  }
}
