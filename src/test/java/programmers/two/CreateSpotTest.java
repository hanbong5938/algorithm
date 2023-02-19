
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class CreateSpotTest {

    @Test
    void test() {
        Assertions.assertEquals(6, solution(2, 4));
        Assertions.assertEquals(26, solution(1, 5));
    }

    public long solution(int k, int d) {
        long answer = 0;
        long dd = (long) d * d;
        for (int i = 0; i <= d; i += k) {
            long xx = (long) i * i;
            long yy = dd - xx;
            int y = (int) Math.sqrt(yy);
            answer += (y / k) + 1;
        }
        return answer;
    }
}
