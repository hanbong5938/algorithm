import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveMinimumNumberTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{4, 3, 2}, this.solution(new int[]{4, 3, 2, 1}));
        Assertions.assertArrayEquals(new int[]{-1}, this.solution(new int[]{10}));
    }

    public int[] solution(int @NotNull [] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
        }

        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == min) {
                continue;
            }
            answer[index] = arr[i];
            index++;
        }

        return answer;
    }
}
