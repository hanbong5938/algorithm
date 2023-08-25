package programmers.two;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CacheTest {

  @Test
  void test() {
    Assertions.assertEquals(
        50,
        solution(
            3,
            new String[] {
              "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
            }));
    Assertions.assertEquals(
        21,
        solution(
            3,
            new String[] {
              "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
            }));
    Assertions.assertEquals(
        60,
        solution(
            2,
            new String[] {
              "Jeju",
              "Pangyo",
              "Seoul",
              "NewYork",
              "LA",
              "SanFrancisco",
              "Seoul",
              "Rome",
              "Paris",
              "Jeju",
              "NewYork",
              "Rome"
            }));
    Assertions.assertEquals(
        52,
        solution(
            5,
            new String[] {
              "Jeju",
              "Pangyo",
              "Seoul",
              "NewYork",
              "LA",
              "SanFrancisco",
              "Seoul",
              "Rome",
              "Paris",
              "Jeju",
              "NewYork",
              "Rome"
            }));
    Assertions.assertEquals(16, solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
    Assertions.assertEquals(
        25, solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
  }

  public int solution(int cacheSize, String[] cities) {
    int answer = 0;
    List<String> list = new LinkedList<>();
    for (String city : cities) {
      String lowerCity = city.toLowerCase();
      if (list.contains(lowerCity)) {
        answer += 1;
        list.remove(lowerCity);
        list.add(lowerCity);
      } else if (list.size() < cacheSize) {
        answer += 5;
        list.add(lowerCity);
      } else {
        answer += 5;
        if (cacheSize > 0) {
          list.remove(0);
          list.add(lowerCity);
        }
      }
    }
    return answer;
  }

  public int solution2(int cacheSize, String[] cities) {
    int answer = 0;
    if (cacheSize == 0) return cities.length * 5;

    LinkedHashMap<String, Integer> map =
        new LinkedHashMap<>(cacheSize, 0.75f, true) {
          protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > cacheSize;
          }
        };

    for (String city : cities) {
      String lowerCity = city.toLowerCase();
      if (map.containsKey(lowerCity)) {
        answer += 1;
      } else {
        answer += 5;
      }
      map.put(lowerCity, 0);
    }
    return answer;
  }
}
