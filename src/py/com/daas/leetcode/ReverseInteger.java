package py.com.daas.leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(436));// 321
        System.out.println(reverseInteger.reverse(-123));// 321
        System.out.println(reverseInteger.reverse(Integer.MAX_VALUE + 1));// 321
    }

    public int reverse(int x) {
        /*
         result = 0;
         123 % 10 = 3 -> 0  * 10 + 3
         12  % 10 = 2 -> 30 * 10 + 2
         1   % 10 = 1 -> 32 * 10 + 1
         */
        double result = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            result = result * 10 + lastDigit;
            x /= 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;
    }
}
