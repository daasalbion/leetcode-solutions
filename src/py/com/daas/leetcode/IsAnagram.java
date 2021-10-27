package py.com.daas.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

  public static void main(String[] args) {
    IsAnagram twoSum = new IsAnagram();
    System.out.println("isAnagram = " + twoSum.isAnagram("anagram", "nagaram"));
    System.out.println("isAnagram = " + twoSum.isAnagram("rat", "car"));
  }

  public HashMap<Character, Integer> string2HashMap(String str) {
    HashMap<Character, Integer> sHashMap = new HashMap<>();
    for (char cS: str.toCharArray()) {
      if(sHashMap.containsKey(cS)) {
        sHashMap.put(cS, sHashMap.get(cS) + 1);
      } else {
        sHashMap.put(cS, 1);
      }
    }
    return sHashMap;
  }

  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) return false;

    HashMap<Character, Integer> sHashMap = string2HashMap(s);
    HashMap<Character, Integer> tHashMap = string2HashMap(t);

    for (Map.Entry<Character, Integer> entry: sHashMap.entrySet()) {
      if(!(tHashMap.containsKey(entry.getKey()) && tHashMap.get(entry.getKey()).equals(entry.getValue()))) {
        return false;
      }
    }

    return true;
  }


}
