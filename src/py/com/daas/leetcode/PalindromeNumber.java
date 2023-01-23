package py.com.daas.leetcode;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber twoSum = new PalindromeNumber();
        //System.out.println("isPalindrome = " + twoSum.isPalindrome(1221));
        System.out.println("isPalindrome = " + twoSum.isPalindromeV2(1221));
        //System.out.println("isPalindrome = " + twoSum.isPalindromeV2(-121));
        System.out.println("isPalindrome = " + twoSum.isPalindromeV2(10));
        System.out.println("isPalindrome = " + twoSum.isPalindromeV2(123));
    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        boolean isValid = true;
        for (int i = 0; i < s.length(); i++) {
            int end = s.length() - (i + 1);
            if (s.charAt(i) != s.charAt(end)) {
                isValid = false;
            }
            if (i < end) break;
        }

        return isValid;
    }

    public boolean isPalindromeV2(int x) {
        // casos base
        // 1 tiene un solo digito mayor o igual a 0
        if (x >= 0 && x < 10) return true;
        // 2 le divide exactamente o es negativo
        if ((x % 10 == 0) || x < 0) return false;

        int aux = x;
        int rev = 0;

        do {
            int pop = aux % 10;
            aux = aux / 10;
            rev = rev * 10 + pop;
        } while (aux > 0);

        return x == rev;
    }

}
