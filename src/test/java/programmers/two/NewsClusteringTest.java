
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class NewsClusteringTest {

    @Test
    void test() {
        Assertions.assertEquals(16384, solution("FRANCE", "french"));
        Assertions.assertEquals(65536, solution("handshake", "shake hands"));
        Assertions.assertEquals(43690, solution("aa1+aa2", "AAAA12"));
        Assertions.assertEquals(65536, solution("E=M*C^2", "e=m*c^2"));
    }

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        insert(str1, set1);
        insert(str2, set2);
        if (set1.isEmpty() && set2.isEmpty()) {
            return 65536;
        }

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        set1.retainAll(set2);
        int intersectionSize = set1.size();
        int unionSize = union.size();

        return (int) ((double) intersectionSize / unionSize * 65536);
    }

    private void insert(String str, Set<String> set) {
        int n = str.length();
        for (int i = 0; i < n - 1; i++) {
            String s = str.substring(i, i + 2);
            if (s.matches("[a-z]{2}")) {
                set.add(s);
            }
        }
    }

}
