package programmers.two;

import java.util.*;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuRenewalTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(
        new String[] {"AC", "ACDE", "BCFG", "CDE"},
        solution(
            new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2, 3, 4}));
    Assertions.assertArrayEquals(
        new String[] {"ACD", "AD", "ADE", "CD", "XYZ"},
        solution(
            new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2, 3, 5}));
    Assertions.assertArrayEquals(
        new String[] {"WX", "XY"},
        solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2, 3, 4}));
  }

  public String[] solution(String[] orders, int[] course) {
    Map<String, Integer> map = new HashMap<>();

    for (String order : orders) {
      char[] chars = order.toCharArray();
      Arrays.sort(chars);
      dfs(chars, 0, "", course, map);
    }

    int[] max = new int[course.length];
    map.forEach(
        (key, value) -> {
          for (int i = 0; i < course.length; i++) {
            if (key.length() == course[i] && value > 1) {
              max[i] = Math.max(max[i], value);
            }
          }
        });
    List<String> list = new ArrayList<>();
    map.forEach(
        (key, value) -> {
          for (int i = 0; i < course.length; i++) {
            if (key.length() == course[i] && max[i] == value) {
              list.add(key);
            }
          }
        });
    Collections.sort(list);

    return list.toArray(new String[0]);
  }

  private void dfs(
      final char[] chars,
      final int start,
      final String str,
      final int[] course,
      final Map<String, Integer> map) {
    for (int i = start; i < chars.length; i++) {
      String temp = str + chars[i];
      for (int k : course) {
        if (temp.length() == k) {
          map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
      }
      dfs(chars, i + 1, temp, course, map);
    }
  }
}
