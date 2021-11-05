package py.com.daas.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

  public static void main(String[] args) {
    LongestSubstringWithoutRepeating twoSum = new LongestSubstringWithoutRepeating();
    System.out.println("isValid = " + twoSum.characterReplacement("abcabcbb"));
  }

  public int characterReplacement(String s) {
    if (s == null || s.equals("")) return 0;

    int start = 0;
    int max = 0;
    // space O(n) worst case
    HashMap<Character, Integer> map = new HashMap<>();
    // time O(n) worst case
    for (int end = 0; end < s.length(); end++) {
      if (map.containsKey(s.charAt(end))) {
        start = Math.max(start, map.get(s.charAt(end)) + 1);
      }
      max = Math.max(max, end - start + 1);
      map.put(s.charAt(end), end);
    }

    return max;
  }

}
