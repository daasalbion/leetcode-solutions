package py.com.daas.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

  public static void main(String[] args) {
    LongestRepeatingCharacterReplacement twoSum = new LongestRepeatingCharacterReplacement();
    //System.out.println("isValid = " + twoSum.characterReplacement("ABAB", 2));
    System.out.println("isValid = " + twoSum.characterReplacement("AABABBA", 1));
  }

  public int characterReplacement(String s, int k) {
    int start = 0;
    int maxLength = 0;
    int longChartCount = 0;
    HashMap<Character, Integer> hashMap = new HashMap<>();
    for (int end = 0; end < s.length(); end++) {
      char character = s.charAt(end);
      hashMap.put(character, hashMap.getOrDefault(character, 0) + 1);
      longChartCount = Math.max(longChartCount, hashMap.get(character));
      if (end - start + 1 - longChartCount > k) {
        char startChar = s.charAt(start);
        hashMap.put(startChar, hashMap.getOrDefault(startChar, 0) - 1);
        start++;
      }

      maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
  }

}
