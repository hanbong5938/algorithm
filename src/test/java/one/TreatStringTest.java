package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreatStringTest {

    @Test
    void solution() {

        String s = "a234";
        boolean answer = false;
        String temp = s.replaceAll("[A-Za-z]", "");
        int length = s.length();
        if ((s.replaceAll("[A-Za-z]", "").length() == length) && (length == 4 || length == 6)) {
            answer = true;
        }
        Assertions.assertFalse(answer);
    }
}
