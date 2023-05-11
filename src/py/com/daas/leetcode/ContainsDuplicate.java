package py.com.daas.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

    /*
        Given an integer array nums, return true if any value appears at least twice in the array,
        and return false if every element is distinct.
        Example 1:
        Input: nums = [1,2,3,1]
        Output: true

        Example 2:
        Input: nums = [1,2,3,4]
        Output: false
     */
    public static void main(String[] args) {
        ContainsDuplicate twoSum = new ContainsDuplicate();
        System.out.println("containsDuplicate = " + twoSum.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println("containsDuplicate = " + twoSum.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }

        return false;
    }


}
