package py.com.daas.leetcode;

import static py.com.daas.leetcode.BaseExercise.logResult;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome twoSum = new LongestPalindrome();
        logResult("LongestPalindrome", twoSum.longestPalindrome("cbbd"));
        logResult("LongestPalindrome", twoSum.bruteForce("cbbd"));
        logResult("LongestPalindrome", twoSum.longestPalindrome("racecar"));
        logResult("LongestPalindrome", twoSum.bruteForce("babad"));
        logResult("LongestPalindrome", twoSum.bruteForce("racecar"));

        String isPalindrome = String.valueOf(twoSum.isPalindrome("bb"));
        logResult("isPalindrome", isPalindrome);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + ((len) / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    /*
        par = aabbaa
        impar = racecar
    */
    private int expandFromCenter(String s, int left, int right) {
        if (s == null || left > right)
            return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    /*
     * a
     * ab
     * abb
     * abba
     * abbaa
     * */
    private String bruteForce(String s) {
        String palindrome = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String current = s.substring(i, j + 1);
                if (isPalindrome(current) && current.length() > palindrome.length()) {
                    palindrome = current;
                }
            }
        }

        return palindrome;
    }

    private boolean isPalindrome(String s) {
        if (s == null)
            return false;

        int length = s.length();
        if (length == 1)
            return true;

        for (int i = 0; i < length; i++) {
            // index base end
            int end = (length - 1) - i;
            if (s.charAt(i) != s.charAt(end))
                return false;
        }

        return true;
    }

}
