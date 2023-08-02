package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

class HotelBookingTest {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        Assertions.assertEquals(1, solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
        Assertions.assertEquals(3, solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
        Assertions.assertEquals(2, solution(new String[][]{{"08:00", "08:30"}, {"08:00", "13:00"}, {"12:30", "13:30"}}));
        Assertions.assertEquals(2, solution(new String[][]{{"23:00", "23:51"}, {"23:50", "23:59"}}));
    }


    public int solution(String[][] book_time) {
        int answer = 0;

        int[][] bookTime = new int[book_time.length][];
        for (int i = 0; i < book_time.length; i++) {
            bookTime[i] = new int[]{parseTime(book_time[i][0]), parseTime(book_time[i][1]) + 10};
        }

        Arrays.sort(bookTime, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> inUse = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < bookTime.length; i++) {

            while (!inUse.isEmpty() && inUse.peek()[1] <= bookTime[i][0]) {
                inUse.poll();
            }

            inUse.add(bookTime[i]);
            answer = Math.max(answer, inUse.size());
        }
        return answer;
    }

    protected int parseTime(String time) {
        String[] hhmm = time.split(":");
        int hour = Integer.parseInt(hhmm[0]), min = Integer.parseInt(hhmm[1]);
        return hour * 60 + min;
    }
}
