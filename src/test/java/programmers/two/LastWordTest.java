
package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class LastWordTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{3, 3}, solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
        Assertions.assertArrayEquals(new int[]{0, 0}, solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}));
        Assertions.assertArrayEquals(new int[]{1, 3}, solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}));
    }

    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char c = words[0].charAt(0);
        for (String s : words) {
            int size = set.size();
            if (c != s.charAt(0)) {
                return getInts(n, size);
            }
            set.add(s);
            if (size == set.size()) {
                return getInts(n, set.size());
            }
            c = s.charAt(s.length() - 1);
        }
        return new int[]{0, 0};
    }

    private int[] getInts(int n, int size) {
        return new int[]{size % n + 1, size / n + 1};
    }

}
