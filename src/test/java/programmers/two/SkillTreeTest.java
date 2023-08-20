package programmers.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class SkillTreeTest {

    @Test
    void test() {
        Assertions.assertEquals(2, new Solution().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (int i = 0; i < skill_trees.length; i++) {
                boolean isPossible = true;
                Queue<Character> queue = new LinkedList<>();
                for (int j = 0; j < skill.length(); j++) {
                    queue.add(skill.charAt(j));
                }

                String skillTree = skill_trees[i];
                for (int j = 0; j < skillTree.length(); j++) {
                    char c = skillTree.charAt(j);
                    char peek = queue.peek();
                    if (peek == c) {
                        queue.poll();
                    } else if (queue.contains(c)) {
                        isPossible = false;
                        break;
                    }

                    if (queue.isEmpty()) {
                        break;
                    }
                }

                if (isPossible) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
