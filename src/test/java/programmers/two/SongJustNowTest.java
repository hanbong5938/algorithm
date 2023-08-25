package programmers.two;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SongJustNowTest {

  @Test
  void test() {
    Assertions.assertEquals(
        "HELLO",
        solution(
            "ABCDEFG", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    Assertions.assertEquals(
        "FOO",
        solution(
            "CC#BCC#BCC#BCC#B",
            new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
    Assertions.assertEquals(
        "WORLD",
        solution("ABC", new String[] {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
  }

  public String solution(String m, String[] musicinfos) {
    Comparator<MusicInfo> comparator =
        (p1, p2) -> {
          int firstComparison = Integer.compare(p2.getRunTime(), p1.getRunTime());
          if (firstComparison != 0) {
            return firstComparison;
          } else {
            return Integer.compare(p1.getMusicStartTime(), p2.getMusicStartTime());
          }
        };

    PriorityQueue<MusicInfo> playMusicList = new PriorityQueue<>(comparator);
    String replacement = replace(m);

    for (var musicInfo : musicinfos) {
      MusicInfo music = new MusicInfo(musicInfo);
      if (music.getPlayMelody().contains(replacement)) {
        playMusicList.add(music);
      }
    }

    return playMusicList.isEmpty() ? "(None)": playMusicList.peek().getMusicTitle();
  }

  private static String replace(final String m) {
    Map<String, String> noteMap = Map.of("C#", "H", "D#", "I", "F#", "J", "G#", "K", "A#", "L");
    String pattern = "(C#|D#|F#|G#|A#)";
    Pattern regexPattern = Pattern.compile(pattern);
    Matcher matcher = regexPattern.matcher(m);
    StringBuffer outputStringBuffer = new StringBuffer();
    while (matcher.find()) {
      String replacement = noteMap.get(matcher.group());
      matcher.appendReplacement(outputStringBuffer, replacement);
    }
    matcher.appendTail(outputStringBuffer);
    return outputStringBuffer.toString();
  }

  private static class MusicInfo {
    private String musicStartTime;
    private String musicEndTime;
    private String musicTitle;
    private String musicMelody;
    private int runTime;

    public MusicInfo(final String musicInfo) {
      String[] musicInfoArray = musicInfo.split(",");

      this.musicStartTime = musicInfoArray[0];
      this.musicEndTime = musicInfoArray[1];
      this.musicTitle = musicInfoArray[2];
      this.musicMelody = replace(musicInfoArray[3]);
      this.runTime =
          60
                  * (Integer.parseInt(musicEndTime.split(":")[0])
                      - Integer.parseInt(musicStartTime.split(":")[0]))
              + (Integer.parseInt(musicEndTime.split(":")[1])
                  - Integer.parseInt(musicStartTime.split(":")[1]));
    }

    public int getMusicStartTime() {
      return 60
          * (Integer.parseInt(musicEndTime.split(":")[0])
              + Integer.parseInt(musicStartTime.split(":")[1]));
    }

    public String getMusicTitle() {
      return musicTitle;
    }

    public int getRunTime() {
      return runTime;
    }

    public String getPlayMelody() {
      StringBuilder sb = new StringBuilder();
      int musicMelodyLength = musicMelody.length();
      int runTime = this.runTime;
      int index = 0;
      while (runTime > 0) {
        sb.append(musicMelody.charAt(index));
        index++;
        if (index == musicMelodyLength) {
          index = 0;
        }
        runTime--;
      }
      return sb.toString();
    }
  }
}
