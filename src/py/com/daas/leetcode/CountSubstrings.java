package py.com.daas.leetcode;

import static py.com.daas.leetcode.BaseExercise.logResult;

public class CountSubstrings {

    public static void main(String[] args) {
        CountSubstrings twoSum = new CountSubstrings();
        logResult("countSubstrings", String.valueOf(twoSum.countSubstrings("abc")));
        logResult("countSubstrings", String.valueOf(twoSum.countSubstrings("aaa")));
    }

    /*
     * case 1
     * s = "abc"
     * r = a, b, c
     * count = 3
     * case 2
     * s = "aaa"
     * r = a, a, a, aa, aa, aaa
     * count = 6
     * */
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1)
            return 0;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countFromCenter(s, i, i);
            count += countFromCenter(s, i, i + 1);
        }

        return count;
    }

    private int countFromCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }

}
