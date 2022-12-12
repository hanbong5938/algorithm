import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

class Ponketmon {

    @Test
    void solution() {
        int[] nums = {3,1,2,3};
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        Assertions.assertSame(2, Math.min(set.size(), (nums.length / 2)));
    }
}
