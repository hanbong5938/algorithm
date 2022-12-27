package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StringNumWordTest {

    @Test
    void test() {
        Assertions.assertEquals(1478, solution("one4seveneight"));
        Assertions.assertEquals(234567, solution("23four5six7"));
        Assertions.assertEquals(10203, solution("1zerotwozero3"));
    }

    public int solution(String s) {
        return Integer.parseInt(
                s.replace("zero", "0")
                        .replace("one", "1")
                        .replace("two", "2")
                        .replace("three", "3")
                        .replace("four", "4")
                        .replace("five", "5")
                        .replace("six", "6")
                        .replace("seven", "7")
                        .replace("eight", "8")
                        .replace("nine", "9"));
    }
}
