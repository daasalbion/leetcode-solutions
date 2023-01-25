package py.com.daas.leetcode;

import static py.com.daas.leetcode.BaseExercise.logResult;

public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        LongestPalindromeSubseq twoSum = new LongestPalindromeSubseq();
        logResult("countSubstrings", String.valueOf(twoSum.longestPalindromeSubseq("BABCBAB")));
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() < 1)
            return 0;

        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][length - 1];
    }

}
