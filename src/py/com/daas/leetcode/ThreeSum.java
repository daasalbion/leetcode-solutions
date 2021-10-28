package py.com.daas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    ThreeSum twoSum = new ThreeSum();
    System.out.println("maxSubArray = " + twoSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());
  }

  /*

  a + b + c = 0
  b + c = 0 - a
  * Solution: [[-1, 0, 1], [-1, -1, 2]]
  * order [-4, -1, -1, 2, 1, 2]
  * */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> rst = new ArrayList<>();
    if (nums.length == 0) return rst;

    for (int i = 0; i < nums.length; i++) {
      int target = -nums[i];
      int start = i + 1;
      int end = nums.length - 1;
      while (start < end) {
        if (nums[start] + nums[end] == target) {
          List<Integer> integers = new ArrayList<>();
          integers.add(nums[i]);
          integers.add(nums[start]);
          integers.add(nums[end]);
          rst.add(integers);
          // no repetitions
          while (start + 1 < end && nums[start + 1] == nums[start]) start++;
          while (end - 1 > start && nums[end - 1] == nums[end]) end--;
          start++;
          end--;
        } else if (nums[start] + nums[end] < target) {
          start++;
        } else {
          end--;
        }
      }
      // no repetitions
      while ((i + 1 < nums.length) && (nums[i + 1] == nums[i])) i++;
    }

    return rst;
  }

}
