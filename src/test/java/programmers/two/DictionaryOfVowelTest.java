package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DictionaryOfVowelTest {

  @Test
  void test() {
    Assertions.assertEquals(6, solution("AAAAE"));
    Assertions.assertEquals(10, solution("AAAE"));
    Assertions.assertEquals(1563, solution("I"));
    Assertions.assertEquals(1189, solution("EIO"));
  }

  //  'A', 'E', 'I', 'O', 'U'

  public int solution(String word) {
    int answer = 0;
    StringBuilder stringBuilder = new StringBuilder();
    while (!word.equals(stringBuilder.toString())) {
      if (stringBuilder.isEmpty() || stringBuilder.length() < 5) {
        stringBuilder.append('A');
      } else {
        if (stringBuilder.length() == 5) {
          if (getLast(stringBuilder) != 'U') {
            stringBuilder.append(getNext(deleteLast(stringBuilder)));
            answer++;
            continue;
          }
          while ('U' == getLast(stringBuilder)) {
            deleteLast(stringBuilder);
          }
          stringBuilder.append(getNext(deleteLast(stringBuilder)));
          answer++;
          continue;
        }
        stringBuilder.append(getNext(getLast(stringBuilder)));
      }
      answer++;
    }
    return answer;
  }

  private char getLast(StringBuilder stringBuilder) {
    return stringBuilder.charAt(stringBuilder.length() - 1);
  }

  private char deleteLast(StringBuilder stringBuilder) {
    char c = stringBuilder.charAt(stringBuilder.length() - 1);
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    return c;
  }

  private char getNext(char c) {
    return switch (c) {
      case 'A' -> 'E';
      case 'E' -> 'I';
      case 'I' -> 'O';
      case 'O' -> 'U';
      case 'U' -> 'A';
      default -> throw new IllegalStateException("Unexpected value: " + c);
    };
  }
}
