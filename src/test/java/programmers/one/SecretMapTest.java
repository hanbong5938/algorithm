package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SecretMapTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new String[]{"#####", "# # #", "### #", "#  ##", "#####"},
                solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));
        Assertions.assertArrayEquals(new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "},
                solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10}));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String bi = Integer.toBinaryString(arr1[i] | arr2[i]);
            bi = "0".repeat(n - bi.length()) + bi;
            answer[i] = bi.replace("1", "#").replace("0", " ");
        }
        return answer;
    }
}
