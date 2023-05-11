package py.com.daas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays2 {

    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
    appear as many times as it shows in both arrays and you may return the result in any order.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.

    Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000

    0) choose the smaller array as a pivot
    1) put it into a hashMap like 4 => 1, 9 => 1, 5 = 1
    2) hashMap = 9 => 2, 4 => 2, 8 = 1;
    3) 4 => 1, 9 => 1
    4) 4, 9
     */
    public static void main(String[] args) {
        IntersectionOfTwoArrays2 exercise = new IntersectionOfTwoArrays2();
        System.out.println(Arrays.toString(exercise.intersect(new int[]{4, 9, 4}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(exercise.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(exercise.intersect(new int[]{}, new int[]{9, 4, 9, 8, 4})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < 1 || nums2.length < 1) return new int[]{};

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 4, 4, 9
        // 4,4,8,9,9
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int [] res = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            res[k] = result.get(k);
        }

        return res;
    }
}
