package py.com.daas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public static void main(String[] args) {
    GroupAnagrams twoSum = new GroupAnagrams();
    System.out.println("groupAnagrams = " + twoSum.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    HashMap<String, List<String>> hashMap = new HashMap<>();
    for (String str: strs) {
      char[] characters = str.toCharArray();
      Arrays.sort(characters);
      String key = new String(characters);
      List<String> list;
      if(hashMap.containsKey(key)) {
        list = hashMap.get(key);
      } else {
        list = new ArrayList<>();
      }
      list.add(str);
      hashMap.put(key, list);
    }
    for(Map.Entry<String, List<String>> entry: hashMap.entrySet()) {
      result.add(entry.getValue());
    }
    return result;
  }

}
