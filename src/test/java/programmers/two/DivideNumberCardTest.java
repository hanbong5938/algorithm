package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideNumberCardTest {

    //1 ≤ arrayA의 길이 = arrayB의 길이 ≤ 500,000
    //1 ≤ arrayA의 원소, arrayB의 원소 ≤ 100,000,000

    @Test
    void test() {
        assertEquals(0, solution(new int[]{10, 17}, new int[]{5, 20}));
        assertEquals(10, solution(new int[]{10, 20}, new int[]{5, 17}));
        assertEquals(7, solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
        assertEquals(8, solution(new int[]{5}, new int[]{8}));
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int length = arrayA.length;
        int a = length == 1 ? arrayA[0] : getGCD(arrayA[0], arrayA[1]);
        int b = length == 1 ? arrayB[0] : getGCD(arrayB[0], arrayB[1]);
        for (int i = 2; i < length; i++) {
            a = getGCD(a, arrayA[i]);
            b = getGCD(b, arrayB[i]);
        }

        boolean canDivideA = false;
        boolean canDivideB = false;
        for (int i = 0; i < length; i++) {
            if (arrayB[i] % a == 0) {
                canDivideB = true;
            }
            if (arrayA[i] % b == 0) {
                canDivideA = true;
            }
        }

        if (canDivideA && canDivideB) {
            return 0;
        } else if (canDivideA) {
            return a;
        } else if (canDivideB) {
            return b;
        } else {
            return Math.max(a, b);
        }
    }

    private int getGCD(int a, int b) {
        int temp = a % b;
        while (temp != 0) {
            a = b;
            b = temp;
            temp = a % b;
        }
        return b;
    }
}
