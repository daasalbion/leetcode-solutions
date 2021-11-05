package py.com.daas.leetcode;

public class MinRotatedSortedArray {

  public static void main(String[] args) {
    MinRotatedSortedArray twoSum = new MinRotatedSortedArray();
    System.out.println("search = " + twoSum.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
  }

  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int start = 0;
    int end = nums.length - 1;
    int target = nums[nums.length - 1];

    // find the first element <= target
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] <= target) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    if (nums[start] <= target) {
      return nums[start];
    } else {
      return nums[end];
    }
  }
}
