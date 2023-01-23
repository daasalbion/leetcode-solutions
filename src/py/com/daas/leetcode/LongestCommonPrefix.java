package py.com.daas.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix twoSum = new LongestCommonPrefix();
        System.out.println("longestCommonPrefix = " + twoSum.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("longestCommonPrefix = " + twoSum.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println("longestCommonPrefix = " + twoSum.longestCommonPrefix(new String[]{"a"}));
    }

    /*
        1 <= strs.length <= 200
        0 <= strs[i].length <= 200
        strs[i] consists of only lowercase English letters.
    */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs, Comparator.comparingInt(String::length));
        String longestPrefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String currentPrefix = compareStrings(longestPrefix, strs[i]);
            if (currentPrefix.length() < longestPrefix.length()) {
                longestPrefix = currentPrefix;
            }
        }

        return longestPrefix;
    }

    private String compareStrings(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                result.append(str1.charAt(i));
            } else {
                break;
            }
        }

        return result.toString();
    }

}
