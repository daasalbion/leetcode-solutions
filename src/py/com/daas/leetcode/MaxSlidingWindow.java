package py.com.daas.leetcode;

import static py.com.daas.leetcode.BaseExercise.logResult;

import java.util.Arrays;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow function = new MaxSlidingWindow();
        logResult("maxSlidingWindow", Arrays.toString(function.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        logResult("maxSlidingWindow", Arrays.toString(function.maxSlidingWindow(new int[]{1, 3, -1, -3, 5}, 2)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;

        int i = 0;
        int resultLength = nums.length - k + 1;
        int[] result = new int[resultLength];

        do {
            int windowLength = i + k;
            result[i] = Integer.MIN_VALUE;
            for (int j = i; j < windowLength; j++) {
                if (nums[j] > result[i]) {
                    result[i] = nums[j];
                }
            }
            i++;
        } while (i < resultLength);

        return result;
    }
}
