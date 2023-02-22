package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ExpiredInfoTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1, 3}, solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));
        Assertions.assertArrayEquals(new int[]{1, 4, 5}, solution("2020.01.01", new String[]{"Z 3", "D 5"},
                new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}));
    }

    // A => 6
    // B => 12
    // C => 3
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        String[] todaySplit = today.split("\\.");
        int todayNum = monthToDay(yearToMonth(Integer.parseInt(todaySplit[0])))
                + monthToDay(Integer.parseInt(todaySplit[1])) + Integer.parseInt(todaySplit[2]);
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] split = privacy.split(" ");
            String[] date = split[0].split("\\.");
            int term = monthToDay(termMap.get(split[1]));
            int dateNum = monthToDay(yearToMonth(Integer.parseInt(date[0])))
                    + monthToDay(Integer.parseInt(date[1])) + Integer.parseInt(date[2]);
            if (todayNum - dateNum >= term) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


    private int yearToMonth(int year) {
        return year * 12;
    }

    private int monthToDay(int month) {
        return month * 28;
    }
}
