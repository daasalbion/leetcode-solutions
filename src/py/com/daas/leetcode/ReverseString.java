package py.com.daas.leetcode;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString("HOla que tal".toCharArray());
    }

    public void reverseString(char[] s) {
        if (s.length < 2) return;
        // two pointers
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
}
