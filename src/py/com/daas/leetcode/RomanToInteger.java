package py.com.daas.leetcode;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger twoSum = new RomanToInteger();
        System.out.println("romanToInt = " + twoSum.romanToInt("III"));
        System.out.println("romanToInt = " + twoSum.romanToInt("LVIII"));
        System.out.println("romanToInt = " + twoSum.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        if (s.length() == 1) {
            return romanMap.get(s);
        } else {
            int sum = romanMap.get(s.charAt(0));
            int previousNumber = sum;
            for (int i = 1; i < s.length(); i++) {
                int currentNumber = romanMap.get(s.charAt(i));
                if (previousNumber < currentNumber) {
                    sum += currentNumber - (previousNumber * 2);
                } else {
                    sum += currentNumber;
                }
                previousNumber = currentNumber;
            }

            return sum;
        }
    }

}
