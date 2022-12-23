package one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BabblingTest {

    //    "aya", "ye", "woo", "ma" 연속해서 같은 발음을 하는 것을 어려워합니다.
//    문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
//
//    제한사항
//1 ≤ babbling의 길이 ≤ 100
//            1 ≤ babbling[i]의 길이 ≤ 30
//    문자열은 알파벳 소문자로만 이루어져 있습니다.
//            입출력 예
//    babbling	result
//["aya", "yee", "u", "maa"]	1
//        ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	2
//    입출력 예 설명
//    입출력 예 #1
//
//            ["aya", "yee", "u", "maa"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.
//    입출력 예 #2
//
//            ["ayaye", "uuuma", "yeye", "yemawoo", "ayaayaa"]에서 발음할 수 있는 것은 "aya" + "ye" = "ayaye", "ye" + "ma" + "woo" = "yemawoo"로 2개입니다. "yeye"는 같은 발음이 연속되므로 발음할 수 없습니다. 따라서 2를 return합니다.
//    유의사항
//    네 가지를 붙여 만들 수 있는 발음 이외에는 어떤 발음도 할 수 없는 것으로 규정합니다. 예를 들어 "woowo"는 "woo"는 발음할 수 있지만 "wo"를 발음할 수 없기 때문에 할 수 없는 발음입니다.
    @Test
    void test() {
        Assertions.assertEquals(1, solution(new String[]{"aya", "yee", "u", "maa"}));
        Assertions.assertEquals(2, solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
        Assertions.assertEquals(1, solution(new String[]{"ayayeayaayaa", "ayayeaya"}));
    }

    public int solution(String[] babbling) {
        String[] arr = new String[]{"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String word : babbling) {
            for (String str : arr) {
                if (word.contains(str + str)) {
                    break;
                }
                word = word.replaceAll(str, " ");

                if (word.isBlank()) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
