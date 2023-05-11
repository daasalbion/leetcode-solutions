package py.com.daas.leetcode;

public class SingleNumber {

    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.

    Example 1:
    Input: nums = [2,2,1]
    Output: 1

    Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4
     */
    public static void main(String[] args) {
        SingleNumber exercise = new SingleNumber();
        System.out.println(exercise.singleNumber(new int[]{2, 2, 1}));
        System.out.println(exercise.singleNumber(new int[]{1, 2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
