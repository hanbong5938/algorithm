package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicTackToTest {
  @Test
  void test() {
    Assertions.assertEquals(1, solution(new String[] {"O.X", ".O.", "..X"}));
    Assertions.assertEquals(0, solution(new String[] {"OOO", "...", "XXX"}));
    Assertions.assertEquals(0, solution(new String[] {"...", ".X.", "..."}));
    Assertions.assertEquals(1, solution(new String[] {"...", "...", "..."}));
    Assertions.assertEquals(0, solution(new String[] {"OO.", "...", "..."}));
    Assertions.assertEquals(1, solution(new String[] {"XO.", "OXO", "XOX"}));
    Assertions.assertEquals(1, solution(new String[] {"OOO", "XOX", "XXO"}));
    Assertions.assertEquals(0, solution(new String[] {"XXX", "...", "OOO"}));
  }

  public int solution(String[] board) {

    int countO = 0;
    int countX = 0;
    boolean xWin = false;
    boolean oWin = false;

    // 3x3 게임판 검사
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        boolean isO = false;
        char c = board[y].charAt(x);

        if (c == 'O') {
          countO++;
          isO = true;
        } else if (c == 'X') {
          countX++;
        } else {
          continue;
        }

        if (x == y) {
          if (c == board[y].charAt((x + 1) % 3) && c == board[y].charAt((x + 2) % 3)) {
            if (isO) {
              oWin = true;
            } else {
              xWin = true;
            }
          }

          if (c == board[(y + 1) % 3].charAt(x) && c == board[(y + 2) % 3].charAt(x)) {
            if (isO) {
              oWin = true;
            } else {
              xWin = true;
            }
          }
        }

        if (x == 1 && y == 1) {
          if (c == board[0].charAt(0) && c == board[2].charAt(2)) {
            if (isO) {
              oWin = true;
            } else {
              xWin = true;
            }
          }

          if (c == board[0].charAt(2) && c == board[2].charAt(0)) {
            if (isO) {
              oWin = true;
            } else {
              xWin = true;
            }
          }
        }
      }
    }

    int temp = countO - countX;
    if ((xWin && oWin)
        || (xWin && countX != countO)
        || (oWin && temp != 1)
        || ((temp != 1) && (temp != 0))) {
      return 0;
    }

    return 1;
  }
}
