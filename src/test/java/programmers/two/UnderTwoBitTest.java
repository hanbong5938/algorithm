package programmers.two;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UnderTwoBitTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new long[]{3, 11, 13}, solution(new long[]{2, 7, 11}));
    }


    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        var index = 0;
        for (var number : numbers) {
            if (number % 4 == 3) {
                var binaryString = "0" + Long.toBinaryString(number);
                for (int j = binaryString.length() - 1; j >= 0; j--) {
                    if (binaryString.charAt(j) == '0') {
                        answer[index++] = Long.parseLong(binaryString.substring(0, j) + "10" + binaryString.substring(j + 2), 2);
                        break;
                    }
                }
            } else {
                answer[index++] = number + 1;
            }
        }
        return answer;
    }
}
