package py.com.daas.leetcode;

import java.util.Arrays;

public class MergeSortedArray {

    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
    representing the number of elements in nums1 and nums2 respectively.
    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
    To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
    merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

    Example 1:
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

    Example 2:
    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]
    Explanation: The arrays we are merging are [1] and [].
    The result of the merge is [1].

    Example 3:
    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
    Output: [1]
    Explanation: The arrays we are merging are [] and [1].
    The result of the merge is [1].
    Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
     */
    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        mergeSortedArray.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{1};
        mergeSortedArray.merge(nums2, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = new int[]{0};
        mergeSortedArray.merge(nums3, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums3));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // m = x + n
        // x = is the total size of num1
        // size(num1) = m + n
        // size(num2) = n
        // m = 0 && n != 0 put elements from nums2 to nums1
        // n = 0 && m != 0 return nums1
        // m - 1 -> max(nums1)
        // n - 1 -> max(nums2)
        int i = m - 1; // nums1 -> 2
        int j = n - 1; // nums2 -> 2
        int x = nums1.length - 1; // nums2 -> 5
        // Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // Output: [1,2,2,3,5,6]

        // 0) [1,2,3,0,0,6], x = 4, n = 1
        // 1) [1,2,3,0,5,6], x = 3, n = 0
        // 2) [1,2,3,3,5,6], x = 3, n = 0
        // 3) [1,2,2,3,5,6], x = 3, n = 0
        while (j >= 0) {
            if (i >= 0 && nums2[j] < nums1[i]) {
                nums1[x] = nums1[i];
                i--;
            } else {
                nums1[x] = nums2[j];
                j--;
            }

            x--;
        }
    }
}
