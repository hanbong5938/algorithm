package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TwoSumTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7}, solution(new int[]{2, 1, 3, 4, 1}));
        Assertions.assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7}, solution2(new int[]{2, 1, 3, 4, 1}));
        Assertions.assertArrayEquals(new int[]{2, 5, 7, 9, 12}, solution(new int[]{5, 0, 2, 7}));
        Assertions.assertArrayEquals(new int[]{2, 5, 7, 9, 12}, solution2(new int[]{5, 0, 2, 7}));

    }

    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] arr = new int[(length * (length - 1)) / 2];
        int idx = 0;
        for (int i = 0; i < length - 1; i++) {
            int number = numbers[i];
            for (int j = i; j < length; j++) {
                if (i != j) {
                    arr[idx++] = number + numbers[j];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int result = this.getLength(arr);
        int[] answer = new int[result];
        System.arraycopy(arr, 0, answer, 0, result);
        return answer;
    }

    private int getLength(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }

        arr[j++] = arr[arr.length - 1];
        return j;
    }

    public int[] solution2(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(a -> a).toArray();
    }
}
