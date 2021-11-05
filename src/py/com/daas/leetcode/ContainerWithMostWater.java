package py.com.daas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    ContainerWithMostWater twoSum = new ContainerWithMostWater();
    System.out.println("maxSubArray = " + twoSum.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  /*

  a + b + c = 0
  b + c = 0 - a
  * Solution: [[-1, 0, 1], [-1, -1, 2]]
  * order [-4, -1, -1, 2, 1, 2]
  * */
  public int maxArea(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    int max = 0;
    while (start < end) {
      max = Math.max(max, (end - start) * (Math.min(nums[start], nums[end])));
      if(nums[start] < nums[end]) {
        start++;
      } else {
        end--;
      }
    }

    return max;
  }

}
