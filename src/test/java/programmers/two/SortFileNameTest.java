package programmers.two;

import java.util.Arrays;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortFileNameTest {

  @Test
  void test() {
    Assertions.assertArrayEquals(
        new String[] {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"},
        solution(
            new String[] {
              "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
            }));
    Assertions.assertArrayEquals(
        new String[] {
          "A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"
        },
        solution(
            new String[] {
              "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
            }));
  }

  public String[] solution(String[] files) {
    return Arrays.stream(files)
        .sorted(
            (o1, o2) -> {
              String s1 = o1.split("[0-9]")[0];
              String s2 = o2.split("[0-9]")[0];
              if (s1.compareToIgnoreCase(s2) != 0) {
                return s1.compareToIgnoreCase(s2);
              }

              String n1 = o1.substring(s1.length()).split("[^0-9]")[0];
              String n2 = o2.substring(s2.length()).split("[^0-9]")[0];
              if (Objects.equals("", n1) || Objects.equals("", n2)) {
                return 0;
              }
              return Integer.compare(Integer.parseInt(n1), Integer.parseInt(n2));
            })
        .map(String::valueOf)
        .toArray(String[]::new);
  }
}
