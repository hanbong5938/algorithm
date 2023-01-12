package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class DivisorCollectTest {

    @Test
    void solution() {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        int[] returnValue = {5, 10};

        LinkedList<Integer> list = new LinkedList<>();
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }

        if(list.isEmpty()){
            Assertions.assertTrue(true);
        }

        int[] answer = list.stream().sorted().mapToInt(a -> a).toArray();

        for(int i = 0; i < returnValue.length; i ++) {
            Assertions.assertEquals(returnValue[i], answer[i]);
        }
    }
}
