package py.com.daas.leetcode;

public class StringToInteger {
    /*
    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

    The algorithm for myAtoi(string s) is as follows:

    Read in and ignore any leading whitespace.
    Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
    Return the integer as the final result.
    Note:

    Only the space character ' ' is considered a whitespace character.
    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

    Example 1:

    Input: s = "42"
    Output: 42
    Explanation: The underlined characters are what is read in, the caret is the current reader position.
    Step 1: "42" (no characters read because there is no leading whitespace)
             ^
    Step 2: "42" (no characters read because there is neither a '-' nor '+')
             ^
    Step 3: "42" ("42" is read in)
               ^
    The parsed integer is 42.
    Since 42 is in the range [-231, 231 - 1], the final result is 42.
    Example 2:

    Input: s = "   -42"
    Output: -42
    Explanation:
    Step 1: "   -42" (leading whitespace is read and ignored)
                ^
    Step 2: "   -42" ('-' is read, so the result should be negative)
                 ^
    Step 3: "   -42" ("42" is read in)
                   ^
    The parsed integer is -42.
    Since -42 is in the range [-231, 231 - 1], the final result is -42.

    Example 3:

    Input: s = "4193 with words"
    Output: 4193
    Explanation:
    Step 1: "4193 with words" (no characters read because there is no leading whitespace)
             ^
    Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
             ^
    Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
                 ^
    The parsed integer is 4193.
    Since 4193 is in the range [-2^31, 2^31 - 1], the final result is 4193.
     */
    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("9223372036854775808"));
        System.out.println(stringToInteger.myAtoi("   -42"));
        System.out.println(stringToInteger.myAtoi("words and 987"));
        System.out.println(stringToInteger.myAtoi("3.14159"));
        System.out.println(stringToInteger.myAtoi("+1"));
        System.out.println(stringToInteger.myAtoi(null));
        System.out.println(stringToInteger.myAtoi(""));
    }

    public int myAtoi(String s) {
        // check before digit is white space
        // check before digit is sign
        // check after digit is non digit character
        // previous character
        // current character
        /*
        "     -42d"
        pc = "-"
        cc = 4 -> 42 -> end
        return pc * cc
         */
        if (s == null || s.trim().length() == 0) return 0;

        String sTrimmed = s.trim();
        int sign = 1;
        int i = 0;
        double result = 0;

        char firstCharacter = sTrimmed.charAt(0);
        if (!Character.isDigit(firstCharacter)) {
            if (firstCharacter == '-') {
                sign = -1;
                i = 1;
            } else if (firstCharacter == '+') {
                i = 1;
            }
            else {
                return 0;
            }
        }

        for (; i < sTrimmed.length(); i++) {
            char c = sTrimmed.charAt(i);
            if (Character.isDigit(c)) {
                result = result * 10 + c-'0';
            } else {
                break;
            }
        }

        result = sign * result;

        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
