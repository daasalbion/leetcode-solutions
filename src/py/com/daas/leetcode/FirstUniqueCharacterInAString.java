package py.com.daas.leetcode;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {

    /*
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     */
    public static void main(String[] args) {
        FirstUniqueCharacterInAString exercise = new FirstUniqueCharacterInAString();
        System.out.println(exercise.firstUniqChar("leetcode"));
        System.out.println(exercise.firstUniqChar("loveleetcode"));
        System.out.println(exercise.firstUniqChar("aabb"));
        System.out.println(exercise.firstUniqChar("aadadaad"));
    }

    public int firstUniqChar(String s) {
        /*
        save all the characters in a HashMap
        filter the one that has just 1 as value and return
         */
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                hashMap.put(c, hashMap.get(c) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (hashMap.containsKey(c) && hashMap.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }
}
