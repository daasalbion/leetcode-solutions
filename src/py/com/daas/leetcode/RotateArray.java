package py.com.daas.leetcode;

import java.util.Arrays;

public class RotateArray {

    /*
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

    Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Example 2:
    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]

    0) R([1,2,3,4,5,6,7]) -> [7,6,5,4,3,2,1]
    1) i < k -> R([7,6,5]) -> [5,6,7]
    2) i >= k -> R([4,3,2,1]) -> [1,2,3,4]
    3) [5,6,7] + [1,2,3,4]
     */
    public static void main(String[] args) {
        RotateArray exercise = new RotateArray();
        exercise.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        exercise.rotate(new int[]{1, 2}, 3);
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;
        int n = nums.length - 1;
        int newK = (nums.length > k) ? k : k - nums.length * (k / nums.length);
        reverse(nums, 0, n);
        reverse(nums, 0, newK - 1);
        reverse(nums, newK, n);
        System.out.printf("array = %s, k = %d%n", Arrays.toString(nums), k);
    }

    private void reverse(int[] array, int start, int end) {
        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }
}
