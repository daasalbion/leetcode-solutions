package py.com.daas.leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println("twoSum = " + Arrays.toString(twoSum.twoSum(new int[]{2,7,11,15}, 9)));
    }
}
