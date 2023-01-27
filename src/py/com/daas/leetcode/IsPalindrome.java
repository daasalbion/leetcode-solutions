package py.com.daas.leetcode;

import static py.com.daas.leetcode.BaseExercise.logResult;

public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome function = new IsPalindrome();
        logResult("countSubstrings", String.valueOf(function.isPalindrome("A man, a plan, a canal: Panama")));
        logResult("countSubstrings", String.valueOf(function.isPalindrome("0P")));
    }

    /**
     * If a given char is not a letter or digit, it will be skipped.
     */
    public boolean isPalindrome(String s) {
        if (s == null)
            return false;
        if (s.length() == 1)
            return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            if (!Character.isLetter(lc) && !Character.isDigit(lc)) {
                left++;
                continue;
            }

            if (!Character.isLetter(rc) && !Character.isDigit(rc)) {
                right--;
                continue;
            }

            lc = Character.toLowerCase(lc);
            rc = Character.toLowerCase(rc);

            if (lc != rc) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
