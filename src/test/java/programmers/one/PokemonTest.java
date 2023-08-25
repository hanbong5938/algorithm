package programmers.one;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PokemonTest {

  @Test
  void solution() {
    int[] nums = {3, 1, 2, 3};
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    Assertions.assertSame(2, Math.min(set.size(), (nums.length / 2)));
  }
}
