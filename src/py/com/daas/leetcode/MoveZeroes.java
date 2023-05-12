package py.com.daas.leetcode;

import java.util.Arrays;

public class MoveZeroes {

    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
    elements.
    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:
    Input: nums = [0]
    Output: [0]

    Constraints:
    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1


    Follow up: Could you minimize the total number of operations done?
     */
    public static void main(String[] args) {
        MoveZeroes exercise = new MoveZeroes();
        exercise.moveZeroes(new int[]{0, 1, 0, 3, 12});// 1, 3, 12, 0, 0
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j : nums) {
            if (j != 0) {
                nums[i++] = j;
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
