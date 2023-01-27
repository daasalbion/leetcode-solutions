package py.com.daas.leetcode.array;

import static py.com.daas.leetcode.BaseExercise.logResult;

import java.util.Arrays;

public class SlidingWindow {

    public static void main(String[] args) {
        logResult("SlidingWindow", Arrays.toString(slideWindow(new int[]{-1, 2, 3, 1, -3, 2}, 2)));
    }

    /**
     *    0  1  2  3   4  5
     *   -1, 2, 3, 1, -3, 2
     *   k =2
     *   i
     */
    public static int[] slideWindow(int[] nums, int k) {
        int n = nums.length;
        int maxSum = 0;
        int currentSum = 0;
        int ri = 0;
        int [] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            if (i < k) {
                maxSum = currentSum;
            } else {
                currentSum -= nums[i - k];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    ri++;
                }
            }
            result[ri] = maxSum;
        }

        return result;
    }
}
