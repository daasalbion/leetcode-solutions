package py.com.daas.leetcode;

public class MaxSubArray {

  public static void main(String[] args) {
    MaxSubArray twoSum = new MaxSubArray();
    System.out.println("maxSubArray = " + twoSum.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  public int maxSubArray(int[] nums) {
    int sum = nums[0];
    int maxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (sum < 0)
        sum = nums[i];
      else
        sum = sum + nums[i];
      maxSum = Math.max(sum, maxSum);
    }

    return maxSum;
  }

}
