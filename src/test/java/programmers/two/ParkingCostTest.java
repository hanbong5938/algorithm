package programmers.two;

import java.time.LocalTime;
import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingCostTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(
        new int[] {14600, 34400, 5000},
        solution(
            new int[] {180, 5000, 10, 600},
            new String[] {
              "05:34 5961 IN",
              "06:00 0000 IN",
              "06:34 0000 OUT",
              "07:59 5961 OUT",
              "07:59 0148 IN",
              "18:59 0000 IN",
              "19:09 0148 OUT",
              "22:59 5961 IN",
              "23:00 5961 OUT"
            }));
    Assertions.assertArrayEquals(
        new int[] {0, 591},
        solution(
            new int[] {120, 0, 60, 591},
            new String[] {
              "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"
            }));
    Assertions.assertArrayEquals(
        new int[] {14841}, solution(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"}));
  }

  public int[] solution(int[] fees, String[] records) {
    int baseMin = fees[0];
    int baseFee = fees[1];
    int unitMin = fees[2];
    int unitFee = fees[3];

    Map<String, LocalTime> parking = new HashMap<>();
    Map<String, Integer> parkingTime = new TreeMap<>();

    for (String record : records) {
      String[] split = record.split(" ");
      LocalTime time = LocalTime.parse(split[0]);
      String carNumber = split[1];
      String inOut = split[2];

      if (inOut.equals("IN")) {
        parking.put(carNumber, time);
      } else {
        LocalTime inTime = parking.get(carNumber);
        parking.remove(carNumber);
        int minutes =
            (time.getHour() * 60 + time.getMinute()) - (inTime.getHour() * 60 + inTime.getMinute());
        parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + minutes);
      }
    }

    for (String carNumber : parking.keySet()) {
      LocalTime inTime = parking.get(carNumber);
      int min = (23 * 60 + 59) - (inTime.getHour() * 60 + inTime.getMinute());
      parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + min);
    }

    int[] answer = new int[parkingTime.size()];
    int index = 0;
    for (String carNumber : parkingTime.keySet()) {
      int min = parkingTime.get(carNumber) - baseMin;
      int calcMin = min / unitMin;
      int ceilMin = min % unitMin == 0 ? calcMin : calcMin + 1;
      int fee = (int) (baseFee + (min >= 0 ? ceilMin * unitFee : 0));
      answer[index++] = fee;
    }
    return answer;
  }
}
