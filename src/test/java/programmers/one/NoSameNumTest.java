package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.stream.IntStream;

class NoSameNumTest {

    @Test
    void solution() {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : arr) {
            if (list.isEmpty()) {
                list.add(num);
                continue;
            }

            if (num != list.getLast()) {
                list.add(num);
            }
        }

        int[] collect = {1, 3, 0, 1};
        int[] answer = list.stream().mapToInt(a -> a).toArray();
        IntStream.range(0, collect.length).forEach(i -> Assertions.assertSame(collect[i], answer[i]));
    }
}
