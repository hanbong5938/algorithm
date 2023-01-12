package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DartGameTest {

    @Test
    void test() {
        Assertions.assertEquals(37, solution("1S2D*3T"));
        Assertions.assertEquals(9, solution("1D2S#10S"));
        Assertions.assertEquals(3, solution("1D2S0T"));
        Assertions.assertEquals(23, solution("1S*2T*3S"));
        Assertions.assertEquals(5, solution("1D#2S*3S"));
        Assertions.assertEquals(-4, solution("1T2D3D#"));
        Assertions.assertEquals(59, solution("1D2S3T*"));
    }

    public int solution(String dartResult) {
        int[] score = new int[3];
        char[] array = dartResult.toCharArray();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (array.length > i + 1 && Character.isDigit(c) && Character.isDigit(array[i + 1])) {
                score[index++] = 10;
                i++;
            } else if (Character.isDigit(c)) {
                score[index++] = Integer.parseInt(String.valueOf(c));
            } else if (c == 'S' || c == 'D' || c == 'T') {
                int num = score[index - 1];
                if (c == 'D') {
                    score[index - 1] = (int) Math.pow(num, 2);
                } else if (c == 'T') {
                    score[index - 1] = (int) Math.pow(num, 3);
                }
            } else {
                if (c == '*') {
                    if (index > 1) {
                        score[index - 2] *= 2;
                    }
                    score[index - 1] *= 2;
                } else {
                    score[index - 1] *= -1;
                }
            }
        }
        return score[0] + score[1] + score[2];
    }
}
