package programmers.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MbtiTest {

  @Test
  void test() {
    Assertions.assertEquals(
        "TCMA", solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5}));
    Assertions.assertEquals("RCJA", solution(new String[] {"TR", "RT", "TR"}, new int[] {7, 1, 3}));
  }

  public String solution(String[] survey, int[] choices) {
    StringBuilder answer = new StringBuilder();
    int[] score = new int[4];
    for (int i = 0, surveyLength = survey.length; i < surveyLength; i++) {
      String current = reverse(survey[i]);
      int choice = current.equals(survey[i]) ? choices[i] - 4 : 4 - choices[i];
      score[getSurveyIndex(current)] += choice;
    }

    for (int i = 0; i < score.length; i++) {
      int num = score[i];
      if (num >= 0) {
        answer.append(getSurvey(i).charAt(1));
      } else {
        answer.append(getSurvey(i).charAt(0));
      }
    }

    return answer.toString();
  }

  private String reverse(String s) {
    return switch (s) {
      case "RT" -> "TR";
      case "CF" -> "FC";
      case "JM" -> "MJ";
      case "AN" -> "NA";
      default -> s;
    };
  }

  private int getSurveyIndex(String current) {
    return switch (current) {
      case "TR" -> 0;
      case "FC" -> 1;
      case "MJ" -> 2;
      case "NA" -> 3;
      default -> -1;
    };
  }

  private String getSurvey(int current) {
    return switch (current) {
      case 0 -> "TR";
      case 1 -> "FC";
      case 2 -> "MJ";
      case 3 -> "NA";
      default -> "";
    };
  }
}
