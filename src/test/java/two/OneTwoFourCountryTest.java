
package two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class OneTwoFourCountryTest {

    @Test
    void test() {
        Assertions.assertEquals("1", solution(1));
        Assertions.assertEquals("2", solution(2));
        Assertions.assertEquals("4", solution(3));
        Assertions.assertEquals("11", solution(4));
        Assertions.assertEquals("12", solution(5));
        Assertions.assertEquals("14", solution(6));
        Assertions.assertEquals("21", solution(7));
        Assertions.assertEquals("22", solution(8));
        Assertions.assertEquals("24", solution(9));
        Assertions.assertEquals("41", solution(10));
        Assertions.assertEquals("42", solution(11));
        Assertions.assertEquals("44", solution(12));
        Assertions.assertEquals("111", solution(13));
        Assertions.assertEquals("112", solution(14));
        Assertions.assertEquals("114", solution(15));
        Assertions.assertEquals("121", solution(16));
        Assertions.assertEquals("122", solution(17));
        Assertions.assertEquals("124", solution(18));
        Assertions.assertEquals("141", solution(19));
        Assertions.assertEquals("142", solution(20));
        Assertions.assertEquals("144", solution(21));
        Assertions.assertEquals("211", solution(22));
        Assertions.assertEquals("212", solution(23));
        Assertions.assertEquals("214", solution(24));
        Assertions.assertEquals("221", solution(25));
        Assertions.assertEquals("222", solution(26));
        Assertions.assertEquals("224", solution(27));
        Assertions.assertEquals("241", solution(28));
        Assertions.assertEquals("242", solution(29));
        Assertions.assertEquals("244", solution(30));
        Assertions.assertEquals("411", solution(31));
        Assertions.assertEquals("412", solution(32));
        Assertions.assertEquals("414", solution(33));
        Assertions.assertEquals("421", solution(34));
        Assertions.assertEquals("422", solution(35));
        Assertions.assertEquals("424", solution(36));
        Assertions.assertEquals("441", solution(37));
        Assertions.assertEquals("442", solution(38));
        Assertions.assertEquals("444", solution(39));
        Assertions.assertEquals("1111", solution(40));
    }


    public String solution(int n) {
        String[] num = {"4","1","2"};
        StringBuilder answer = new StringBuilder();

        while(n > 0){
            answer.insert(0, num[n % 3]);
            n = (n - 1) / 3;
        }
        return answer.toString();
    }
}
