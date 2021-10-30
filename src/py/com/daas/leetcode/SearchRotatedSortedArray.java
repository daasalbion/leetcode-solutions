package py.com.daas.leetcode;

public class SearchRotatedSortedArray {

  public static void main(String[] args) {
    SearchRotatedSortedArray twoSum = new SearchRotatedSortedArray();
    System.out.println("search = " + twoSum.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
  }

  public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[start] <= nums[mid]) {
        if (nums[start] <= target && target <= nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }

    return -1;
  }
}
