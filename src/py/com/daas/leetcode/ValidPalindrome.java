package py.com.daas.leetcode;

public class ValidPalindrome {
    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
    non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

    Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.
     */

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
        System.out.println(validPalindrome.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 1) return true;
        // iterate from left to right and from right to left until left > right
        // s[l] == s[r]
        char[] a = s.toCharArray();
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            char lc = Character.toLowerCase(a[left]);
            char rc = Character.toLowerCase(a[right]);
            boolean isValidLc = Character.isLetter(lc) || Character.isDigit(lc);
            boolean isValidRc = Character.isLetter(rc) || Character.isDigit(rc);
            if (isValidLc && isValidRc) {
                if (lc == rc) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } else if (!isValidLc) {
                left++;
            } else {
                right--;
            }
        }

        return true;
    }
}
